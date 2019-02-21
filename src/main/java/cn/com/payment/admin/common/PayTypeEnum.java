package cn.com.payment.admin.common;

public enum PayTypeEnum {
	/**
	 * 00,微信
	 */
	WECHAT("00", "微信")
	/**
	 * 01, "支付宝"
	 */
	,ALIPAY("01", "支付宝")
	/**
	 * 02, "京东"
	 */
	,JDPAY("02", "京东支付")
	/**
	 * 03, "翼支付"
	 */
	,BESTPAY("03", "翼支付")
	
	,MICROPAY("S0", "被扫")
	
	,PREPAY("S1", "主扫")
	
	/**
	 * -1,"未知类型"
	 */
	,UNDEFINED("-1", "未知类型");

	private String type;
	private String msg;

	private PayTypeEnum(String type, String msg) {
		this.type = type;
		this.msg = msg;
	}

	private static PayTypeEnum valueOfType(String type) {
		PayTypeEnum[] payTypeEnums = PayTypeEnum.values();
		for (PayTypeEnum payTypeEnum : payTypeEnums) {
			if (payTypeEnum.getType().equals(type)) {
				return payTypeEnum;
			}
		}
		return UNDEFINED;
	}

	public static String getStateMsg(String type) {
		return valueOfType(type).getMsg();
	}

	public boolean eqaulsType(String type) {
		return this.type.equals(type);
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
