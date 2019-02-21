package cn.com.payment.admin.controller.sys;

import java.util.ArrayList;
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
import cn.com.payment.admin.controller.context.BaseController;
import cn.com.payment.admin.dto.TreeBean;
import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.Menu;
import cn.com.payment.admin.service.RoleAuthService;
import cn.com.payment.admin.utils.CommonUtils;

@Controller
@RequestMapping("menu")
public class MenuController extends BaseController{
	private static final String PREFIX = "sys/";
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class.getName());
	@Autowired
	private RoleAuthService menuService;
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("toMenuPage")
	@RequiresPermissions("menu:view")
	public String toMenuPage() {
		return PREFIX + "menu";
	}
	/**
	 * 获取树形数据(兼容easyui)
	 * @param page
	 * @return
	 */
	@RequestMapping("/getAsyncTree")
	@RequiresPermissions("menu:view")
	public @ResponseBody ResponseEntity<TreeBean<Menu>> getTreeMenu(Long parentId){
		if(null ==parentId)
			parentId = 0L;
		
		try {
			List<Menu> list = this.menuService.searchByProperty(new Menu(parentId));
			if(null!=list && list.size()>0){
				for(Menu m:list){
					if(null!=m){
						m.setState(null!=m.getMenuType() && m.getMenuType()==0?"closed":"open");
					}
				}
				TreeBean<Menu> zt = new TreeBean<Menu>();
				zt.setTotal(list.size());
				zt.setRows(list);
				return new ResponseEntity<TreeBean<Menu>>(zt,HttpStatus.OK);
			}
			return new ResponseEntity<TreeBean<Menu>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<TreeBean<Menu>>(new TreeBean<Menu>(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/**
	 * 获取属性列表
	 * @param id
	 * @return
	 */
	@RequestMapping("/getTreeList")
	@RequiresPermissions("menu:view")
	public @ResponseBody ResponseEntity<List<Menu>> getTreeList(Long id){
		if(null ==id)
			id = 0L;
		
		try {
			List<Menu> list = this.menuService.searchByProperty(new Menu(id));
			if(null!=list && list.size()>0){
				for(Menu m:list){
					if(null!=m){
						m.setState(null!=m.getMenuType() && m.getMenuType()==0?"closed":"open");
					}
				}
				return new ResponseEntity<List<Menu>>(list,HttpStatus.OK);
			}
			return new ResponseEntity<List<Menu>>(list,HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<List<Menu>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/**
	 * 获取树形菜单(childrens)
	 * @return
	 */
	@RequestMapping("/getTreeMenu")
	@RequiresPermissions("menu:view")
	public @ResponseBody ResponseEntity<List<Menu>> getTreeMenu(){
		try {
			List<Menu> list = this.menuService.searchTreeMenu(new Menu(0L));
			if(null!=list && list.size()>0){
				return new ResponseEntity<List<Menu>>(list,HttpStatus.OK);
			}else
				return new ResponseEntity<List<Menu>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<List<Menu>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 新建数据
	 * @param menu
	 * @return
	 */
	@RequestMapping("addMenu")
	@RequiresPermissions("menu:add")
	public @ResponseBody ResponseEntity<String> addMenu(Menu menu){
		if(CommonUtils.isEmpty(menu))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			this.menuService.create(menu);
			return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
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
	@RequestMapping("updateMenu")
	@RequiresPermissions("menu:update")
	public @ResponseBody ResponseEntity<String> updateMenu(Menu menu){
		if(null ==menu || CommonUtils.isEmpty(menu.getId()))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);
		
		try {
			Menu data = this.menuService.searchById(menu.getId());
			if(CommonUtils.isNotEmpty(data)){
				  if(CommonUtils.isNotEmpty(menu.getName()))data.setName(menu.getName());
				//  if(CommonUtils.isNotEmpty(menu.getMenuType()))data.setMenuType(menu.getMenuType());
				  if(CommonUtils.isNotEmpty(menu.getUrl()))data.setUrl(menu.getUrl());
				  if(CommonUtils.isNotEmpty(menu.getPermission()))data.setPermission(menu.getPermission());
				  if(CommonUtils.isNotEmpty(menu.getSort()))data.setSort(menu.getSort());
				  if(CommonUtils.isNotEmpty(menu.getTarget()))data.setTarget(menu.getTarget());
				  if(CommonUtils.isNotEmpty(menu.getDesc()))data.setDesc(menu.getDesc());
			
				this.menuService.modify(data);
				return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
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
	@RequestMapping(value="deleteMenu",produces = "application/json")
	@RequiresPermissions("menu:delete")
	public @ResponseBody ResponseEntity<String> deleteMenu(String param){
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
			this.menuService.remove(ids);
			return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
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
	@RequestMapping("getMenuById")
	@RequiresPermissions("menu:view")
	public 	@ResponseBody ResponseEntity  getMenuById(Long id){
		if(CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM,HttpStatus.BAD_REQUEST);

		try {
			Menu menu=  this.menuService.searchById(id);
			if(null!=menu)
				return new ResponseEntity<Menu>(menu,HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (BaseException e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//************************************************************************************
	/**
	 * 获取角色菜单列表
	 * @param roleId
	 * @param menuType
	 * @param parentId
	 * @return
	 */
	@RequestMapping("getRoleMenu")
	/*@RequiresPermissions("menu:view")*/
	public 	@ResponseBody ResponseEntity<List<Menu>> getRoleMenu(Long roleId,Integer menuType,Long parentId){
		try {
			Menu menu = new Menu();
			if(CommonUtils.isNotEmpty(roleId))
				menu.setRoleId(roleId);
			else{
				menu.setRoleIds(getLoginUserRoleIds());
			}
			if(null!=menuType)
				menu.setMenuType(menuType);
			if(null!=parentId)
				menu.setParentId(parentId);
			
			List<Menu> list = this.menuService.searchRoleMenu(menu);
			if(null!=list && list.size()>0){
				return new ResponseEntity<List<Menu>>(list,HttpStatus.OK);
			}else
				return new ResponseEntity<List<Menu>>(new ArrayList<Menu>(),HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<List<Menu>>(new ArrayList<Menu>(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/**
	 * 获取角色属性菜单
	 * @param roleId
	 * @param menuType
	 * @param parentId
	 * @return
	 */
	@RequestMapping("getRoleMenuTree")
/*	@RequiresPermissions("menu:view")*/
	public 	@ResponseBody ResponseEntity<List<Menu>> getRoleMenuTree(Long roleId,Integer menuType,Long parentId){
		try {
			Menu menu = new Menu();
			if(CommonUtils.isNotEmpty(roleId))
				menu.setRoleId(roleId);
			else{
				menu.setRoleIds(getLoginUserRoleIds());
			}
			if(null!=menuType)
				menu.setMenuType(menuType);
			if(null!=parentId)
				menu.setParentId(parentId);
			
			List<Menu> list = this.menuService.searchRoleMenuTree(menu);
			if(null!=list && list.size()>0){
				return new ResponseEntity<List<Menu>>(list,HttpStatus.OK);
			}else
				return new ResponseEntity<List<Menu>>(new ArrayList<Menu>(),HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return new ResponseEntity<List<Menu>>(new ArrayList<Menu>(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}