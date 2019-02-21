package cn.com.payment.admin.controller.context;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.payment.admin.model.Admin;
import cn.com.payment.admin.model.Menu;
import cn.com.payment.admin.model.Role;
import cn.com.payment.admin.service.AdminRoleService;
import cn.com.payment.admin.service.RoleAuthService;
import cn.com.payment.admin.utils.CommonUtils;

/**
 * <ul>
 * 	<li>Realm：域，Shiro从从Realm获取安全数据（如用户、角色、权限）</li>
 * 	<li>SecurityManager要验证用户身份，那么它需要从Realm获取相应的用户进行比较以确定用户身份是否合法</li>
 * 	<li>也需要从Realm得到用户相应的角色/权限进行验证用户是否能进行操作；可以把Realm看成DataSource，即安全数据源</li>
 * </ul>
 * <ul>
 * 	<li>AuthorizingRealm 的父类有：AuthenticatingRealm（即身份验证）CachingRealm（带有缓存实现）</li>
 * </ul>
 * @author rono
 */
public class CustomerUserRealm extends AuthorizingRealm{
	private Logger logger = LogManager.getLogger(CustomerUserRealm.class);
	@Autowired
	private AdminRoleService adminRoleService;
	@Autowired
	private RoleAuthService roleAuthService;
	/**
	 * 初始化加密认证机制
	 */
	public CustomerUserRealm() {
		super.setAuthenticationCachingEnabled(false);
		// 授权
		super.setAuthorizationCacheName("authorizationCache");
		HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher("MD5");
		credentialsMatcher.setHashIterations(2); //  两次加密
		credentialsMatcher.setStoredCredentialsHexEncoded(true);
		setCredentialsMatcher(credentialsMatcher);
	}

	/**
	 * 身份认证/登录
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		final String userName = (String)token.getPrincipal(); // principals：身份，即主体的标识属性，可以是任何东西，如用户名、邮箱等
		//final String pswd = (String)token.getCredentials(); // credentials：证明/凭证，即只有主体知道的安全值，如密码/数字证书等。
		
		List<Admin> list =null;
		try {
			list = adminRoleService.searchByProperty(new Admin(userName,false));
		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
		}
		
		if(null ==list || list.size()==0)
			 throw new UnknownAccountException();//没找到帐号
		
		Admin admin = list.get(0);
		if(null != admin.getLocked() && admin.getLocked())
			throw new LockedAccountException(); //帐号锁定
		
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
		SimpleAuthenticationInfo authenticationInfo = 
			 new SimpleAuthenticationInfo(  
			 	userName, //用户名  
			 	admin.getPswd(), //密码  
                ByteSource.Util.bytes(admin.getSalt()),//salt = username+salt  
                getName()  //realm name  
        );  
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("merId", list.get(0).getMerId());
		session.setAttribute("merAgentId", list.get(0).getMerAgentId());
		session.setAttribute("proAgentId", list.get(0).getProAgentId());
		session.setAttribute("type", list.get(0).getProAgentId());
		session.setAttribute("adminId", list.get(0).getId());
		return authenticationInfo;
	}
	/**
	 * 授权，即权限验证，验证某个已认证的用户是否拥有某个权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		try {
			String username = (String) principals.getPrimaryPrincipal();
			if(CommonUtils.isNotEmpty(username)){
				List<Admin> list = adminRoleService.searchAdminAndRole(new Admin(username, false));
				if(null!=list && list.size()>0){
					Admin admin = list.get(0);
					List<Role> roles = admin.getRoles();
					Set<String> roleStrings = new HashSet<String>();
					Set<String> permissionStrings = new HashSet<String>();
					
					if(null!=roles && roles.size()>0){
						Long[] roleIds = new Long[roles.size()];
						for(int i=0;i<roles.size();i++){
							Role r = roles.get(i);
							roleIds[i] = r.getId();
							roleStrings.add(r.getEnName());
						}
						Menu menu = new Menu();
						menu.setRoleIds(roleIds);
						menu.setMenuType(1);
						List<Menu> listMens = this.roleAuthService.searchRoleMenu(menu);
						if(null!=listMens && listMens.size()>0){
							for (Menu m : listMens) {
								if(CommonUtils.isNotEmpty(m.getPermission())){
									permissionStrings.add(m.getPermission());
									//System.out.println(m.getPermission());
								}
							}
						}
					}
					SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
					authorizationInfo.setRoles(roleStrings);
					authorizationInfo.setStringPermissions(permissionStrings);
					// 更新用户登录信息
					admin.setLastActivity(new Date());
					admin.setLoginCount(admin.getLoginCount()!=null?admin.getLoginCount().intValue()+1:1);
					this.adminRoleService.modify(admin);
					return authorizationInfo;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}
}