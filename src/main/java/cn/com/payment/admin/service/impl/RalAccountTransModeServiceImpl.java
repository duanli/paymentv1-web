package cn.com.payment.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.RalAccountTransModeMapper;
import cn.com.payment.admin.model.RalAccountTransMode;
import cn.com.payment.admin.model.RalAccountTransModeForMer;
import cn.com.payment.admin.service.RalAccountTransModeService;
import cn.com.payment.admin.utils.CommonUtils;

/**
 * RalAccountTransModeServiceImpl
 *
 * Date:2019-1-10 22:46:51
 * 
 * @author dl
 */
@Service
public class RalAccountTransModeServiceImpl extends BaseServiceImpl<RalAccountTransMode, Long>
		implements RalAccountTransModeService {
	@Autowired
	private RalAccountTransModeMapper ralAccountTransModeMapper;

	@Override
	public BaseMapper<RalAccountTransMode, Long> getBaseMapper() {
		return this.ralAccountTransModeMapper;
	}

	@Override
	public List<RalAccountTransModeForMer> searchRalAccountTransModeList(RalAccountTransMode ralAccountTransMode)
			throws BaseException {
		List<RalAccountTransModeForMer> result = new ArrayList<RalAccountTransModeForMer>();

		List<RalAccountTransMode> list = ralAccountTransModeMapper.selectByProperty(ralAccountTransMode);
		if (CommonUtils.isNotEmpty(list))
			for (RalAccountTransMode item : list) {
				result.add(new RalAccountTransModeForMer(item));
			}
		return result;
	}
}