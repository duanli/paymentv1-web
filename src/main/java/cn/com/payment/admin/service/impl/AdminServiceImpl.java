package cn.com.payment.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.mapper.AdminMapper;
import cn.com.payment.admin.mapper.AdminRoleMapper;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.RoleAuthMapper;
import cn.com.payment.admin.mapper.RoleMapper;
import cn.com.payment.admin.model.Admin;
import cn.com.payment.admin.model.AdminRole;
import cn.com.payment.admin.model.Role;
import cn.com.payment.admin.service.AdminRoleService;
import cn.com.payment.admin.utils.CommonUtils;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, Long> implements AdminRoleService {
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleAuthMapper roleAuthMapper;
	@Autowired
	private AdminRoleMapper adminRoleMapper;

	@Override
	public BaseMapper<Admin, Long> getBaseMapper() {
		return adminMapper;
	}

	@Override
	public void createAdmin(Admin admin) throws BaseException, Exception {
		final String userName = admin.getUserName();
		List<Admin> list = this.adminMapper.selectByProperty(new Admin(userName, false));
		if (null != list && list.size() > 0) {
			if (!list.get(0).getId().equals(admin.getId()))
				throw new BaseException("用户名已存在！");
		}
		this.adminMapper.save(admin);
	}

	@Override
	public void deleteCascadeRole(Long[] ids) throws Exception {
		this.roleMapper.deleteByPKs(ids);
		this.roleAuthMapper.deleteByPKs(ids);
		this.adminRoleMapper.deleteByRoleIds(ids);
	}

	@Override
	public void createRole(Role role) throws BaseException, Exception {
		final String eName = role.getEnName();
		List<Role> listRole = this.roleMapper.selectByProperty(new Role(eName));
		if (null != listRole && listRole.size() > 0)
			throw new BaseException("角色英文名称已经存在!");

		roleMapper.save(role);
	}

	@Override
	public void updateRole(Role role) throws BaseException, Exception {
		Role data = this.roleMapper.selectOne(role.getId());

		if (null != data) {
			List<Role> listRole = this.roleMapper.selectByProperty(new Role(role.getEnName()));
			if (null != listRole && listRole.size() > 0) {
				Role r = listRole.get(0);
				if (!r.getId().equals(role.getId()))
					throw new BaseException("角色英文名称已经存在!");
			}

			if (CommonUtils.isNotEmpty(role.getId()))
				data.setId(role.getId());
			if (CommonUtils.isNotEmpty(role.getName()))
				data.setName(role.getName());
			if (CommonUtils.isNotEmpty(role.getEnName()))
				data.setEnName(role.getEnName());
			if (CommonUtils.isNotEmpty(role.getRemark()))
				data.setRemark(role.getRemark());
			if (CommonUtils.isNotEmpty(role.getIsDel()))
				data.setIsDel(role.getIsDel());
			this.roleMapper.update(data);
		} else
			throw new BaseException("角色信息不存在！");
	}

	@Override
	public List<Role> searchRolePage(Role role) throws BaseException {
		return roleMapper.selectByProperty(role);
	}

	@Override
	public Role searchRoleById(Long id) throws BaseException, DataAccessException {
		return roleMapper.selectOne(id);
	}

	@Override
	public void createAdminRole(Long[] users, Long[] roles) throws Exception {
		adminRoleMapper.deleteByPKs(users);
		for (Long uid : users) {
			// 查询用户信息
			Admin data = adminMapper.selectOne(uid);
			for (Long rid : roles) {
				// 检测分配的角色并且更具角色逻辑判断是否需要选择机构和部门
				if (CommonUtils.isNotEmpty(data)) {
					Admin admin = new Admin();
					admin.setId(uid);
					adminMapper.updateForDepartmentId(admin);
					adminRoleMapper.save(new AdminRole(uid, rid));
				}
			}

		}
	}

	@Override
	public List<Admin> searchAdminAndRole(Admin admin) throws Exception {
		return adminMapper.selectAdminAndRole(admin);
	}
}
