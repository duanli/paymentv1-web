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
import cn.com.payment.admin.model.TransRecordDpay;
import cn.com.payment.admin.service.TransRecordDpayService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("transRecordDpay")
public class TransRecordDpayController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(TransRecordDpayController.class.getName());
	@Autowired
	private TransRecordDpayService transRecordDpayService;
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("toTransRecordDpayPage")
	@RequiresPermissions("transRecordDpay:view")
	public String toTransRecordDpayPage() {
		return PREFIX + "transRecordDpay";
	}
	
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("totxPage")
	@RequiresPermissions("transRecordDpay:view")
	public String totxPage() {
		return PREFIX + "122221";
	}
	/**
	 * 获取分页数据
	 * @param page
	 * @return
	 */
	@RequestMapping("getTransRecordDpayPage")
	@RequiresPermissions("transRecordDpay:view")
	public	@ResponseBody PageEasyUi<TransRecordDpay> getTransRecordDpayPage(PageEasyUi<TransRecordDpay> page, TransRecordDpay entity){
		PageEasyUi<TransRecordDpay> result=null;
		try{
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<TransRecordDpay> list = this.transRecordDpayService.searchByProperty(entity);
			result = new PageEasyUi<TransRecordDpay>(list);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		return result;
	}
	/**
	 * 新建数据
	 * @param transRecordDpay
	 * @return
	 */
	@RequestMapping("addTransRecordDpay")
	@RequiresPermissions("transRecordDpay:add")
	public @ResponseBody ResponseEntity<String> addTransRecordDpay(TransRecordDpay transRecordDpay){
		if(CommonUtils.isEmpty(transRecordDpay))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			this.transRecordDpayService.create(transRecordDpay);
			return new ResponseEntity<String>(Constants.PASS_OK,HttpStatus.OK);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/**
	 * 更新数据
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping("updateTransRecordDpay")
	@RequiresPermissions("transRecordDpay:update")
	public @ResponseBody ResponseEntity<String> updateTransRecordDpay(TransRecordDpay transRecordDpay){
		if(CommonUtils.isEmpty(transRecordDpay) || CommonUtils.isEmpty(transRecordDpay.getTransId()))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			TransRecordDpay data = this.transRecordDpayService.searchById(transRecordDpay.getTransId());
			if(CommonUtils.isNotEmpty(data)){
				  if(CommonUtils.isNotEmpty(transRecordDpay.getTransId()))data.setTransId(transRecordDpay.getTransId());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getTransBrandId()))data.setTransBrandId(transRecordDpay.getTransBrandId());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getTransBrandName()))data.setTransBrandName(transRecordDpay.getTransBrandName());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getTransModeId()))data.setTransModeId(transRecordDpay.getTransModeId());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getTransModeName()))data.setTransModeName(transRecordDpay.getTransModeName());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getMerParentId()))data.setMerParentId(transRecordDpay.getMerParentId());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getMerId()))data.setMerId(transRecordDpay.getMerId());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getProviderId()))data.setProviderId(transRecordDpay.getProviderId());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getProviderName()))data.setProviderName(transRecordDpay.getProviderName());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getProviderAccId()))data.setProviderAccId(transRecordDpay.getProviderAccId());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getProviderMchNo()))data.setProviderMchNo(transRecordDpay.getProviderMchNo());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getProductId()))data.setProductId(transRecordDpay.getProductId());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getProductName()))data.setProductName(transRecordDpay.getProductName());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getBankCode()))data.setBankCode(transRecordDpay.getBankCode());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getBankName()))data.setBankName(transRecordDpay.getBankName());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getAccountType()))data.setAccountType(transRecordDpay.getAccountType());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getBankCardType()))data.setBankCardType(transRecordDpay.getBankCardType());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getBankId()))data.setBankId(transRecordDpay.getBankId());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getBankCardNo()))data.setBankCardNo(transRecordDpay.getBankCardNo());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getRealName()))data.setRealName(transRecordDpay.getRealName());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getAmount()))data.setAmount(transRecordDpay.getAmount());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getOutTradeNo()))data.setOutTradeNo(transRecordDpay.getOutTradeNo());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getState()))data.setState(transRecordDpay.getState());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getStateMsg()))data.setStateMsg(transRecordDpay.getStateMsg());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getStateRemark()))data.setStateRemark(transRecordDpay.getStateRemark());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getType()))data.setType(transRecordDpay.getType());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getSrcOutTradeNo()))data.setSrcOutTradeNo(transRecordDpay.getSrcOutTradeNo());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getOutTransactionId()))data.setOutTransactionId(transRecordDpay.getOutTransactionId());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getTerminalIP()))data.setTerminalIP(transRecordDpay.getTerminalIP());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getGoodsName()))data.setGoodsName(transRecordDpay.getGoodsName());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getGoodsDesc()))data.setGoodsDesc(transRecordDpay.getGoodsDesc());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getBizOrderNo()))data.setBizOrderNo(transRecordDpay.getBizOrderNo());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getNotifyUrl()))data.setNotifyUrl(transRecordDpay.getNotifyUrl());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getResultUrl()))data.setResultUrl(transRecordDpay.getResultUrl());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getPayWayUserId()))data.setPayWayUserId(transRecordDpay.getPayWayUserId());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getSpTransactionId()))data.setSpTransactionId(transRecordDpay.getSpTransactionId());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getSpTransTime()))data.setSpTransTime(transRecordDpay.getSpTransTime());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getSpTransDate()))data.setSpTransDate(transRecordDpay.getSpTransDate());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getSpRespCode()))data.setSpRespCode(transRecordDpay.getSpRespCode());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getSpRespMsg()))data.setSpRespMsg(transRecordDpay.getSpRespMsg());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getFee()))data.setFee(transRecordDpay.getFee());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getNoticetate()))data.setNoticetate(transRecordDpay.getNoticetate());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getCreateTime()))data.setCreateTime(transRecordDpay.getCreateTime());
				  if(CommonUtils.isNotEmpty(transRecordDpay.getUpdateTime()))data.setUpdateTime(transRecordDpay.getUpdateTime());
			
				this.transRecordDpayService.modify(data);
				return new ResponseEntity<String>(Constants.PASS_OK,HttpStatus.OK);
			}else
				return new ResponseEntity<String>("数据不存在！",HttpStatus.BAD_REQUEST);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/**
	 * 删除数据
	 * @param param
	 * @return
	 */
	@RequestMapping("deleteTransRecordDpay")
	@RequiresPermissions("transRecordDpay:delete")
	public @ResponseBody ResponseEntity<String> deleteTransRecordDpay(String param){
		if(CommonUtils.isEmpty(param))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		Long[] ids =null;
		try {
			String[] params = param.split(",");
			ids = new Long[params.length];
			for(int i=0,len=params.length;i<len;i++){
				ids[i] = Long.valueOf(params[i]);
			}
		} catch (NumberFormatException e1) {
			return new ResponseEntity<String>("参数格式错误！",HttpStatus.BAD_REQUEST);
		}
		
		try {
			this.transRecordDpayService.remove(ids);
			return new ResponseEntity<String>(Constants.PASS_OK,HttpStatus.OK);
		}  catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/**
	 * 根据id获取信息
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("getTransRecordDpayById")
	@RequiresPermissions("transRecordDpay:view")
	public 	@ResponseBody ResponseEntity  getTransRecordDpayById(Long id){
		if(CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		try {
			TransRecordDpay transRecordDpay=  this.transRecordDpayService.searchById(id);
			if(null!=transRecordDpay)
				return new ResponseEntity<TransRecordDpay>(transRecordDpay,HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}