package cn.com.payment.admin.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.Admin;
import cn.com.payment.admin.model.Role;

public interface AdminRoleService extends BaseService<Admin, Long> {
	/**
	 * 新建用户信息
	 * 
	 * @param admin
	 * @throws BizException
	 * @throws Exception
	 */
	public void createAdmin(Admin admin) throws BaseException, Exception;

	/**
	 * 根据角色id批量删除角色相关的信息
	 * <ol>
	 * <li>删除角色相关信息</li>
	 * <li>删除角色权限相关信息</li>
	 * <li>删除管理员角色相关信息</li>
	 * </ol>
	 * 
	 * @param ids
	 * @throws BizException
	 */
	void deleteCascadeRole(Long[] ids) throws Exception;

	/**
	 * 创建角色
	 * 
	 * @param role
	 * @throws Exception
	 */
	void createRole(Role role) throws BaseException, Exception;

	/**
	 * 角色更新
	 * 
	 * @param role
	 * @throws BizException
	 * @throws Exception
	 */
	void updateRole(Role role) throws BaseException, Exception;

	/**
	 * 获取角色分页数据
	 * 
	 * @param role
	 * @return
	 * @throws BizException
	 * @throws DataAccessException
	 */
	List<Role> searchRolePage(Role role) throws BaseException,
			DataAccessException;

	/**
	 * 根据id获取角色信息
	 * 
	 * @param id
	 * @return
	 * @throws BizException
	 * @throws DataAccessException
	 */
	Role searchRoleById(Long id) throws BaseException;

	/**
	 * 创建用户角色关联
	 * 
	 * @param users
	 * @param roles
	 * @throws Exception 
	 * @throws BizException
	 */
	void createAdminRole(Long[] users, Long[] roles) throws BaseException, Exception;

	/**
	 * 获取用户和角色列表
	 * 
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	List<Admin> searchAdminAndRole(Admin admin) throws Exception;
}
