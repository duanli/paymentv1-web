package cn.com.payment.admin.controller.biz;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.payment.admin.contansts.Constants;
import cn.com.payment.admin.dto.PageEasyUi;
import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.RalProductMerchant;
import cn.com.payment.admin.service.RalProductMerchantService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("ralProductMerchant")
public class RalProductMerchantController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(RalProductMerchantController.class.getName());
	@Autowired
	private RalProductMerchantService ralProductMerchantService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toRalProductMerchantPage")
	@RequiresPermissions("ralProductMerchant:view")
	public String toRalProductMerchantPage(Long mchId,Long transModeId,Model model) {
		model.addAttribute("mchId", mchId);
		model.addAttribute("transModeId", transModeId);
		return PREFIX + "ralProductMerchant";
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getRalProductMerchantPage")
	@RequiresPermissions("ralProductMerchant:view")
	public @ResponseBody PageEasyUi<RalProductMerchant> getRalProductMerchantPage(PageEasyUi<RalProductMerchant> page,
			RalProductMerchant entity) {
		PageEasyUi<RalProductMerchant> result = null;
		try {
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<RalProductMerchant> list = this.ralProductMerchantService.searchByProperty(entity);
			result = new PageEasyUi<RalProductMerchant>(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 新建数据
	 * 
	 * @param ralProductMerchant
	 * @return
	 */
	@RequestMapping("addRalProductMerchant")
	@RequiresPermissions("ralProductMerchant:add")
	public @ResponseBody ResponseEntity<String> addRalProductMerchant(RalProductMerchant ralProductMerchant) {
		if (CommonUtils.isEmpty(ralProductMerchant))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			this.ralProductMerchantService.create(ralProductMerchant);
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
	@RequestMapping("updateRalProductMerchant")
	@RequiresPermissions("ralProductMerchant:update")
	public @ResponseBody ResponseEntity<String> updateRalProductMerchant(RalProductMerchant ralProductMerchant) {
		if (CommonUtils.isEmpty(ralProductMerchant) || CommonUtils.isEmpty(ralProductMerchant.getRalMerProductId()))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			RalProductMerchant data = this.ralProductMerchantService
					.searchById(ralProductMerchant.getRalMerProductId());
			if (CommonUtils.isNotEmpty(data)) {
				if (CommonUtils.isNotEmpty(ralProductMerchant.getRalMerProductId()))
					data.setRalMerProductId(ralProductMerchant.getRalMerProductId());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getMchId()))
					data.setMchId(ralProductMerchant.getMchId());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getProductId()))
					data.setProductId(ralProductMerchant.getProductId());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getFeeRate()))
					data.setFeeRate(ralProductMerchant.getFeeRate());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getTotleAmtLimit()))
					data.setTotleAmtLimit(ralProductMerchant.getTotleAmtLimit());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getMinAmt()))
					data.setMinAmt(ralProductMerchant.getMinAmt());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getMaxAmt()))
					data.setMaxAmt(ralProductMerchant.getMaxAmt());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getBeginTime()))
					data.setBeginTime(ralProductMerchant.getBeginTime());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getEndTime()))
					data.setEndTime(ralProductMerchant.getEndTime());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getPercentage()))
					data.setPercentage(ralProductMerchant.getPercentage());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getCreateTime()))
					data.setCreateTime(ralProductMerchant.getCreateTime());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getUpdateTime()))
					data.setUpdateTime(ralProductMerchant.getUpdateTime());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getState()))
					data.setState(ralProductMerchant.getState());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getIsDel()))
					data.setIsDel(ralProductMerchant.getIsDel());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getValidIP()))
					data.setValidIP(ralProductMerchant.getValidIP());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getRestrictState()))
					data.setRestrictState(ralProductMerchant.getRestrictState());
				if (CommonUtils.isNotEmpty(ralProductMerchant.getSettleType()))
					data.setSettleType(ralProductMerchant.getSettleType());

				this.ralProductMerchantService.modify(data);
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
	@RequestMapping("deleteRalProductMerchant")
	@RequiresPermissions("ralProductMerchant:delete")
	public @ResponseBody ResponseEntity<String> deleteRalProductMerchant(String param) {
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
			this.ralProductMerchantService.remove(ids);
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
	@RequestMapping("getRalProductMerchantById")
	@RequiresPermissions("ralProductMerchant:view")
	public @ResponseBody ResponseEntity getRalProductMerchantById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			RalProductMerchant ralProductMerchant = this.ralProductMerchantService.searchById(id);
			if (null != ralProductMerchant)
				return new ResponseEntity<RalProductMerchant>(ralProductMerchant, HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}