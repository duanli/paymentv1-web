package cn.com.payment.admin.dto;

import java.util.ArrayList;
import java.util.List;

public class PageJson<T> {
	private Integer total;
	private Integer pageSize;   // 每页显示条数
	private Integer pageNumber; // 当前页数
	
    private List<T> rows = new ArrayList<T>();
    
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPageSize() {
		if(null==pageSize)
			return 10;
		else
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNumber() {
		if(null==pageNumber)
			return 1;
		else
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}