package cn.com.payment.admin.contansts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WxContants {

	public static String wx_accessToken = "";// 微信accessToken

	public static String wx_ticket = "";// 微信ticket

	public static String wxDefaultAppid;

	public static String wxDefaultSecret;

	public static String wxGetCodeUrl;

	public static String wxGetOpenIdUrl;

	public static String wxGetUserInfoUrl;

	public static String wxGetAccesstokenUrl;

	public static String wxGetTicketUrl;

	public static String wxSendModelMsgUrl;

	public static String wxGetTemplateIdUrl;

	public static String wxTemplateIdShortReg;
	
	public static String wxTemplateIdShortApply;

	@Value("${wx.gettemplateid.url}")
	public void setWxGetTemplateIdUrl(String wxGetTemplateIdUrl) {
		WxContants.wxGetTemplateIdUrl = wxGetTemplateIdUrl;
	}

	@Value("${wx.templateid.short.reg}")
	public void setWxTemplateIdShortReg(String wxTemplateIdShortReg) {
		WxContants.wxTemplateIdShortReg = wxTemplateIdShortReg;
	}
	
	@Value("${wx.templateid.short.apply}")
	public void setWxTemplateIdShortApply(String wxTemplateIdShortApply) {
		WxContants.wxTemplateIdShortApply = wxTemplateIdShortApply;
	}

	@Value("${wx.sendmsg.url}")
	public void setWxSendModelMsgUrl(String wxSendModelMsgUrl) {
		WxContants.wxSendModelMsgUrl = wxSendModelMsgUrl;
	}

	@Value("${wx.default.appid}")
	public void setWxDefaultAppid(String wxDefaultAppid) {
		WxContants.wxDefaultAppid = wxDefaultAppid;
	}

	@Value("${wx.default.secret}")
	public void setWxDefaultSecret(String wxDefaultSecret) {
		WxContants.wxDefaultSecret = wxDefaultSecret;
	}

	@Value("${wx.getcode.url}")
	public void setWxGetCodeUrl(String wxGetCodeUrl) {
		WxContants.wxGetCodeUrl = wxGetCodeUrl;
	}

	@Value("${wx.getopenid.url}")
	public void setWxGetOpenIdUrl(String wxGetOpenIdUrl) {
		WxContants.wxGetOpenIdUrl = wxGetOpenIdUrl;
	}

	@Value("${wx.getuserinfo.url}")
	public void setWxGetUserInfoUrl(String wxGetUserInfoUrl) {
		WxContants.wxGetUserInfoUrl = wxGetUserInfoUrl;
	}

	@Value("${wx.getaccesstoken.url}")
	public void setWxGetAccesstokenUrl(String wxGetAccesstokenUrl) {
		WxContants.wxGetAccesstokenUrl = wxGetAccesstokenUrl;
	}

	@Value("${wx.getticket.url}")
	public void setWxGetTicketUrl(String wxGetTicketUrl) {
		WxContants.wxGetTicketUrl = wxGetTicketUrl;
	}

}
