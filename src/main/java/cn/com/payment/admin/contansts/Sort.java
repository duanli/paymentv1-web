package cn.com.payment.admin.contansts;

public enum Sort {

	DESC("DESC"), AES("AES");

	Sort(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private String value;

}
