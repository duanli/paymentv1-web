package cn.com.payment.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.dto.ComboTreeBase;
import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.ProviderMapper;
import cn.com.payment.admin.model.Provider;
import cn.com.payment.admin.model.ProviderAccount;
import cn.com.payment.admin.model.RalProviderTransMode;
import cn.com.payment.admin.service.ProviderService;
import cn.com.payment.admin.utils.CommonUtils;

/**
 * ProviderServiceImpl
 *
 * Date:2019-1-10 22:46:51
 * 
 * @author dl
 */
@Service
public class ProviderServiceImpl extends BaseServiceImpl<Provider, Long> implements ProviderService {
	@Autowired
	private ProviderMapper providerMapper;

	@Override
	public BaseMapper<Provider, Long> getBaseMapper() {
		return this.providerMapper;
	}

	@Override
	public List<ComboTreeBase> searchProviderAccTree(Provider provider) throws BaseException {
		List<ComboTreeBase> result = new ArrayList<ComboTreeBase>();
		List<Provider> list = providerMapper.selectProviderAccTree(provider);
		if (CommonUtils.isNotEmpty(list)) {
			for (Provider item : list) {
				ComboTreeBase comboTreeP = new ComboTreeBase();
				comboTreeP.setId("F"+String.valueOf(item.getProviderId()));
				comboTreeP.setText(item.getProviderAlias());
				comboTreeP.setState("close");
				if (CommonUtils.isNotEmpty(item.getProviderAccounts())) {
					List<ComboTreeBase> providerAccList = new ArrayList<ComboTreeBase>();
					for (ProviderAccount providerAccount : item.getProviderAccounts()) {
						ComboTreeBase comboTreeC = new ComboTreeBase();
						comboTreeC.setId(String.valueOf(providerAccount.getProviderAccId()));
						comboTreeC.setText(providerAccount.getAccName());
						providerAccList.add(comboTreeC);
					}
					comboTreeP.setChildren(providerAccList);
				}
				result.add(comboTreeP);
			}
		}
		return result;
	}

	@Override
	public List<ComboTreeBase> searchProviderTransModeTree(Provider provider) throws BaseException {
		List<ComboTreeBase> result = new ArrayList<ComboTreeBase>();
		List<Provider> list = providerMapper.selectProviderTransModeTree(provider);
		if (CommonUtils.isNotEmpty(list)) {
			for (Provider item : list) {
				ComboTreeBase comboTreeP = new ComboTreeBase();
				comboTreeP.setId("F"+String.valueOf(item.getProviderId()));
				comboTreeP.setText(item.getProviderAlias());
				comboTreeP.setState("close");
				if (CommonUtils.isNotEmpty(item.getRalProviderTransModes())) {
					List<ComboTreeBase> providerTransModeList = new ArrayList<ComboTreeBase>();
					for (RalProviderTransMode ralProviderTransMode : item.getRalProviderTransModes()) {
						ComboTreeBase comboTreeC = new ComboTreeBase();
						comboTreeC.setId(String.valueOf(ralProviderTransMode.getProductId()));
						comboTreeC.setText(ralProviderTransMode.getProductName());
						providerTransModeList.add(comboTreeC);
					}
					comboTreeP.setChildren(providerTransModeList);
				}
				result.add(comboTreeP);
			}
		}
		return result;
	}
}