package cn.com.payment.admin.controller.sys;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.payment.admin.annotation.SystemControllerLog;
import cn.com.payment.admin.contansts.Constants;
import cn.com.payment.admin.controller.context.PasswordHelper;
import cn.com.payment.admin.dto.IResponse;
import cn.com.payment.admin.dto.PageEasyUi;
import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.Admin;
import cn.com.payment.admin.model.Role;
import cn.com.payment.admin.service.AdminRoleService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("admin")
public class AdminController {
	private static final String PREFIX = "sys/";
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class.getName());
	@Autowired
	private AdminRoleService adminService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toAdminPage")
	@RequiresPermissions("admin:view")
	public String toAdminPage(Model model) {
		Role role = new Role();
		List<Role> roleList = null;
		try {
			roleList = adminService.searchRolePage(role);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (BaseException e) {
			e.printStackTrace();
		}
		model.addAttribute("roleList", roleList);
		return PREFIX + "admin";
	}

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toSetPassWordPage")
	@RequiresPermissions("admin:setPassWord")
	public String toSetPassWordPage(Model model) {
		// session 获取用户身份
		Long adminId = (Long) SecurityUtils.getSubject().getSession().getAttribute("adminId");
		if (CommonUtils.isEmpty(adminId))
			return "402";
		Admin data;
		try {
			data = this.adminService.searchById(adminId);
			if (CommonUtils.isNotEmpty(data)) {
				model.addAttribute("userName", data.getUserName());
				return PREFIX + "setPassword";
			} else
				return "402";
		} catch (BaseException e) {
			e.printStackTrace();
			return "402";
		}
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getAdminPage")
	@RequiresPermissions("admin:view")
	public @ResponseBody PageEasyUi<Admin> getAdminPage(Integer page, Integer rows, Admin entity) {
		PageEasyUi<Admin> result = null;
		try {
			PageUtils.initPages(page, rows);
			List<Admin> list = this.adminService.searchByProperty(entity);
			result = new PageEasyUi<Admin>(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 新建数据
	 * 
	 * @param admin
	 * @return
	 */
	@SystemControllerLog(description = "添加用户", type = "2")
	@RequestMapping("addAdmin")
	@RequiresPermissions("admin:add")
	public @ResponseBody ResponseEntity<String> addAdmin(Admin admin) {
		if (CommonUtils.isEmpty(admin))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			new PasswordHelper().encryptPasswor(admin);
			this.adminService.createAdmin(admin);
			return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 更新数据
	 * 
	 * @param entity
	 * @param id
	 * @return
	 */
	@SystemControllerLog(description = "修改密码", type = "2")
	@RequestMapping("setPassWord")
	@RequiresPermissions("admin:setPassWord")
	public @ResponseBody ResponseEntity<String> setPassWord(String pswd, String rePswd) {
		if (CommonUtils.isEmpty(pswd))
			return new ResponseEntity<String>("新密码为空", HttpStatus.BAD_REQUEST);
		if (CommonUtils.isEmpty(rePswd))
			return new ResponseEntity<String>("确认密码为空", HttpStatus.BAD_REQUEST);
		if (!pswd.equals(rePswd))
			return new ResponseEntity<String>("两次输入的密码不一致", HttpStatus.BAD_REQUEST);
		// session 获取用户身份
		Long adminId = (Long) SecurityUtils.getSubject().getSession().getAttribute("adminId");
		if (CommonUtils.isEmpty(adminId))
			return new ResponseEntity<String>("非法请求", HttpStatus.BAD_REQUEST);
		try {
			Admin data = this.adminService.searchById(adminId);
			if (CommonUtils.isNotEmpty(data)) {
				data.setPswd(pswd);
				new PasswordHelper().encryptPasswor(data);
				this.adminService.modify(data);
				return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
			} else
				return new ResponseEntity<String>("用户数据不存在", HttpStatus.BAD_REQUEST);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 更新数据
	 * 
	 * @param entity
	 * @param id
	 * @return
	 */
	@SystemControllerLog(description = "修改用户", type = "2")
	@RequestMapping("updateAdmin")
	public @ResponseBody ResponseEntity<String> updateAdmin(Admin admin) {
		if (null == admin || CommonUtils.isEmpty(admin.getId()))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);
		try {
			Admin data = this.adminService.searchById(admin.getId());
			if (CommonUtils.isNotEmpty(data)) {
				if (CommonUtils.isNotEmpty(admin.getName()))
					data.setName(admin.getName());
				if (CommonUtils.isNotEmpty(admin.getMateName()))
					data.setMateName(admin.getMateName());
				if (CommonUtils.isNotEmpty(admin.getGender()))
					data.setGender(admin.getGender());
				if (CommonUtils.isNotEmpty(admin.getCellPhone()))
					data.setCellPhone(admin.getCellPhone());
				if (CommonUtils.isNotEmpty(admin.getPhoto()))
					data.setPhoto(admin.getPhoto());
				if (CommonUtils.isNotEmpty(admin.getEmail()))
					data.setEmail(admin.getEmail());
				if (CommonUtils.isNotEmpty(admin.getState()))
					data.setState(admin.getState());
				if (CommonUtils.isNotEmpty(admin.getDuty()))
					data.setDuty(admin.getDuty());
				if (CommonUtils.isNotEmpty(admin.getLocked()))
					data.setLocked(admin.getLocked());
				if (CommonUtils.isNotEmpty(admin.getAccNo()))
					data.setAccNo(admin.getAccNo());
				if (CommonUtils.isNotEmpty(admin.getEmail()))
					data.setEmail(admin.getEmail());
				if (CommonUtils.isNotEmpty(admin.getAccounts()))
					data.setAccounts(admin.getAccounts());
				if (CommonUtils.isNotEmpty(admin.getRemark()))
					data.setRemark(admin.getRemark());
				if (CommonUtils.isNotEmpty(admin.getPswd())) {
					data.setPswd(admin.getPswd());
					new PasswordHelper().encryptPasswor(data);
				}
				if (CommonUtils.isNotEmpty(admin.getMerId())) {
					data.setMerId(admin.getMerId());
				}
				if (CommonUtils.isNotEmpty(admin.getMerAgentId())) {
					data.setMerAgentId(admin.getMerAgentId());
				}

				this.adminService.modify(data);
				return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
			} else
				return new ResponseEntity<String>("数据不存在！", HttpStatus.BAD_REQUEST);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 删除数据
	 * 
	 * @param param
	 * @return
	 */
	@SystemControllerLog(description = "删除用户", type = "2")
	@RequestMapping("deleteAdmin")
	@RequiresPermissions("admin:delete")
	public @ResponseBody ResponseEntity<String> deleteAdmin(String param) {
		if (CommonUtils.isEmpty(param))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		Long[] ids = null;
		try {
			String[] params = param.split(",");
			ids = new Long[params.length];
			for (int i = 0, len = params.length; i < len; i++) {
				if (!"1".equals(params[i])) {// 不允許刪除超級管理員admin
					ids[i] = Long.valueOf(params[i]);
				}
			}
		} catch (NumberFormatException e1) {
			return new ResponseEntity<String>("参数格式错误！", HttpStatus.BAD_REQUEST);
		}

		try {
			this.adminService.remove(ids);
			return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 根据id获取信息
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("getAdminById")
	@RequiresPermissions("admin:view")
	public @ResponseBody ResponseEntity getAdminById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			Admin admin = this.adminService.searchById(id);
			if (null != admin)
				return new ResponseEntity<Admin>(admin, HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (BaseException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// ******************************************* 分割线
	// ******************************************************
	/**
	 * 检测用户名是否存在
	 * 
	 * @param userName
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("checkAdminUserExists")
	@RequiresPermissions("admin:view")
	public @ResponseBody ResponseEntity checkAdminUserExists(String userName) {
		if (CommonUtils.isEmpty(userName))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			List<Admin> list = this.adminService.searchByProperty(new Admin(userName, false));
			if (null != list && list.size() > 0)
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			else
				return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 添加用户角色关联
	 * 
	 * @param users
	 * @param roles
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("addAdminRole")
	@RequiresPermissions("admin:addAdminRole")
	public @ResponseBody ResponseEntity addAdminRole(String users, String roles) {
		if (CommonUtils.isEmpty(users, roles))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			// 用户id
			String[] uparams = users.split(",");
			Long[] uids = new Long[uparams.length];
			for (int i = 0, len = uparams.length; i < len; i++) {
				uids[i] = Long.valueOf(uparams[i]);
			}
			// 角色id
			String[] rparams = roles.split(",");
			Long[] rids = new Long[rparams.length];
			for (int i = 0, len = rparams.length; i < len; i++) {
				rids[i] = Long.valueOf(rparams[i]);
			}

			this.adminService.createAdminRole(uids, rids);
			return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getCode(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 获取用户信息
	 * 
	 * @param userNames
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("getAdmin")
//	@RequiresPermissions("admin:view")
	public @ResponseBody ResponseEntity getAdmin(final String userName) {
		if (CommonUtils.isEmpty(userName))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			List<Admin> list = this.adminService.searchAdminAndRole(new Admin(userName, false));
			if (null != list && list.size() > 0) {
				Admin admin = list.get(0);
				admin.setPswd(null);
				admin.setSalt(null);
				return new ResponseEntity<Admin>(list.get(0), HttpStatus.OK);
			} else
				return new ResponseEntity<String>(IResponse.DATA_NOT_FONUD, HttpStatus.NO_CONTENT);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}