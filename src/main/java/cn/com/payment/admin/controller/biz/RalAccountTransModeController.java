package cn.com.payment.admin.controller.biz;

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
import cn.com.payment.admin.model.RalAccountTransMode;
import cn.com.payment.admin.model.RalAccountTransModeForMer;
import cn.com.payment.admin.model.RalProviderTransMode;
import cn.com.payment.admin.service.RalAccountTransModeService;
import cn.com.payment.admin.utils.AmtUtils;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("ralAccountTransMode")
public class RalAccountTransModeController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(RalAccountTransModeController.class.getName());
	@Autowired
	private RalAccountTransModeService ralAccountTransModeService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toRalAccountTransModePage")
	@RequiresPermissions("ralAccountTransMode:view")
	public String toRalAccountTransModePage() {
		return PREFIX + "ralAccountTransMode";
	}

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toProAccInfoPage")
	@RequiresPermissions("proAccInfo:view")
	public String toProAccInfoPage() {
		return PREFIX + "ralAccountTransModeForMer";
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getProAccInfoList")
	@RequiresPermissions("proAccInfo:view")
	public @ResponseBody PageEasyUi<RalAccountTransModeForMer> getProAccInfoList(
			PageEasyUi<RalAccountTransModeForMer> page, RalAccountTransMode entity) {
		PageEasyUi<RalAccountTransModeForMer> result = null;
		try {
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<RalAccountTransModeForMer> list = this.ralAccountTransModeService
					.searchRalAccountTransModeList(entity);
			result = new PageEasyUi<RalAccountTransModeForMer>(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getRalAccountTransModePage")
	@RequiresPermissions("ralAccountTransMode:view")
	public @ResponseBody PageEasyUi<RalAccountTransMode> getRalAccountTransModePage(
			PageEasyUi<RalAccountTransMode> page, RalAccountTransMode entity) {
		PageEasyUi<RalAccountTransMode> result = null;
		try {
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<RalAccountTransMode> list = this.ralAccountTransModeService.searchByProperty(entity);
			result = new PageEasyUi<RalAccountTransMode>(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 新建数据
	 * 
	 * @param ralAccountTransMode
	 * @return
	 */
	@RequestMapping("addRalAccountTransMode")
	@RequiresPermissions("ralAccountTransMode:add")
	public @ResponseBody ResponseEntity<String> addRalAccountTransMode(RalAccountTransMode ralAccountTransMode,
			String sminAmt, String smaxAmt, String stotleAmt) {
		if (CommonUtils.isEmpty(ralAccountTransMode))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			if (CommonUtils.isNotEmpty(stotleAmt))
				ralAccountTransMode.setTotleAmtLimit(Long.valueOf(AmtUtils.yuanToFen(stotleAmt)));
			if (CommonUtils.isNotEmpty(sminAmt))
				ralAccountTransMode.setMinAmt(Long.valueOf(AmtUtils.yuanToFen(sminAmt)));
			if (CommonUtils.isNotEmpty(smaxAmt))
				ralAccountTransMode.setMaxAmt(Long.valueOf(AmtUtils.yuanToFen(smaxAmt)));
			this.ralAccountTransModeService.create(ralAccountTransMode);
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
	@RequestMapping("updateRalAccountTransMode")
	@RequiresPermissions("ralAccountTransMode:update")
	public @ResponseBody ResponseEntity<String> updateRalAccountTransMode(RalAccountTransMode ralAccountTransMode,
			String sminAmt, String smaxAmt, String stotleAmt) {
		if (CommonUtils.isEmpty(ralAccountTransMode) || CommonUtils.isEmpty(ralAccountTransMode.getRalAccProductId()))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			RalAccountTransMode data = this.ralAccountTransModeService
					.searchById(ralAccountTransMode.getRalAccProductId());
			if (CommonUtils.isNotEmpty(data)) {
				if (CommonUtils.isNotEmpty(ralAccountTransMode.getRalAccProductId()))
					data.setRalAccProductId(ralAccountTransMode.getRalAccProductId());
				if (CommonUtils.isNotEmpty(ralAccountTransMode.getMchId()))
					data.setMchId(ralAccountTransMode.getMchId());
				if (CommonUtils.isNotEmpty(ralAccountTransMode.getProviderAccId()))
					data.setProviderAccId(ralAccountTransMode.getProviderAccId());
				if (CommonUtils.isNotEmpty(ralAccountTransMode.getProductId()))
					data.setProductId(ralAccountTransMode.getProductId());
				if (CommonUtils.isNotEmpty(ralAccountTransMode.getFeeRate()))
					data.setFeeRate(ralAccountTransMode.getFeeRate());
				if (CommonUtils.isNotEmpty(stotleAmt))
					data.setTotleAmtLimit(Long.valueOf(AmtUtils.yuanToFen(stotleAmt)));
				if (CommonUtils.isNotEmpty(sminAmt))
					data.setMinAmt(Long.valueOf(AmtUtils.yuanToFen(sminAmt)));
				if (CommonUtils.isNotEmpty(smaxAmt))
					data.setMaxAmt(Long.valueOf(AmtUtils.yuanToFen(smaxAmt)));
				if (CommonUtils.isNotEmpty(ralAccountTransMode.getRestrictState()))
					data.setRestrictState(ralAccountTransMode.getRestrictState());
				if (CommonUtils.isNotEmpty(ralAccountTransMode.getSettleType()))
					data.setSettleType(ralAccountTransMode.getSettleType());
				if (CommonUtils.isNotEmpty(ralAccountTransMode.getPercentage()))
					data.setPercentage(ralAccountTransMode.getPercentage());
				if (CommonUtils.isNotEmpty(ralAccountTransMode.getState()))
					data.setState(ralAccountTransMode.getState());
				if (CommonUtils.isNotEmpty(ralAccountTransMode.getValidIP()))
					data.setValidIP(ralAccountTransMode.getValidIP());

				this.ralAccountTransModeService.modify(data);
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
	@RequestMapping("deleteRalAccountTransMode")
	@RequiresPermissions("ralAccountTransMode:delete")
	public @ResponseBody ResponseEntity<String> deleteRalAccountTransMode(String param) {
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
			this.ralAccountTransModeService.remove(ids);
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
	@RequestMapping("getRalAccountTransModeById")
	@RequiresPermissions("ralAccountTransMode:view")
	public @ResponseBody ResponseEntity getRalAccountTransModeById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			RalAccountTransMode ralAccountTransMode = this.ralAccountTransModeService.searchById(id);
			if (null != ralAccountTransMode)
				return new ResponseEntity<RalAccountTransMode>(ralAccountTransMode, HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}