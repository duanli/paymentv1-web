package cn.com.payment.admin.mapper;

import java.util.List;

import cn.com.payment.admin.model.Menu;

/**
 * 代码生成器自动生成
 * Date:2015-6-10 16:41:38
 * @author rono
 */
public interface MenuMapper extends BaseMapper<Menu,Long>{
	/**
	 * 获取菜单和树形菜单
	 * @param menu
	 * @return
	 */
	List<Menu> selectTreeMenu(Menu menu)throws Exception;
	/**
	 * 获取角色关联的菜单
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	List<Menu> selectRoleMenu(Menu menu)throws Exception;
	/**
	 * 获取属性菜单
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	List<Menu> selectRoleMenuTree(Menu menu)throws Exception;
	
}