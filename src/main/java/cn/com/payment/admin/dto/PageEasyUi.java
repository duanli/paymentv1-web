package cn.com.payment.admin.dto;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class PageEasyUi<T> extends PageInfo<T> {
	private static final long serialVersionUID = 1L;
	// 结果集
	private List<T> rows;

	private Integer pageNumber; // 当前页数

	public PageEasyUi() {
		super();
	}

	/**
	 * 包装Page对象
	 *
	 * @param list
	 */
	public PageEasyUi(List<T> list) {
		this(list, 8);
	}

	/**
	 * 包装Page对象
	 *
	 * @param list
	 *            page结果
	 * @param navigatePages
	 *            页码数量
	 */
	public PageEasyUi(List<T> list, int navigatePages) {
		super(list, navigatePages);
		super.setList(null);
		this.pageNumber = super.getPageNum();
		this.rows = list;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

}
