package cn.com.payment.admin.contansts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AcountContants {

	public static String acountMsgurl;// 访问地址

	public static String acountKey;// 账户key

	public static String acountSysId;// 系统id
	
	public static String merchantUrl;//入网url地址

	@Value("${acount.msgurl}")
	public void setAcountMsgurl(String acountMsgurl) {
		AcountContants.acountMsgurl = acountMsgurl;
	}

	@Value("${acount.key}")
	public void setAcountKey(String acountKey) {
		AcountContants.acountKey = acountKey;
	}

	@Value("${acount.sysid}")
	public void setAcountSysId(String acountSysId) {
		AcountContants.acountSysId = acountSysId;
	}
	@Value("${merchant.baseurl}")
	public void setMerchantUrl(String merchantUrl) {
		AcountContants.merchantUrl = merchantUrl;
	}

}
