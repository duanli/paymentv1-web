package cn.com.payment.admin;

import cn.com.payment.admin.utils.AmtUtils;

public class Test {
	public static void main(String[] args) {
		System.out.println(Long.valueOf(AmtUtils.yuanToFen("10.00")));
	}
}
