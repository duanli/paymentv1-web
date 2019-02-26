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
import cn.com.payment.admin.model.RalProviderTransMode;
import cn.com.payment.admin.service.RalProviderTransModeService;
import cn.com.payment.admin.utils.AmtUtils;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("ralProviderTransMode")
public class RalProviderTransModeController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(RalProviderTransModeController.class.getName());
	@Autowired
	private RalProviderTransModeService ralProviderTransModeService;
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("toRalProviderTransModePage")
	@RequiresPermissions("ralProviderTransMode:view")
	public String toRalProviderTransModePage() {
		return PREFIX + "ralProviderTransMode";
	}
	/**
	 * 获取分页数据
	 * @param page
	 * @return
	 */
	@RequestMapping("getRalProviderTransModePage")
	@RequiresPermissions("ralProviderTransMode:view")
	public	@ResponseBody PageEasyUi<RalProviderTransMode> getRalProviderTransModePage(PageEasyUi<RalProviderTransMode> page, RalProviderTransMode entity){
		PageEasyUi<RalProviderTransMode> result=null;
		try{
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<RalProviderTransMode> list = this.ralProviderTransModeService.searchByProperty(entity);
			result = new PageEasyUi<RalProviderTransMode>(list);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		return result;
	}
	/**
	 * 新建数据
	 * @param ralProviderTransMode
	 * @return
	 */
	@RequestMapping("addRalProviderTransMode")
	@RequiresPermissions("ralProviderTransMode:add")
	public @ResponseBody ResponseEntity<String> addRalProviderTransMode(RalProviderTransMode ralProviderTransMode,String sminAmt, String smaxAmt, String stotleAmt){
		if(CommonUtils.isEmpty(ralProviderTransMode))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			if (CommonUtils.isNotEmpty(stotleAmt))
				ralProviderTransMode.setTotleAmtLimit(Long.valueOf(AmtUtils.yuanToFen(stotleAmt)));
			if (CommonUtils.isNotEmpty(sminAmt))
				ralProviderTransMode.setMinAmt(Long.valueOf(AmtUtils.yuanToFen(sminAmt)));
			if (CommonUtils.isNotEmpty(smaxAmt))
				ralProviderTransMode.setMaxAmt(Long.valueOf(AmtUtils.yuanToFen(smaxAmt)));
			this.ralProviderTransModeService.create(ralProviderTransMode);
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
	@RequestMapping("updateRalProviderTransMode")
	@RequiresPermissions("ralProviderTransMode:update")
	public @ResponseBody ResponseEntity<String> updateRalProviderTransMode(RalProviderTransMode ralProviderTransMode,String sminAmt, String smaxAmt, String stotleAmt){
		if(CommonUtils.isEmpty(ralProviderTransMode) || CommonUtils.isEmpty(ralProviderTransMode.getProductId()))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			RalProviderTransMode data = this.ralProviderTransModeService.searchById(ralProviderTransMode.getProductId());
			if(CommonUtils.isNotEmpty(data)){
				  if(CommonUtils.isNotEmpty(ralProviderTransMode.getProductId()))data.setProductId(ralProviderTransMode.getProductId());
				  if(CommonUtils.isNotEmpty(ralProviderTransMode.getProductName()))data.setProductName(ralProviderTransMode.getProductName());
				  if(CommonUtils.isNotEmpty(ralProviderTransMode.getProviderId()))data.setProviderId(ralProviderTransMode.getProviderId());
				  if(CommonUtils.isNotEmpty(ralProviderTransMode.getTransModeId()))data.setTransModeId(ralProviderTransMode.getTransModeId());
				  if(CommonUtils.isNotEmpty(ralProviderTransMode.getTransRecordPrefix()))data.setTransRecordPrefix(ralProviderTransMode.getTransRecordPrefix());
				  if(CommonUtils.isNotEmpty(ralProviderTransMode.getServiceName()))data.setServiceName(ralProviderTransMode.getServiceName());
				  if(CommonUtils.isNotEmpty(ralProviderTransMode.getMethodName()))data.setMethodName(ralProviderTransMode.getMethodName());
				  if(CommonUtils.isNotEmpty(ralProviderTransMode.getParamClass()))data.setParamClass(ralProviderTransMode.getParamClass());
				  if(CommonUtils.isNotEmpty(ralProviderTransMode.getDesc()))data.setDesc(ralProviderTransMode.getDesc());
				  if(CommonUtils.isNotEmpty(ralProviderTransMode.getSubmitParamJson()))data.setSubmitParamJson(ralProviderTransMode.getSubmitParamJson());
				  if(CommonUtils.isNotEmpty(ralProviderTransMode.getFeeRate()))data.setFeeRate(ralProviderTransMode.getFeeRate());
				  if(CommonUtils.isNotEmpty(ralProviderTransMode.getState()))data.setState(ralProviderTransMode.getState());
				  if (CommonUtils.isNotEmpty(stotleAmt))
						data.setTotleAmtLimit(Long.valueOf(AmtUtils.yuanToFen(stotleAmt)));
					if (CommonUtils.isNotEmpty(sminAmt))
						data.setMinAmt(Long.valueOf(AmtUtils.yuanToFen(sminAmt)));
					if (CommonUtils.isNotEmpty(smaxAmt))
						data.setMaxAmt(Long.valueOf(AmtUtils.yuanToFen(smaxAmt)));
				  if(CommonUtils.isNotEmpty(ralProviderTransMode.getRestrictState()))data.setRestrictState(ralProviderTransMode.getRestrictState());
			
				this.ralProviderTransModeService.modify(data);
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
	@RequestMapping("deleteRalProviderTransMode")
	@RequiresPermissions("ralProviderTransMode:delete")
	public @ResponseBody ResponseEntity<String> deleteRalProviderTransMode(String param){
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
			this.ralProviderTransModeService.remove(ids);
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
	@RequestMapping("getRalProviderTransModeById")
	@RequiresPermissions("ralProviderTransMode:view")
	public 	@ResponseBody ResponseEntity  getRalProviderTransModeById(Long id){
		if(CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		try {
			RalProviderTransMode ralProviderTransMode=  this.ralProviderTransModeService.searchById(id);
			if(null!=ralProviderTransMode)
				return new ResponseEntity<RalProviderTransMode>(ralProviderTransMode,HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}