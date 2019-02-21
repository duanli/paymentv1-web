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
import cn.com.payment.admin.model.MerchantBalanceAdjustment;
import cn.com.payment.admin.service.MerchantBalanceAdjustmentService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("merchantBalanceAdjustment")
public class MerchantBalanceAdjustmentController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(MerchantBalanceAdjustmentController.class.getName());
	@Autowired
	private MerchantBalanceAdjustmentService merchantBalanceAdjustmentService;
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("toMerchantBalanceAdjustmentPage")
	@RequiresPermissions("merchantBalanceAdjustment:view")
	public String toMerchantBalanceAdjustmentPage() {
		return PREFIX + "merchantBalanceAdjustment";
	}
	/**
	 * 获取分页数据
	 * @param page
	 * @return
	 */
	@RequestMapping("getMerchantBalanceAdjustmentPage")
	@RequiresPermissions("merchantBalanceAdjustment:view")
	public	@ResponseBody PageEasyUi<MerchantBalanceAdjustment> getMerchantBalanceAdjustmentPage(PageEasyUi<MerchantBalanceAdjustment> page, MerchantBalanceAdjustment entity){
		PageEasyUi<MerchantBalanceAdjustment> result=null;
		try{
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<MerchantBalanceAdjustment> list = this.merchantBalanceAdjustmentService.searchByProperty(entity);
			result = new PageEasyUi<MerchantBalanceAdjustment>(list);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		return result;
	}
	/**
	 * 新建数据
	 * @param merchantBalanceAdjustment
	 * @return
	 */
	@RequestMapping("addMerchantBalanceAdjustment")
	@RequiresPermissions("merchantBalanceAdjustment:add")
	public @ResponseBody ResponseEntity<String> addMerchantBalanceAdjustment(MerchantBalanceAdjustment merchantBalanceAdjustment){
		if(CommonUtils.isEmpty(merchantBalanceAdjustment))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			this.merchantBalanceAdjustmentService.create(merchantBalanceAdjustment);
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
	@RequestMapping("updateMerchantBalanceAdjustment")
	@RequiresPermissions("merchantBalanceAdjustment:update")
	public @ResponseBody ResponseEntity<String> updateMerchantBalanceAdjustment(MerchantBalanceAdjustment merchantBalanceAdjustment){
		if(CommonUtils.isEmpty(merchantBalanceAdjustment) || CommonUtils.isEmpty(merchantBalanceAdjustment.getAdjustId()))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			MerchantBalanceAdjustment data = this.merchantBalanceAdjustmentService.searchById(merchantBalanceAdjustment.getAdjustId());
			if(CommonUtils.isNotEmpty(data)){
				  if(CommonUtils.isNotEmpty(merchantBalanceAdjustment.getAdjustId()))data.setAdjustId(merchantBalanceAdjustment.getAdjustId());
				  if(CommonUtils.isNotEmpty(merchantBalanceAdjustment.getRalAccProductId()))data.setRalAccProductId(merchantBalanceAdjustment.getRalAccProductId());
				  if(CommonUtils.isNotEmpty(merchantBalanceAdjustment.getOperatorId()))data.setOperatorId(merchantBalanceAdjustment.getOperatorId());
				  if(CommonUtils.isNotEmpty(merchantBalanceAdjustment.getAdjustType()))data.setAdjustType(merchantBalanceAdjustment.getAdjustType());
				  if(CommonUtils.isNotEmpty(merchantBalanceAdjustment.getBeforBalance()))data.setBeforBalance(merchantBalanceAdjustment.getBeforBalance());
				  if(CommonUtils.isNotEmpty(merchantBalanceAdjustment.getAfterBalance()))data.setAfterBalance(merchantBalanceAdjustment.getAfterBalance());
				  if(CommonUtils.isNotEmpty(merchantBalanceAdjustment.getAdjustAmount()))data.setAdjustAmount(merchantBalanceAdjustment.getAdjustAmount());
				  if(CommonUtils.isNotEmpty(merchantBalanceAdjustment.getState()))data.setState(merchantBalanceAdjustment.getState());
				  if(CommonUtils.isNotEmpty(merchantBalanceAdjustment.getCreateTime()))data.setCreateTime(merchantBalanceAdjustment.getCreateTime());
				  if(CommonUtils.isNotEmpty(merchantBalanceAdjustment.getUpdateTime()))data.setUpdateTime(merchantBalanceAdjustment.getUpdateTime());
			
				this.merchantBalanceAdjustmentService.modify(data);
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
	@RequestMapping("deleteMerchantBalanceAdjustment")
	@RequiresPermissions("merchantBalanceAdjustment:delete")
	public @ResponseBody ResponseEntity<String> deleteMerchantBalanceAdjustment(String param){
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
			this.merchantBalanceAdjustmentService.remove(ids);
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
	@RequestMapping("getMerchantBalanceAdjustmentById")
	@RequiresPermissions("merchantBalanceAdjustment:view")
	public 	@ResponseBody ResponseEntity  getMerchantBalanceAdjustmentById(Long id){
		if(CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		try {
			MerchantBalanceAdjustment merchantBalanceAdjustment=  this.merchantBalanceAdjustmentService.searchById(id);
			if(null!=merchantBalanceAdjustment)
				return new ResponseEntity<MerchantBalanceAdjustment>(merchantBalanceAdjustment,HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}