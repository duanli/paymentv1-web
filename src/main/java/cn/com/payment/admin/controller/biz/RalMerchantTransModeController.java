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
import cn.com.payment.admin.model.RalMerchantTransMode;
import cn.com.payment.admin.service.RalMerchantTransModeService;
import cn.com.payment.admin.utils.AmtUtils;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("ralMerchantTransMode")
public class RalMerchantTransModeController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(RalMerchantTransModeController.class.getName());
	@Autowired
	private RalMerchantTransModeService ralMerchantTransModeService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toRalMerchantTransModePage")
	@RequiresPermissions("ralMerchantTransMode:view")
	public String toRalMerchantTransModePage() {
		return PREFIX + "ralMerchantTransMode";
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getRalMerchantTransModePage")
	@RequiresPermissions("ralMerchantTransMode:view")
	public @ResponseBody PageEasyUi<RalMerchantTransMode> getRalMerchantTransModePage(
			PageEasyUi<RalMerchantTransMode> page, RalMerchantTransMode entity) {
		PageEasyUi<RalMerchantTransMode> result = null;
		try {
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<RalMerchantTransMode> list = this.ralMerchantTransModeService.searchByProperty(entity);
			result = new PageEasyUi<RalMerchantTransMode>(list);
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
	@RequestMapping("getRalMerchantTransModeList")
	@RequiresPermissions("ralMerchantTransMode:view")
	public @ResponseBody List<RalMerchantTransMode> getRalMerchantTransModeList(PageEasyUi<RalMerchantTransMode> page,
			RalMerchantTransMode entity) {
		List<RalMerchantTransMode> result = null;
		try {
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			result = this.ralMerchantTransModeService.searchByProperty(entity);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 新建数据
	 * 
	 * @param ralMerchantTransMode
	 * @return
	 */
	@RequestMapping("addRalMerchantTransMode")
	@RequiresPermissions("ralMerchantTransMode:add")
	public @ResponseBody ResponseEntity<String> addRalMerchantTransMode(RalMerchantTransMode ralMerchantTransMode,
			String sminAmt, String smaxAmt, String stotleAmt) {
		if (CommonUtils.isEmpty(ralMerchantTransMode))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			if (CommonUtils.isNotEmpty(stotleAmt))
				ralMerchantTransMode.setTotleAmtLimit(Long.valueOf(AmtUtils.yuanToFen(stotleAmt)));
			if (CommonUtils.isNotEmpty(sminAmt))
				ralMerchantTransMode.setMinAmt(Long.valueOf(AmtUtils.yuanToFen(sminAmt)));
			if (CommonUtils.isNotEmpty(smaxAmt))
				ralMerchantTransMode.setMaxAmt(Long.valueOf(AmtUtils.yuanToFen(smaxAmt)));
			this.ralMerchantTransModeService.create(ralMerchantTransMode);
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
	@RequestMapping("updateRalMerchantTransMode")
	@RequiresPermissions("ralMerchantTransMode:update")
	public @ResponseBody ResponseEntity<String> updateRalMerchantTransMode(RalMerchantTransMode ralMerchantTransMode,
			String sminAmt, String smaxAmt, String stotleAmt) {
		if (CommonUtils.isEmpty(ralMerchantTransMode)
				|| CommonUtils.isEmpty(ralMerchantTransMode.getRalMerTransModeId()))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			RalMerchantTransMode data = this.ralMerchantTransModeService
					.searchById(ralMerchantTransMode.getRalMerTransModeId());
			if (CommonUtils.isNotEmpty(data)) {
				if (CommonUtils.isNotEmpty(ralMerchantTransMode.getRalMerTransModeId()))
					data.setRalMerTransModeId(ralMerchantTransMode.getRalMerTransModeId());
				if (CommonUtils.isNotEmpty(ralMerchantTransMode.getMchId()))
					data.setMchId(ralMerchantTransMode.getMchId());
				if (CommonUtils.isNotEmpty(ralMerchantTransMode.getTransModeId()))
					data.setTransModeId(ralMerchantTransMode.getTransModeId());
				if (CommonUtils.isNotEmpty(ralMerchantTransMode.getFeeRate()))
					data.setFeeRate(ralMerchantTransMode.getFeeRate());
				if (CommonUtils.isNotEmpty(stotleAmt))
					data.setTotleAmtLimit(Long.valueOf(AmtUtils.yuanToFen(stotleAmt)));
				if (CommonUtils.isNotEmpty(sminAmt))
					data.setMinAmt(Long.valueOf(AmtUtils.yuanToFen(sminAmt)));
				if (CommonUtils.isNotEmpty(smaxAmt))
					data.setMaxAmt(Long.valueOf(AmtUtils.yuanToFen(smaxAmt)));
				if (CommonUtils.isNotEmpty(ralMerchantTransMode.getBeginTime()))
					data.setBeginTime(ralMerchantTransMode.getBeginTime());
				if (CommonUtils.isNotEmpty(ralMerchantTransMode.getEndTime()))
					data.setEndTime(ralMerchantTransMode.getEndTime());
				if (CommonUtils.isNotEmpty(ralMerchantTransMode.getState()))
					data.setState(ralMerchantTransMode.getState());
				if (CommonUtils.isNotEmpty(ralMerchantTransMode.getIsDel()))
					data.setIsDel(ralMerchantTransMode.getIsDel());
				if (CommonUtils.isNotEmpty(ralMerchantTransMode.getRestrictState()))
					data.setRestrictState(ralMerchantTransMode.getRestrictState());
				if (CommonUtils.isNotEmpty(ralMerchantTransMode.getValidIP()))
					data.setValidIP(ralMerchantTransMode.getValidIP());
				if (CommonUtils.isNotEmpty(ralMerchantTransMode.getSettleType()))
					data.setSettleType(ralMerchantTransMode.getSettleType());

				this.ralMerchantTransModeService.modify(data);
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
	@RequestMapping("deleteRalMerchantTransMode")
	@RequiresPermissions("ralMerchantTransMode:delete")
	public @ResponseBody ResponseEntity<String> deleteRalMerchantTransMode(String param) {
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
			this.ralMerchantTransModeService.remove(ids);
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
	@RequestMapping("getRalMerchantTransModeById")
	@RequiresPermissions("ralMerchantTransMode:view")
	public @ResponseBody ResponseEntity getRalMerchantTransModeById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			RalMerchantTransMode ralMerchantTransMode = this.ralMerchantTransModeService.searchById(id);
			if (null != ralMerchantTransMode)
				return new ResponseEntity<RalMerchantTransMode>(ralMerchantTransMode, HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}