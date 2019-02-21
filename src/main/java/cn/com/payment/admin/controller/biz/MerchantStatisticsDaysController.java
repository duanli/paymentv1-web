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
import cn.com.payment.admin.model.MerchantStatisticsDays;
import cn.com.payment.admin.service.MerchantStatisticsDaysService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("merchantStatisticsDays")
public class MerchantStatisticsDaysController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(MerchantStatisticsDaysController.class.getName());
	@Autowired
	private MerchantStatisticsDaysService merchantStatisticsDaysService;
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("toMerchantStatisticsDaysPage")
	@RequiresPermissions("merchantStatisticsDays:view")
	public String toMerchantStatisticsDaysPage() {
		return PREFIX + "merchantStatisticsDays";
	}
	/**
	 * 获取分页数据
	 * @param page
	 * @return
	 */
	@RequestMapping("getMerchantStatisticsDaysPage")
	@RequiresPermissions("merchantStatisticsDays:view")
	public	@ResponseBody PageEasyUi<MerchantStatisticsDays> getMerchantStatisticsDaysPage(PageEasyUi<MerchantStatisticsDays> page, MerchantStatisticsDays entity){
		PageEasyUi<MerchantStatisticsDays> result=null;
		try{
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<MerchantStatisticsDays> list = this.merchantStatisticsDaysService.searchByProperty(entity);
			result = new PageEasyUi<MerchantStatisticsDays>(list);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		return result;
	}
	/**
	 * 新建数据
	 * @param merchantStatisticsDays
	 * @return
	 */
	@RequestMapping("addMerchantStatisticsDays")
	@RequiresPermissions("merchantStatisticsDays:add")
	public @ResponseBody ResponseEntity<String> addMerchantStatisticsDays(MerchantStatisticsDays merchantStatisticsDays){
		if(CommonUtils.isEmpty(merchantStatisticsDays))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			this.merchantStatisticsDaysService.create(merchantStatisticsDays);
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
	@RequestMapping("updateMerchantStatisticsDays")
	@RequiresPermissions("merchantStatisticsDays:update")
	public @ResponseBody ResponseEntity<String> updateMerchantStatisticsDays(MerchantStatisticsDays merchantStatisticsDays){
		if(CommonUtils.isEmpty(merchantStatisticsDays) || CommonUtils.isEmpty(merchantStatisticsDays.getSdId()))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			MerchantStatisticsDays data = this.merchantStatisticsDaysService.searchById(merchantStatisticsDays.getSdId());
			if(CommonUtils.isNotEmpty(data)){
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getSdId()))data.setSdId(merchantStatisticsDays.getSdId());
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getMchId()))data.setMchId(merchantStatisticsDays.getMchId());
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getSdDay()))data.setSdDay(merchantStatisticsDays.getSdDay());
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getPayCountTotal()))data.setPayCountTotal(merchantStatisticsDays.getPayCountTotal());
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getPayAmountTotal()))data.setPayAmountTotal(merchantStatisticsDays.getPayAmountTotal());
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getPayCountSucc()))data.setPayCountSucc(merchantStatisticsDays.getPayCountSucc());
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getPayAmountSucc()))data.setPayAmountSucc(merchantStatisticsDays.getPayAmountSucc());
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getRealAmount()))data.setRealAmount(merchantStatisticsDays.getRealAmount());
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getTotleFee()))data.setTotleFee(merchantStatisticsDays.getTotleFee());
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getRefundCount()))data.setRefundCount(merchantStatisticsDays.getRefundCount());
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getRefundAmount()))data.setRefundAmount(merchantStatisticsDays.getRefundAmount());
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getState()))data.setState(merchantStatisticsDays.getState());
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getCreateTime()))data.setCreateTime(merchantStatisticsDays.getCreateTime());
				  if(CommonUtils.isNotEmpty(merchantStatisticsDays.getUpdateTime()))data.setUpdateTime(merchantStatisticsDays.getUpdateTime());
			
				this.merchantStatisticsDaysService.modify(data);
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
	@RequestMapping("deleteMerchantStatisticsDays")
	@RequiresPermissions("merchantStatisticsDays:delete")
	public @ResponseBody ResponseEntity<String> deleteMerchantStatisticsDays(String param){
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
			this.merchantStatisticsDaysService.remove(ids);
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
	@RequestMapping("getMerchantStatisticsDaysById")
	@RequiresPermissions("merchantStatisticsDays:view")
	public 	@ResponseBody ResponseEntity  getMerchantStatisticsDaysById(Long id){
		if(CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		try {
			MerchantStatisticsDays merchantStatisticsDays=  this.merchantStatisticsDaysService.searchById(id);
			if(null!=merchantStatisticsDays)
				return new ResponseEntity<MerchantStatisticsDays>(merchantStatisticsDays,HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}