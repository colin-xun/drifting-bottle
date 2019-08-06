package com.moudao.util;

import java.util.List;

/**
 * 分页结果实体类
 * @param <T>
 */
public class PageInfoResult<T> {
	/**
	 * 当前第几页
	 */
	private int pageIndex;

	/**
	 * 当前分页大小
	 */
	private int pageSize;

	/**
	 * 当前记录条数
	 */
	private int totalCount;

	/**
	 * 请求的响应结果数据
	 */
	private List<T> items;

	public PageInfoResult() {
	}

	public PageInfoResult(int pageIndex, int pageSize, int totalCount, List<T> items) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.items = items;
	}

	public PageInfoResult(List<T> items) {
		this.items = items;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
}
