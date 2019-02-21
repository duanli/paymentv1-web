package cn.com.payment.admin.common;

public enum MchTypeEnum {
	/**
	 * 00,微信
	 */
	GENARAL_MERCHNANT("0", "普通商户")
	/**
	 * 01, "支付宝"
	 */
	,ORG_MERCHNANT("1", "机构商户")
	/**
	 * 02, "京东"
	 */
	,CHAIN_MERCHNANT("2", "连锁商户")
	/**
	 * 03, "翼支付"
	 */
	,CHAINSHOP_MERCHNANT("3", "连锁门店")
	/**
	 * -1,"未知类型"
	 */
	,UNDEFINED("-1", "未知类型");

	private String type;
	private String msg;

	private MchTypeEnum(String type, String msg) {
		this.type = type;
		this.msg = msg;
	}

	private static MchTypeEnum valueOfType(String type) {
		MchTypeEnum[] payTypeEnums = MchTypeEnum.values();
		for (MchTypeEnum payTypeEnum : payTypeEnums) {
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
