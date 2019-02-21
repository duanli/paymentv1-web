package cn.com.payment.admin.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.MenuMapper;
import cn.com.payment.admin.mapper.RoleAuthMapper;
import cn.com.payment.admin.model.Menu;
import cn.com.payment.admin.model.RoleAuth;
import cn.com.payment.admin.service.RoleAuthService;

@Service
public class RoleAuthServiceImpl extends BaseServiceImpl<Menu, Long> implements RoleAuthService {
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private RoleAuthMapper roleAuthMapper;

	@Override
	public BaseMapper<Menu, Long> getBaseMapper() {
		// TODO Auto-generated method stub
		return menuMapper;
	}

	@Override
	public List<Menu> searchTreeMenu(Menu menu) throws Exception {
		return menuMapper.selectTreeMenu(menu);
	}

	@Override
	public void createRoleAuth(Long roleId, Long[] roles) throws BaseException, Exception {
		this.roleAuthMapper.deleteByPKs(new Long[] { roleId });
		for (Long role : roles) {
			this.roleAuthMapper.save(new RoleAuth(roleId, role));
		}
	}

	/**
	 * 角色管理的菜单
	 */
	@Override
	public List<Menu> searchRoleMenu(Menu menu) throws Exception {
		return menuMapper.selectRoleMenu(menu);
	}

	@Override
	public List<Menu> searchRoleMenuTree(Menu menu) throws Exception {
		List<Menu> list = this.menuMapper.selectRoleMenu(menu);
		if (null != list && list.size() > 0) {
			Iterator<Menu> iter = list.iterator();
			while (iter.hasNext()) {
				Menu m = iter.next();
				List<Menu> child = this.menuMapper
						.selectRoleMenu(new Menu(m.getId(), menu.getMenuType(), menu.getRoleIds()));
				if (null != child && child.size() > 0)
					m.setChildren(child);
			}
		}
		return list;
	}
}
