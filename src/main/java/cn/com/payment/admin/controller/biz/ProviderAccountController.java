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
import cn.com.payment.admin.model.ProviderAccount;
import cn.com.payment.admin.service.ProviderAccountService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("providerAccount")
public class ProviderAccountController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(ProviderAccountController.class.getName());
	@Autowired
	private ProviderAccountService providerAccountService;
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("toProviderAccountPage")
	@RequiresPermissions("providerAccount:view")
	public String toProviderAccountPage() {
		return PREFIX + "providerAccount";
	}
	/**
	 * 获取分页数据
	 * @param page
	 * @return
	 */
	@RequestMapping("getProviderAccountPage")
	@RequiresPermissions("providerAccount:view")
	public	@ResponseBody PageEasyUi<ProviderAccount> getProviderAccountPage(PageEasyUi<ProviderAccount> page, ProviderAccount entity){
		PageEasyUi<ProviderAccount> result=null;
		try{
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<ProviderAccount> list = this.providerAccountService.searchByProperty(entity);
			result = new PageEasyUi<ProviderAccount>(list);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		return result;
	}
	/**
	 * 新建数据
	 * @param providerAccount
	 * @return
	 */
	@RequestMapping("addProviderAccount")
	@RequiresPermissions("providerAccount:add")
	public @ResponseBody ResponseEntity<String> addProviderAccount(ProviderAccount providerAccount){
		if(CommonUtils.isEmpty(providerAccount))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			this.providerAccountService.create(providerAccount);
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
	@RequestMapping("updateProviderAccount")
	@RequiresPermissions("providerAccount:update")
	public @ResponseBody ResponseEntity<String> updateProviderAccount(ProviderAccount providerAccount){
		if(CommonUtils.isEmpty(providerAccount) || CommonUtils.isEmpty(providerAccount.getProviderAccId()))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			ProviderAccount data = this.providerAccountService.searchById(providerAccount.getProviderAccId());
			if(CommonUtils.isNotEmpty(data)){
				  if(CommonUtils.isNotEmpty(providerAccount.getProviderAccId()))data.setProviderAccId(providerAccount.getProviderAccId());
				  if(CommonUtils.isNotEmpty(providerAccount.getProviderId()))data.setProviderId(providerAccount.getProviderId());
				  if(CommonUtils.isNotEmpty(providerAccount.getAccName()))data.setAccName(providerAccount.getAccName());
				  if(CommonUtils.isNotEmpty(providerAccount.getProviderMchNo()))data.setProviderMchNo(providerAccount.getProviderMchNo());
				  if(CommonUtils.isNotEmpty(providerAccount.getProviderMchKey()))data.setProviderMchKey(providerAccount.getProviderMchKey());
				  if(CommonUtils.isNotEmpty(providerAccount.getProviderAPPId()))data.setProviderAPPId(providerAccount.getProviderAPPId());
				  if(CommonUtils.isNotEmpty(providerAccount.getState()))data.setState(providerAccount.getState());
				  if(CommonUtils.isNotEmpty(providerAccount.getCreateTime()))data.setCreateTime(providerAccount.getCreateTime());
				  if(CommonUtils.isNotEmpty(providerAccount.getUpdateTime()))data.setUpdateTime(providerAccount.getUpdateTime());
				  if(CommonUtils.isNotEmpty(providerAccount.getFeeRate()))data.setFeeRate(providerAccount.getFeeRate());
				  if(CommonUtils.isNotEmpty(providerAccount.getBalance()))data.setBalance(providerAccount.getBalance());
			
				this.providerAccountService.modify(data);
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
	@RequestMapping("deleteProviderAccount")
	@RequiresPermissions("providerAccount:delete")
	public @ResponseBody ResponseEntity<String> deleteProviderAccount(String param){
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
			this.providerAccountService.remove(ids);
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
	@RequestMapping("getProviderAccountById")
	@RequiresPermissions("providerAccount:view")
	public 	@ResponseBody ResponseEntity  getProviderAccountById(Long id){
		if(CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		try {
			ProviderAccount providerAccount=  this.providerAccountService.searchById(id);
			if(null!=providerAccount)
				return new ResponseEntity<ProviderAccount>(providerAccount,HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}