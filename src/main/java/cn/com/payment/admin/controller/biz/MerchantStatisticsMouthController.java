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
import cn.com.payment.admin.model.MerchantStatisticsMouth;
import cn.com.payment.admin.service.MerchantStatisticsMouthService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("merchantStatisticsMouth")
public class MerchantStatisticsMouthController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(MerchantStatisticsMouthController.class.getName());
	@Autowired
	private MerchantStatisticsMouthService merchantStatisticsMouthService;
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("toMerchantStatisticsMouthPage")
	@RequiresPermissions("merchantStatisticsMouth:view")
	public String toMerchantStatisticsMouthPage() {
		return PREFIX + "merchantStatisticsMouth";
	}
	/**
	 * 获取分页数据
	 * @param page
	 * @return
	 */
	@RequestMapping("getMerchantStatisticsMouthPage")
	@RequiresPermissions("merchantStatisticsMouth:view")
	public	@ResponseBody PageEasyUi<MerchantStatisticsMouth> getMerchantStatisticsMouthPage(PageEasyUi<MerchantStatisticsMouth> page, MerchantStatisticsMouth entity){
		PageEasyUi<MerchantStatisticsMouth> result=null;
		try{
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<MerchantStatisticsMouth> list = this.merchantStatisticsMouthService.searchByProperty(entity);
			result = new PageEasyUi<MerchantStatisticsMouth>(list);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		return result;
	}
	/**
	 * 新建数据
	 * @param merchantStatisticsMouth
	 * @return
	 */
	@RequestMapping("addMerchantStatisticsMouth")
	@RequiresPermissions("merchantStatisticsMouth:add")
	public @ResponseBody ResponseEntity<String> addMerchantStatisticsMouth(MerchantStatisticsMouth merchantStatisticsMouth){
		if(CommonUtils.isEmpty(merchantStatisticsMouth))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			this.merchantStatisticsMouthService.create(merchantStatisticsMouth);
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
	@RequestMapping("updateMerchantStatisticsMouth")
	@RequiresPermissions("merchantStatisticsMouth:update")
	public @ResponseBody ResponseEntity<String> updateMerchantStatisticsMouth(MerchantStatisticsMouth merchantStatisticsMouth){
		if(CommonUtils.isEmpty(merchantStatisticsMouth) || CommonUtils.isEmpty(merchantStatisticsMouth.getSdId()))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			MerchantStatisticsMouth data = this.merchantStatisticsMouthService.searchById(merchantStatisticsMouth.getSdId());
			if(CommonUtils.isNotEmpty(data)){
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getSdId()))data.setSdId(merchantStatisticsMouth.getSdId());
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getMchId()))data.setMchId(merchantStatisticsMouth.getMchId());
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getSdMouth()))data.setSdMouth(merchantStatisticsMouth.getSdMouth());
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getPayCountTotal()))data.setPayCountTotal(merchantStatisticsMouth.getPayCountTotal());
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getPayAmountTotal()))data.setPayAmountTotal(merchantStatisticsMouth.getPayAmountTotal());
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getPayCountSucc()))data.setPayCountSucc(merchantStatisticsMouth.getPayCountSucc());
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getPayAmountSucc()))data.setPayAmountSucc(merchantStatisticsMouth.getPayAmountSucc());
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getRealAmount()))data.setRealAmount(merchantStatisticsMouth.getRealAmount());
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getTotleFee()))data.setTotleFee(merchantStatisticsMouth.getTotleFee());
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getRefundCount()))data.setRefundCount(merchantStatisticsMouth.getRefundCount());
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getRefundAmount()))data.setRefundAmount(merchantStatisticsMouth.getRefundAmount());
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getState()))data.setState(merchantStatisticsMouth.getState());
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getCreateTime()))data.setCreateTime(merchantStatisticsMouth.getCreateTime());
				  if(CommonUtils.isNotEmpty(merchantStatisticsMouth.getUpdateTime()))data.setUpdateTime(merchantStatisticsMouth.getUpdateTime());
			
				this.merchantStatisticsMouthService.modify(data);
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
	@RequestMapping("deleteMerchantStatisticsMouth")
	@RequiresPermissions("merchantStatisticsMouth:delete")
	public @ResponseBody ResponseEntity<String> deleteMerchantStatisticsMouth(String param){
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
			this.merchantStatisticsMouthService.remove(ids);
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
	@RequestMapping("getMerchantStatisticsMouthById")
	@RequiresPermissions("merchantStatisticsMouth:view")
	public 	@ResponseBody ResponseEntity  getMerchantStatisticsMouthById(Long id){
		if(CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		try {
			MerchantStatisticsMouth merchantStatisticsMouth=  this.merchantStatisticsMouthService.searchById(id);
			if(null!=merchantStatisticsMouth)
				return new ResponseEntity<MerchantStatisticsMouth>(merchantStatisticsMouth,HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}