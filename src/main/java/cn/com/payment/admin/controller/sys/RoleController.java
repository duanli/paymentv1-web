package cn.com.payment.admin.controller.sys;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.payment.admin.annotation.SystemControllerLog;
import cn.com.payment.admin.contansts.Constants;
import cn.com.payment.admin.dto.PageEasyUi;
import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.Role;
import cn.com.payment.admin.service.AdminRoleService;
import cn.com.payment.admin.service.RoleAuthService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("role")
public class RoleController {
	private static final String PREFIX = "sys/";
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class.getName());
	@Autowired
	private AdminRoleService roleService;
	@Autowired
	private RoleAuthService roleAuthService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toRolePage")
	@RequiresPermissions("role:view")
	public String toRolePage() {
		return PREFIX + "role";
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getRolePage")
	@RequiresPermissions("role:view")
	public @ResponseBody PageEasyUi<Role> getRolePage(Integer page ,Integer rows, Role entity) {
		PageEasyUi<Role> result = null;
		try {
			PageUtils.initPages(page, rows);
			List<Role> list = this.roleService.searchRolePage(entity);
			result = new PageEasyUi<Role>(list);
		} catch (DataAccessException | BaseException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 新建数据
	 * 
	 * @param role
	 * @return
	 */
	@SystemControllerLog(description="添加角色",type="2")
	@RequestMapping("addRole")
	@RequiresPermissions("role:add")
	public @ResponseBody ResponseEntity<String> addRole(Role role) {
		if (CommonUtils.isEmpty(role))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		try {
			this.roleService.createRole(role);
			return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 更新数据
	 * 
	 * @param entity
	 * @param id
	 * @return
	 */
	@SystemControllerLog(description="更新角色",type="2")
	@RequestMapping("updateRole")
	@RequiresPermissions("role:update")
	public @ResponseBody ResponseEntity<String> updateRole(Role role) {
		if (null == role || CommonUtils.isEmpty(role.getId()))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		try {
			this.roleService.updateRole(role);
			return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 删除数据
	 * 
	 * @param param
	 * @return
	 */
	@SystemControllerLog(description="删除角色",type="2")
	@RequestMapping("deleteRole")
	@RequiresPermissions("role:delete")
	public @ResponseBody ResponseEntity<String> deleteRole(String param) {
		if (CommonUtils.isEmpty(param))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		Long[] ids = null;
		try {
			String[] params = param.split(",");
			ids = new Long[params.length];
			for (int i = 0, len = params.length; i < len; i++) {
				if (!"1".equals(params[i])&&!"28".equals(params[i])&&!"29".equals(params[i])) {// 不允許刪除超級管理員,机构、部门管理员
					ids[i] = Long.valueOf(params[i]);
				}
			}
		} catch (NumberFormatException e1) {
			return new ResponseEntity<String>("参数格式错误！", HttpStatus.BAD_REQUEST);
		}
		try {
			this.roleService.deleteCascadeRole(ids);
			return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 根据id获取信息
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("getRoleById")
	@RequiresPermissions("role:view")
	public @ResponseBody ResponseEntity getRoleById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		try {
			Role role = this.roleService.searchRoleById(id);
			if (null != role)
				return new ResponseEntity<Role>(role, HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@SystemControllerLog(description="分配菜单",type="2")
	@SuppressWarnings("rawtypes")
	@RequestMapping("/addRoleAuth")
	@RequiresPermissions("role:addRoleAuth")
	public @ResponseBody ResponseEntity addRoleAuth(Long roleId, String roles) {
		if (CommonUtils.isEmpty(roleId, roles))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		try {
			String[] params = roles.split(",");
			Long[] ids = new Long[params.length];
			for (int i = 0, len = params.length; i < len; i++) {
				ids[i] = Long.valueOf(params[i]);
			}

			this.roleAuthService.createRoleAuth(roleId, ids);
			return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}