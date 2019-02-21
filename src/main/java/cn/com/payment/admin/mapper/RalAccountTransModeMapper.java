package cn.com.payment.admin.mapper;

import java.util.List;

import cn.com.payment.admin.exceptions.DBAccessException;
import cn.com.payment.admin.model.RalAccountTransMode;

/**
 * RalAccountTransModeMapper
 * 
 * Date:2019-1-10 22:23:54
 * 
 * @author dl
 */
public interface RalAccountTransModeMapper extends BaseMapper<RalAccountTransMode, Long> {

	public List<RalAccountTransMode> selectByMchId(Long mchId) throws DBAccessException;
	
}