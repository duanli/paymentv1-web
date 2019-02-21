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
import cn.com.payment.admin.model.MerchantSettlement;
import cn.com.payment.admin.service.MerchantSettlementService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("merchantSettlement")
public class MerchantSettlementController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(MerchantSettlementController.class.getName());
	@Autowired
	private MerchantSettlementService merchantSettlementService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toMerchantSettlementPage")
	@RequiresPermissions("merchantSettlement:view")
	public String toMerchantSettlementPage() {
		return PREFIX + "merchantSettlement";
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getMerchantSettlementPage")
	@RequiresPermissions("merchantSettlement:view")
	public @ResponseBody PageEasyUi<MerchantSettlement> getMerchantSettlementPage(PageEasyUi<MerchantSettlement> page,
			MerchantSettlement entity) {
		PageEasyUi<MerchantSettlement> result = null;
		try {
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<MerchantSettlement> list = this.merchantSettlementService.searchByProperty(entity);
			result = new PageEasyUi<MerchantSettlement>(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 新建数据
	 * 
	 * @param merchantSettlement
	 * @return
	 */
	@RequestMapping("addMerchantSettlement")
	@RequiresPermissions("merchantSettlement:add")
	public @ResponseBody ResponseEntity<String> addMerchantSettlement(MerchantSettlement merchantSettlement) {
		if (CommonUtils.isEmpty(merchantSettlement))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			this.merchantSettlementService.create(merchantSettlement);
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
	@RequestMapping("updateMerchantSettlement")
	@RequiresPermissions("merchantSettlement:update")
	public @ResponseBody ResponseEntity<String> updateMerchantSettlement(MerchantSettlement merchantSettlement) {
		if (CommonUtils.isEmpty(merchantSettlement) || CommonUtils.isEmpty(merchantSettlement.getSettleId()))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			MerchantSettlement data = this.merchantSettlementService.searchById(merchantSettlement.getSettleId());
			if (CommonUtils.isNotEmpty(data)) {
				if (CommonUtils.isNotEmpty(merchantSettlement.getSettleId()))
					data.setSettleId(merchantSettlement.getSettleId());
				if (CommonUtils.isNotEmpty(merchantSettlement.getMchId()))
					data.setMchId(merchantSettlement.getMchId());
				if (CommonUtils.isNotEmpty(merchantSettlement.getSettleDate()))
					data.setSettleDate(merchantSettlement.getSettleDate());
				if (CommonUtils.isNotEmpty(merchantSettlement.getPayDate()))
					data.setPayDate(merchantSettlement.getPayDate());
				if (CommonUtils.isNotEmpty(merchantSettlement.getSettleType()))
					data.setSettleType(merchantSettlement.getSettleType());
				if (CommonUtils.isNotEmpty(merchantSettlement.getSettleAmount()))
					data.setSettleAmount(merchantSettlement.getSettleAmount());
				if (CommonUtils.isNotEmpty(merchantSettlement.getState()))
					data.setState(merchantSettlement.getState());
				if (CommonUtils.isNotEmpty(merchantSettlement.getCreateTime()))
					data.setCreateTime(merchantSettlement.getCreateTime());
				if (CommonUtils.isNotEmpty(merchantSettlement.getUpdateTime()))
					data.setUpdateTime(merchantSettlement.getUpdateTime());

				this.merchantSettlementService.modify(data);
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
	@RequestMapping("deleteMerchantSettlement")
	@RequiresPermissions("merchantSettlement:delete")
	public @ResponseBody ResponseEntity<String> deleteMerchantSettlement(String param) {
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
			this.merchantSettlementService.remove(ids);
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
	@RequestMapping("getMerchantSettlementById")
	@RequiresPermissions("merchantSettlement:view")
	public @ResponseBody ResponseEntity getMerchantSettlementById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			MerchantSettlement merchantSettlement = this.merchantSettlementService.searchById(id);
			if (null != merchantSettlement)
				return new ResponseEntity<MerchantSettlement>(merchantSettlement, HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}