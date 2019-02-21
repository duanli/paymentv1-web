package cn.com.payment.admin.contansts;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pagination implements Serializable {

	private Integer pageNumber = 1;

	private Integer pageSize = 10;

	private Integer rows = 0;

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

}