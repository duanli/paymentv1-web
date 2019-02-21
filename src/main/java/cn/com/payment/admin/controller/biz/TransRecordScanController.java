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
import cn.com.payment.admin.model.TransRecordScan;
import cn.com.payment.admin.service.TransRecordScanService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("transRecordScan")
public class TransRecordScanController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(TransRecordScanController.class.getName());
	@Autowired
	private TransRecordScanService transRecordScanService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toTransRecordScanPage")
	@RequiresPermissions("transRecordScan:view")
	public String toTransRecordScanPage() {
		return PREFIX + "transRecordScan";
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getTransRecordScanPage")
	@RequiresPermissions("transRecordScan:view")
	public @ResponseBody PageEasyUi<TransRecordScan> getTransRecordScanPage(PageEasyUi<TransRecordScan> page,
			TransRecordScan entity) {
		PageEasyUi<TransRecordScan> result = null;
		try {
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<TransRecordScan> list = this.transRecordScanService.searchByProperty(entity);
			result = new PageEasyUi<TransRecordScan>(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 新建数据
	 * 
	 * @param transRecordScan
	 * @return
	 */
	@RequestMapping("addTransRecordScan")
	@RequiresPermissions("transRecordScan:add")
	public @ResponseBody ResponseEntity<String> addTransRecordScan(TransRecordScan transRecordScan) {
		if (CommonUtils.isEmpty(transRecordScan))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			this.transRecordScanService.create(transRecordScan);
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
	@RequestMapping("updateTransRecordScan")
	@RequiresPermissions("transRecordScan:update")
	public @ResponseBody ResponseEntity<String> updateTransRecordScan(TransRecordScan transRecordScan) {
		if (CommonUtils.isEmpty(transRecordScan) || CommonUtils.isEmpty(transRecordScan.getId()))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			TransRecordScan data = this.transRecordScanService.searchById(transRecordScan.getId());
			if (CommonUtils.isNotEmpty(data)) {
				if (CommonUtils.isNotEmpty(transRecordScan.getId()))
					data.setId(transRecordScan.getId());
				if (CommonUtils.isNotEmpty(transRecordScan.getTransBrandId()))
					data.setTransBrandId(transRecordScan.getTransBrandId());
				if (CommonUtils.isNotEmpty(transRecordScan.getTransBrandName()))
					data.setTransBrandName(transRecordScan.getTransBrandName());
				if (CommonUtils.isNotEmpty(transRecordScan.getTransModeId()))
					data.setTransModeId(transRecordScan.getTransModeId());
				if (CommonUtils.isNotEmpty(transRecordScan.getTransModeName()))
					data.setTransModeName(transRecordScan.getTransModeName());
				if (CommonUtils.isNotEmpty(transRecordScan.getMerParentId()))
					data.setMerParentId(transRecordScan.getMerParentId());
				if (CommonUtils.isNotEmpty(transRecordScan.getMerId()))
					data.setMerId(transRecordScan.getMerId());
				if (CommonUtils.isNotEmpty(transRecordScan.getProviderId()))
					data.setProviderId(transRecordScan.getProviderId());
				if (CommonUtils.isNotEmpty(transRecordScan.getProviderAccId()))
					data.setProviderAccId(transRecordScan.getProviderAccId());
				if (CommonUtils.isNotEmpty(transRecordScan.getProviderMchNo()))
					data.setProviderMchNo(transRecordScan.getProviderMchNo());
				if (CommonUtils.isNotEmpty(transRecordScan.getProviderName()))
					data.setProviderName(transRecordScan.getProviderName());
				if (CommonUtils.isNotEmpty(transRecordScan.getProductId()))
					data.setProductId(transRecordScan.getProductId());
				if (CommonUtils.isNotEmpty(transRecordScan.getProductName()))
					data.setProductName(transRecordScan.getProductName());
				if (CommonUtils.isNotEmpty(transRecordScan.getOutTradeNo()))
					data.setOutTradeNo(transRecordScan.getOutTradeNo());
				if (CommonUtils.isNotEmpty(transRecordScan.getAmount()))
					data.setAmount(transRecordScan.getAmount());
				if (CommonUtils.isNotEmpty(transRecordScan.getActulAmt()))
					data.setActulAmt(transRecordScan.getActulAmt());
				if (CommonUtils.isNotEmpty(transRecordScan.getState()))
					data.setState(transRecordScan.getState());
				if (CommonUtils.isNotEmpty(transRecordScan.getStateMsg()))
					data.setStateMsg(transRecordScan.getStateMsg());
				if (CommonUtils.isNotEmpty(transRecordScan.getStateRemark()))
					data.setStateRemark(transRecordScan.getStateRemark());
				if (CommonUtils.isNotEmpty(transRecordScan.getType()))
					data.setType(transRecordScan.getType());
				if (CommonUtils.isNotEmpty(transRecordScan.getSrcOutTradeNo()))
					data.setSrcOutTradeNo(transRecordScan.getSrcOutTradeNo());
				if (CommonUtils.isNotEmpty(transRecordScan.getOutTransactionId()))
					data.setOutTransactionId(transRecordScan.getOutTransactionId());
				if (CommonUtils.isNotEmpty(transRecordScan.getTerminalIP()))
					data.setTerminalIP(transRecordScan.getTerminalIP());
				if (CommonUtils.isNotEmpty(transRecordScan.getGoodsName()))
					data.setGoodsName(transRecordScan.getGoodsName());
				if (CommonUtils.isNotEmpty(transRecordScan.getGoodsDesc()))
					data.setGoodsDesc(transRecordScan.getGoodsDesc());
				if (CommonUtils.isNotEmpty(transRecordScan.getBizOrderNo()))
					data.setBizOrderNo(transRecordScan.getBizOrderNo());
				if (CommonUtils.isNotEmpty(transRecordScan.getNotifyUrl()))
					data.setNotifyUrl(transRecordScan.getNotifyUrl());
				if (CommonUtils.isNotEmpty(transRecordScan.getResultUrl()))
					data.setResultUrl(transRecordScan.getResultUrl());
				if (CommonUtils.isNotEmpty(transRecordScan.getPayWayUserId()))
					data.setPayWayUserId(transRecordScan.getPayWayUserId());
				if (CommonUtils.isNotEmpty(transRecordScan.getSpTransactionId()))
					data.setSpTransactionId(transRecordScan.getSpTransactionId());
				if (CommonUtils.isNotEmpty(transRecordScan.getSpTransTime()))
					data.setSpTransTime(transRecordScan.getSpTransTime());
				if (CommonUtils.isNotEmpty(transRecordScan.getSpTransDate()))
					data.setSpTransDate(transRecordScan.getSpTransDate());
				if (CommonUtils.isNotEmpty(transRecordScan.getSpRespCode()))
					data.setSpRespCode(transRecordScan.getSpRespCode());
				if (CommonUtils.isNotEmpty(transRecordScan.getSpRespMsg()))
					data.setSpRespMsg(transRecordScan.getSpRespMsg());
				if (CommonUtils.isNotEmpty(transRecordScan.getProviderFee()))
					data.setProviderFee(transRecordScan.getProviderFee());
				if (CommonUtils.isNotEmpty(transRecordScan.getProviderFeeRate()))
					data.setProviderFeeRate(transRecordScan.getProviderFeeRate());
				if (CommonUtils.isNotEmpty(transRecordScan.getMerFee()))
					data.setMerFee(transRecordScan.getMerFee());
				if (CommonUtils.isNotEmpty(transRecordScan.getMerfeeRate()))
					data.setMerfeeRate(transRecordScan.getMerfeeRate());
				if (CommonUtils.isNotEmpty(transRecordScan.getNoticeState()))
					data.setNoticeState(transRecordScan.getNoticeState());
				if (CommonUtils.isNotEmpty(transRecordScan.getSettleState()))
					data.setSettleState(transRecordScan.getSettleState());
				if (CommonUtils.isNotEmpty(transRecordScan.getCreateTime()))
					data.setCreateTime(transRecordScan.getCreateTime());
				if (CommonUtils.isNotEmpty(transRecordScan.getUpdateTime()))
					data.setUpdateTime(transRecordScan.getUpdateTime());

				this.transRecordScanService.modify(data);
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
	@RequestMapping("deleteTransRecordScan")
	@RequiresPermissions("transRecordScan:delete")
	public @ResponseBody ResponseEntity<String> deleteTransRecordScan(String param) {
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
			this.transRecordScanService.remove(ids);
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
	@RequestMapping("getTransRecordScanById")
	@RequiresPermissions("transRecordScan:view")
	public @ResponseBody ResponseEntity getTransRecordScanById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			TransRecordScan transRecordScan = this.transRecordScanService.searchById(id);
			if (null != transRecordScan)
				return new ResponseEntity<TransRecordScan>(transRecordScan, HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}