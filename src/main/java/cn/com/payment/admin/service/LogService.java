package cn.com.payment.admin.service;

import cn.com.payment.admin.model.Log;

public interface LogService extends BaseService<Log, Long> {
	// 增删改
	public Long createLog(Log log);

	public void updateLog(Log log);
}