package cn.com.payment.admin.utils;

import com.github.pagehelper.PageHelper;

import cn.com.payment.admin.exceptions.BaseException;

public class PageUtils {
	public static void initPages(Integer currentPage, Integer showCount) throws BaseException {
		if (CommonUtils.isNotEmpty(currentPage)&&currentPage!=0) {
			if (CommonUtils.isNotEmpty(showCount)&&showCount!=0) {
				PageHelper.startPage(currentPage, showCount, true, false);
			} else {
				PageHelper.startPage(currentPage, 10, true, false);
			}
		} else {
			if (CommonUtils.isNotEmpty(showCount)&&showCount!=0)
				PageHelper.startPage(1, showCount, true, false);
			else
				PageHelper.startPage(1, 10, true, false);
		}
	}

}
