package cn.com.payment.admin.service;

import java.util.List;

import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.RalAccountTransMode;
import cn.com.payment.admin.model.RalAccountTransModeForMer;

/**
 * RalAccountTransModeService
 *
 * Date:2019-1-10 22:43:30
 * 
 * @author dl
 */
public interface RalAccountTransModeService extends BaseService<RalAccountTransMode, Long> {

	public List<RalAccountTransModeForMer> searchRalAccountTransModeList(RalAccountTransMode ralAccountTransMode)
			throws BaseException;

}