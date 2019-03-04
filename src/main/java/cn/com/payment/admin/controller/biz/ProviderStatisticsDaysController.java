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
import cn.com.payment.admin.model.ProviderStatisticsDays;
import cn.com.payment.admin.service.ProviderStatisticsDaysService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("providerStatisticsDays")
public class ProviderStatisticsDaysController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(ProviderStatisticsDaysController.class.getName());
	@Autowired
	private ProviderStatisticsDaysService providerStatisticsDaysService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toProviderStatisticsDaysPage")
	@RequiresPermissions("providerStatisticsDays:view")
	public String toProviderStatisticsDaysPage() {
		return PREFIX + "providerStatisticsDays";
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getProviderStatisticsDaysPage")
	@RequiresPermissions("providerStatisticsDays:view")
	public @ResponseBody PageEasyUi<ProviderStatisticsDays> getProviderStatisticsDaysPage(
			PageEasyUi<ProviderStatisticsDays> page, ProviderStatisticsDays entity) {
		PageEasyUi<ProviderStatisticsDays> result = null;
		try {
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<ProviderStatisticsDays> list = this.providerStatisticsDaysService.searchByProperty(entity);
			result = new PageEasyUi<ProviderStatisticsDays>(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 新建数据
	 * 
	 * @param providerStatisticsDays
	 * @return
	 */
	@RequestMapping("addProviderStatisticsDays")
	@RequiresPermissions("providerStatisticsDays:add")
	public @ResponseBody ResponseEntity<String> addProviderStatisticsDays(
			ProviderStatisticsDays providerStatisticsDays) {
		if (CommonUtils.isEmpty(providerStatisticsDays))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			this.providerStatisticsDaysService.create(providerStatisticsDays);
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
	@RequestMapping("updateProviderStatisticsDays")
	@RequiresPermissions("providerStatisticsDays:update")
	public @ResponseBody ResponseEntity<String> updateProviderStatisticsDays(
			ProviderStatisticsDays providerStatisticsDays) {
		if (CommonUtils.isEmpty(providerStatisticsDays) || CommonUtils.isEmpty(providerStatisticsDays.getSdId()))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			ProviderStatisticsDays data = this.providerStatisticsDaysService
					.searchById(providerStatisticsDays.getSdId());
			if (CommonUtils.isNotEmpty(data)) {
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getSdId()))
					data.setSdId(providerStatisticsDays.getSdId());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getTransModeId()))
					data.setTransModeId(providerStatisticsDays.getTransModeId());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getProductId()))
					data.setProductId(providerStatisticsDays.getProductId());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getProviderAccId()))
					data.setProviderAccId(providerStatisticsDays.getProviderAccId());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getSdYear()))
					data.setSdYear(providerStatisticsDays.getSdYear());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getSdMouth()))
					data.setSdMouth(providerStatisticsDays.getSdMouth());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getSdDay()))
					data.setSdDay(providerStatisticsDays.getSdDay());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getPayCountTotal()))
					data.setPayCountTotal(providerStatisticsDays.getPayCountTotal());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getPayAmountTotal()))
					data.setPayAmountTotal(providerStatisticsDays.getPayAmountTotal());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getPayCountSucc()))
					data.setPayCountSucc(providerStatisticsDays.getPayCountSucc());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getPayAmountSucc()))
					data.setPayAmountSucc(providerStatisticsDays.getPayAmountSucc());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getRealAmount()))
					data.setRealAmount(providerStatisticsDays.getRealAmount());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getTotleFee()))
					data.setTotleFee(providerStatisticsDays.getTotleFee());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getRefundCount()))
					data.setRefundCount(providerStatisticsDays.getRefundCount());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getRefundAmount()))
					data.setRefundAmount(providerStatisticsDays.getRefundAmount());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getState()))
					data.setState(providerStatisticsDays.getState());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getCreateTime()))
					data.setCreateTime(providerStatisticsDays.getCreateTime());
				if (CommonUtils.isNotEmpty(providerStatisticsDays.getUpdateTime()))
					data.setUpdateTime(providerStatisticsDays.getUpdateTime());

				this.providerStatisticsDaysService.modify(data);
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
	@RequestMapping("deleteProviderStatisticsDays")
	@RequiresPermissions("providerStatisticsDays:delete")
	public @ResponseBody ResponseEntity<String> deleteProviderStatisticsDays(String param) {
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
			this.providerStatisticsDaysService.remove(ids);
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
	@RequestMapping("getProviderStatisticsDaysById")
	@RequiresPermissions("providerStatisticsDays:view")
	public @ResponseBody ResponseEntity getProviderStatisticsDaysById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			ProviderStatisticsDays providerStatisticsDays = this.providerStatisticsDaysService.searchById(id);
			if (null != providerStatisticsDays)
				return new ResponseEntity<ProviderStatisticsDays>(providerStatisticsDays, HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}