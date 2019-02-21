package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * 代码生成器自动生成 Date:2015-6-10 16:35:00
 * 
 * @author rono
 */
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id; // 主键
	private String name; // 角色名称
	private String enName; // 英文名称
	private String remark; // 角色描述
	private Boolean isDel; // 显示标记(0
	private Date updateDate; // 创建时间
	private Date createDate; // 更新时间
	private String reserved1; // 保留字段1
	private String reserved2; // 保留字段2
	
	// 角色拥有的菜单
	private List<Menu> menus;//菜单

	public Role() {
	}
	
	public Role(String enName) {
		this.enName = enName;
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
	 * 角色名称
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 角色名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 英文名称
	 * 
	 * @return enName
	 */
	public String getEnName() {
		return enName;
	}

	/**
	 * 英文名称
	 * 
	 * @param enName
	 */
	public void setEnName(String enName) {
		this.enName = enName;
	}

	/**
	 * 角色描述
	 * 
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 角色描述
	 * 
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 显示标记(0
	 * 
	 * @return isDel
	 */
	public Boolean getIsDel() {
		return isDel;
	}

	/**
	 * 显示标记(0
	 * 
	 * @param isDel
	 */
	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	/**
	 * 创建时间
	 * 
	 * @return updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 创建时间
	 * 
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 更新时间
	 * 
	 * @return createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 更新时间
	 * 
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
}