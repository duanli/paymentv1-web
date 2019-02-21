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
import cn.com.payment.admin.model.TransBrand;
import cn.com.payment.admin.service.TransBrandService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("transBrand")
public class TransBrandController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(TransBrandController.class.getName());
	@Autowired
	private TransBrandService transBrandService;
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("toTransBrandPage")
	@RequiresPermissions("transBrand:view")
	public String toTransBrandPage() {
		return PREFIX + "transBrand";
	}
	/**
	 * 获取分页数据
	 * @param page
	 * @return
	 */
	@RequestMapping("getTransBrandPage")
	@RequiresPermissions("transBrand:view")
	public	@ResponseBody PageEasyUi<TransBrand> getTransBrandPage(PageEasyUi<TransBrand> page, TransBrand entity){
		PageEasyUi<TransBrand> result=null;
		try{
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<TransBrand> list = this.transBrandService.searchByProperty(entity);
			result = new PageEasyUi<TransBrand>(list);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("getTransBrandList")
	@RequiresPermissions("transBrand:view")
	public	@ResponseBody List<TransBrand> getTransBrandList(){
		TransBrand transBrand =new TransBrand();
		List<TransBrand> result=null;
		try{
			result =this.transBrandService.searchByProperty(transBrand);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		return result;
	}
	/**
	 * 新建数据
	 * @param transBrand
	 * @return
	 */
	@RequestMapping("addTransBrand")
	@RequiresPermissions("transBrand:add")
	public @ResponseBody ResponseEntity<String> addTransBrand(TransBrand transBrand){
		if(CommonUtils.isEmpty(transBrand))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			this.transBrandService.create(transBrand);
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
	@RequestMapping("updateTransBrand")
	@RequiresPermissions("transBrand:update")
	public @ResponseBody ResponseEntity<String> updateTransBrand(TransBrand transBrand){
		if(CommonUtils.isEmpty(transBrand) || CommonUtils.isEmpty(transBrand.getTransBrandId()))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			TransBrand data = this.transBrandService.searchById(transBrand.getTransBrandId());
			if(CommonUtils.isNotEmpty(data)){
				  if(CommonUtils.isNotEmpty(transBrand.getTransBrandId()))data.setTransBrandId(transBrand.getTransBrandId());
				  if(CommonUtils.isNotEmpty(transBrand.getTransBrandCode()))data.setTransBrandCode(transBrand.getTransBrandCode());
				  if(CommonUtils.isNotEmpty(transBrand.getTransBrandName()))data.setTransBrandName(transBrand.getTransBrandName());
				  if(CommonUtils.isNotEmpty(transBrand.getRemark()))data.setRemark(transBrand.getRemark());
				  if(CommonUtils.isNotEmpty(transBrand.getCreateTime()))data.setCreateTime(transBrand.getCreateTime());
				  if(CommonUtils.isNotEmpty(transBrand.getUpdateTime()))data.setUpdateTime(transBrand.getUpdateTime());
			
				this.transBrandService.modify(data);
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
	@RequestMapping("deleteTransBrand")
	@RequiresPermissions("transBrand:delete")
	public @ResponseBody ResponseEntity<String> deleteTransBrand(String param){
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
			this.transBrandService.remove(ids);
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
	@RequestMapping("getTransBrandById")
	@RequiresPermissions("transBrand:view")
	public 	@ResponseBody ResponseEntity  getTransBrandById(Long id){
		if(CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		try {
			TransBrand transBrand=  this.transBrandService.searchById(id);
			if(null!=transBrand)
				return new ResponseEntity<TransBrand>(transBrand,HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}