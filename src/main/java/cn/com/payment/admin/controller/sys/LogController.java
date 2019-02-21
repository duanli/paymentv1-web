package cn.com.payment.admin.controller.sys;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.payment.admin.contansts.Constants;
import cn.com.payment.admin.dto.PageEasyUi;
import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.Log;
import cn.com.payment.admin.service.LogService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("log")
public class LogController {
	private static final String PREFIX = "sys/";
	private static final Logger logger = LoggerFactory.getLogger(LogController.class.getName());
	@Autowired
	private LogService logService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toLogPage")
	@RequiresPermissions("log:view")
	public String toLogPage() {
		return PREFIX + "log";
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getLogPage")
	@RequiresPermissions("log:view")
	public @ResponseBody PageEasyUi<Log> getLogPage(Integer page, Integer rows, Log entity) {
		PageEasyUi<Log> result = null;
		try {
			PageUtils.initPages(page, rows);
			List<Log> list = this.logService.searchByProperty(entity);
			result = new PageEasyUi<Log>(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 新建数据
	 * 
	 * @param log
	 * @return
	 */
	@RequestMapping("addLog")
	@RequiresPermissions("log:add")
	public @ResponseBody ResponseEntity<String> addLog(Log log) {
		if (CommonUtils.isEmpty(log))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			this.logService.create(log);
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
	@RequestMapping("updateLog")
	@RequiresPermissions("log:update")
	public @ResponseBody ResponseEntity<String> updateLog(Log log) {
		if (CommonUtils.isEmpty(log) || CommonUtils.isEmpty(log.getLogId()))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			Log data = this.logService.searchById(log.getLogId());
			if (CommonUtils.isNotEmpty(data)) {
				if (CommonUtils.isNotEmpty(log.getLogId()))
					data.setLogId(log.getLogId());
				if (CommonUtils.isNotEmpty(log.getType()))
					data.setType(log.getType());
				if (CommonUtils.isNotEmpty(log.getTitle()))
					data.setTitle(log.getTitle());
				if (CommonUtils.isNotEmpty(log.getUserId()))
					data.setUserId(log.getUserId());
				if (CommonUtils.isNotEmpty(log.getStartDate()))
					data.setStartDate(log.getStartDate());
				if (CommonUtils.isNotEmpty(log.getTimeout()))
					data.setTimeout(log.getTimeout());
				if (CommonUtils.isNotEmpty(log.getUserAgent()))
					data.setUserAgent(log.getUserAgent());
				if (CommonUtils.isNotEmpty(log.getRequestUri()))
					data.setRequestUri(log.getRequestUri());
				if (CommonUtils.isNotEmpty(log.getMethod()))
					data.setMethod(log.getMethod());
				if (CommonUtils.isNotEmpty(log.getParams()))
					data.setParams(log.getParams());
				if (CommonUtils.isNotEmpty(log.getRemark()))
					data.setRemark(log.getRemark());

				this.logService.modify(data);
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
	@RequestMapping("deleteLog")
	@RequiresPermissions("log:delete")
	public @ResponseBody ResponseEntity<String> deleteLog(String param) {
		if (CommonUtils.isEmpty(param))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		Long[] ids = null;
		try {
			String[] params = param.split(",");
			ids = new Long[params.length];
			for (int i = 0, len = params.length; i < len; i++) {
				ids[i] = Long.valueOf(params[i]);
			}
		} catch (NumberFormatException e1) {
			return new ResponseEntity<String>("参数格式错误！", HttpStatus.BAD_REQUEST);
		}

		try {
			this.logService.remove(ids);
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
	@RequestMapping("getLogById")
	@RequiresPermissions("log:view")
	public @ResponseBody ResponseEntity getLogById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			Log log = this.logService.searchById(id);
			if (null != log)
				return new ResponseEntity<Log>(log, HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}