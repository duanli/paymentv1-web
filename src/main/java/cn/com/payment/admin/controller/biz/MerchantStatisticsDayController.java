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

import cn.com.payment.admin.dto.IResponse;
import cn.com.payment.admin.dto.PageEasyUi;
import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.MerchantStatisticsDay;
import cn.com.payment.admin.service.MerchantStatisticsDayService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("merchantStatisticsDay")
public class MerchantStatisticsDayController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(MerchantStatisticsDayController.class.getName());
	@Autowired
	private MerchantStatisticsDayService merchantStatisticsDayService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toMerchantStatisticsDayPage")
	@RequiresPermissions("merchantStatisticsDay:view")
	public String toMerchantStatisticsDayPage() {
		return PREFIX + "merchantStatisticsDay";
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getMerchantStatisticsDayPage")
	@RequiresPermissions("merchantStatisticsDay:view")
	public @ResponseBody PageEasyUi<MerchantStatisticsDay> getMerchantStatisticsDayPage(
			PageEasyUi<MerchantStatisticsDay> page, MerchantStatisticsDay entity) {
		PageEasyUi<MerchantStatisticsDay> result = null;
		try {
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<MerchantStatisticsDay> list = this.merchantStatisticsDayService.searchByProperty(entity);
			result = new PageEasyUi<MerchantStatisticsDay>(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 新建数据
	 * 
	 * @param merchantStatisticsDay
	 * @return
	 */
	@RequestMapping("addMerchantStatisticsDay")
	@RequiresPermissions("merchantStatisticsDay:add")
	public @ResponseBody ResponseEntity<String> addMerchantStatisticsDay(MerchantStatisticsDay merchantStatisticsDay) {
		if (CommonUtils.isEmpty(merchantStatisticsDay))
			return new ResponseEntity<String>(IResponse.INVALID_REQUEST, HttpStatus.BAD_REQUEST);

		try {
			this.merchantStatisticsDayService.create(merchantStatisticsDay);
			return new ResponseEntity<String>(IResponse.SUCCESS, HttpStatus.OK);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(IResponse.SYSTEM_ERR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 更新数据
	 * 
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping("updateMerchantStatisticsDay")
	@RequiresPermissions("merchantStatisticsDay:update")
	public @ResponseBody ResponseEntity<String> updateMerchantStatisticsDay(
			MerchantStatisticsDay merchantStatisticsDay) {
		if (CommonUtils.isEmpty(merchantStatisticsDay) || CommonUtils.isEmpty(merchantStatisticsDay.getSdId()))
			return new ResponseEntity<String>(IResponse.INVALID_REQUEST, HttpStatus.BAD_REQUEST);

		try {
			MerchantStatisticsDay data = this.merchantStatisticsDayService.searchById(merchantStatisticsDay.getSdId());
			if (CommonUtils.isNotEmpty(data)) {
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getSdId()))
					data.setSdId(merchantStatisticsDay.getSdId());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getMchId()))
					data.setMchId(merchantStatisticsDay.getMchId());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getTransModeId()))
					data.setTransModeId(merchantStatisticsDay.getTransModeId());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getSdYear()))
					data.setSdYear(merchantStatisticsDay.getSdYear());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getSdMouth()))
					data.setSdMouth(merchantStatisticsDay.getSdMouth());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getSdDay()))
					data.setSdDay(merchantStatisticsDay.getSdDay());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getPayCountTotal()))
					data.setPayCountTotal(merchantStatisticsDay.getPayCountTotal());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getPayAmountTotal()))
					data.setPayAmountTotal(merchantStatisticsDay.getPayAmountTotal());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getPayCountSucc()))
					data.setPayCountSucc(merchantStatisticsDay.getPayCountSucc());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getPayAmountSucc()))
					data.setPayAmountSucc(merchantStatisticsDay.getPayAmountSucc());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getRealAmount()))
					data.setRealAmount(merchantStatisticsDay.getRealAmount());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getTotleFee()))
					data.setTotleFee(merchantStatisticsDay.getTotleFee());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getRefundCount()))
					data.setRefundCount(merchantStatisticsDay.getRefundCount());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getRefundAmount()))
					data.setRefundAmount(merchantStatisticsDay.getRefundAmount());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getState()))
					data.setState(merchantStatisticsDay.getState());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getCreateTime()))
					data.setCreateTime(merchantStatisticsDay.getCreateTime());
				if (CommonUtils.isNotEmpty(merchantStatisticsDay.getUpdateTime()))
					data.setUpdateTime(merchantStatisticsDay.getUpdateTime());

				this.merchantStatisticsDayService.modify(data);
				return new ResponseEntity<String>(IResponse.SUCCESS, HttpStatus.OK);
			} else
				return new ResponseEntity<String>("数据不存在！", HttpStatus.BAD_REQUEST);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(IResponse.SYSTEM_ERR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 删除数据
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping("deleteMerchantStatisticsDay")
	@RequiresPermissions("merchantStatisticsDay:delete")
	public @ResponseBody ResponseEntity<String> deleteMerchantStatisticsDay(String param) {
		if (CommonUtils.isEmpty(param))
			return new ResponseEntity<String>(IResponse.INVALID_REQUEST, HttpStatus.BAD_REQUEST);

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
			this.merchantStatisticsDayService.remove(ids);
			return new ResponseEntity<String>(IResponse.SUCCESS, HttpStatus.OK);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(IResponse.SYSTEM_ERR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 根据id获取信息
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("getMerchantStatisticsDayById")
	@RequiresPermissions("merchantStatisticsDay:view")
	public @ResponseBody ResponseEntity getMerchantStatisticsDayById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(IResponse.INVALID_REQUEST, HttpStatus.BAD_REQUEST);

		try {
			MerchantStatisticsDay merchantStatisticsDay = this.merchantStatisticsDayService.searchById(id);
			if (null != merchantStatisticsDay)
				return new ResponseEntity<MerchantStatisticsDay>(merchantStatisticsDay, HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(IResponse.SYSTEM_ERR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}