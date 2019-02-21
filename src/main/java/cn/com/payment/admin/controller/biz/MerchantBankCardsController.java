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
import cn.com.payment.admin.model.MerchantBankCards;
import cn.com.payment.admin.service.MerchantBankCardsService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("merchantBankCards")
public class MerchantBankCardsController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(MerchantBankCardsController.class.getName());
	@Autowired
	private MerchantBankCardsService merchantBankCardsService;
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("toMerchantBankCardsPage")
	@RequiresPermissions("merchantBankCards:view")
	public String toMerchantBankCardsPage() {
		return PREFIX + "merchantBankCards";
	}
	/**
	 * 获取分页数据
	 * @param page
	 * @return
	 */
	@RequestMapping("getMerchantBankCardsPage")
	@RequiresPermissions("merchantBankCards:view")
	public	@ResponseBody PageEasyUi<MerchantBankCards> getMerchantBankCardsPage(PageEasyUi<MerchantBankCards> page, MerchantBankCards entity){
		PageEasyUi<MerchantBankCards> result=null;
		try{
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<MerchantBankCards> list = this.merchantBankCardsService.searchByProperty(entity);
			result = new PageEasyUi<MerchantBankCards>(list);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		return result;
	}
	/**
	 * 新建数据
	 * @param merchantBankCards
	 * @return
	 */
	@RequestMapping("addMerchantBankCards")
	@RequiresPermissions("merchantBankCards:add")
	public @ResponseBody ResponseEntity<String> addMerchantBankCards(MerchantBankCards merchantBankCards){
		if(CommonUtils.isEmpty(merchantBankCards))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			this.merchantBankCardsService.create(merchantBankCards);
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
	@RequestMapping("updateMerchantBankCards")
	@RequiresPermissions("merchantBankCards:update")
	public @ResponseBody ResponseEntity<String> updateMerchantBankCards(MerchantBankCards merchantBankCards){
		if(CommonUtils.isEmpty(merchantBankCards) || CommonUtils.isEmpty(merchantBankCards.getBankCardId()))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			MerchantBankCards data = this.merchantBankCardsService.searchById(merchantBankCards.getBankCardId());
			if(CommonUtils.isNotEmpty(data)){
				  if(CommonUtils.isNotEmpty(merchantBankCards.getBankCardId()))data.setBankCardId(merchantBankCards.getBankCardId());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getMchId()))data.setMchId(merchantBankCards.getMchId());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getBankCode()))data.setBankCode(merchantBankCards.getBankCode());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getBankName()))data.setBankName(merchantBankCards.getBankName());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getBankAccType()))data.setBankAccType(merchantBankCards.getBankAccType());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getBankCardType()))data.setBankCardType(merchantBankCards.getBankCardType());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getBankReservedPhone()))data.setBankReservedPhone(merchantBankCards.getBankReservedPhone());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getBankCardNo()))data.setBankCardNo(merchantBankCards.getBankCardNo());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getBankProvince()))data.setBankProvince(merchantBankCards.getBankProvince());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getBankCity()))data.setBankCity(merchantBankCards.getBankCity());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getBankLineNo()))data.setBankLineNo(merchantBankCards.getBankLineNo());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getSubBankName()))data.setSubBankName(merchantBankCards.getSubBankName());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getIdCardNo()))data.setIdCardNo(merchantBankCards.getIdCardNo());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getRealName()))data.setRealName(merchantBankCards.getRealName());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getState()))data.setState(merchantBankCards.getState());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getCreateTime()))data.setCreateTime(merchantBankCards.getCreateTime());
				  if(CommonUtils.isNotEmpty(merchantBankCards.getUpdateTime()))data.setUpdateTime(merchantBankCards.getUpdateTime());
				this.merchantBankCardsService.modify(data);
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
	@RequestMapping("deleteMerchantBankCards")
	@RequiresPermissions("merchantBankCards:delete")
	public @ResponseBody ResponseEntity<String> deleteMerchantBankCards(String param){
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
			this.merchantBankCardsService.remove(ids);
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
	@RequestMapping("getMerchantBankCardsById")
	@RequiresPermissions("merchantBankCards:view")
	public 	@ResponseBody ResponseEntity  getMerchantBankCardsById(Long id){
		if(CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		try {
			MerchantBankCards merchantBankCards=  this.merchantBankCardsService.searchById(id);
			if(null!=merchantBankCards)
				return new ResponseEntity<MerchantBankCards>(merchantBankCards,HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}