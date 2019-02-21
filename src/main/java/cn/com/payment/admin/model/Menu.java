package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * 代码生成器自动生成 Date:2015-6-10 16:35:00
 * 
 * @author rono
 */
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id; // 主键
	private Long parentId; // 所属资源id
	private String parentIds; // 上级菜单多个/分隔
	private String name; // 资源名
	private Integer menuType; // 资源类型 0 菜单 1 方法
	private String url; // 资源链接
	private String permission; // 菜单权限
	private Integer sort; // 序号
	private String icon; // 资源图标
	private String target; // 跳转目标
	private Integer level; // 资源级别(1 一级/2 二级/3 三级)
	private String desc; // 资源描述
	private Boolean isDel; // 显示标记
	private Date createDate; // 创建时间
	private Date updateDate; // 更新时间
	private String reserved1; // 保留字段1
	private String reserved2; // 保留字段2
	
	private String state;
	private String text;
	private Long roleId;
	private Long[] roleIds;
	private List<Menu> children;
	
	public Menu() {
	}
	
	public Menu(Long parentId) {
		this.parentId = parentId;
	}
	
	public Menu(Long parentId, Integer menuType, Long[] roleIds) {
		this.parentId = parentId;
		this.menuType = menuType;
		this.roleIds = roleIds;
	}

	/**
	 * 主键
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 所属资源id
	 * 
	 * @return parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 所属资源id
	 * 
	 * @param parentId
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 上级菜单多个/分隔
	 * 
	 * @return parentIds
	 */
	public String getParentIds() {
		return parentIds;
	}

	/**
	 * 上级菜单多个/分隔
	 * 
	 * @param parentIds
	 */
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	/**
	 * 资源名
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 资源名
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 资源类型 0 菜单 1 方法
	 * 
	 * @return menuType
	 */
	public Integer getMenuType() {
		return menuType;
	}

	/**
	 * 资源类型 0 菜单 1 方法
	 * 
	 * @param menuType
	 */
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}

	/**
	 * 资源链接
	 * 
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 资源链接
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 菜单权限
	 * 
	 * @return permission
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * 菜单权限
	 * 
	 * @param permission
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * 序号
	 * 
	 * @return sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 序号
	 * 
	 * @param sort
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 资源图标
	 * 
	 * @return icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 资源图标
	 * 
	 * @param icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 跳转目标
	 * 
	 * @return target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * 跳转目标
	 * 
	 * @param target
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * 资源级别(1 一级/2 二级/3 三级)
	 * 
	 * @return level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * 资源级别(1 一级/2 二级/3 三级)
	 * 
	 * @param level
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * 资源描述
	 * 
	 * @return desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 资源描述
	 * 
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * 显示标记
	 * 
	 * @return isDel
	 */
	public Boolean getIsDel() {
		return isDel;
	}

	/**
	 * 显示标记
	 * 
	 * @param isDel
	 */
	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	/**
	 * 创建时间
	 * 
	 * @return createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 创建时间
	 * 
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 更新时间
	 * 
	 * @return updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 更新时间
	 * 
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 保留字段1
	 * 
	 * @return reserved1
	 */
	public String getReserved1() {
		return reserved1;
	}

	/**
	 * 保留字段1
	 * 
	 * @param reserved1
	 */
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}

	/**
	 * 保留字段2
	 * 
	 * @return reserved2
	 */
	public String getReserved2() {
		return reserved2;
	}

	/**
	 * 保留字段2
	 * 
	 * @param reserved2
	 */
	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}
}