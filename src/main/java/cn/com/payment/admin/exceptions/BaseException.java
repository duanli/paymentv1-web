package cn.com.payment.admin.exceptions;

import cn.com.payment.admin.dto.IResponse;

/**
 * 
 * 
 * @author 作者 jesse E-mail: 87392304@qq.com
 * @date 创建时间：2016-11-24 下午2:14:24
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@SuppressWarnings("serial")
public class BaseException extends Exception implements IResponse {

	

	private String code;
	/**
	 * App提示信息
	 */
	private String tips;
	private Exception failure;

	public BaseException() {
	}

	public BaseException(final String code) {
		this.code = code;
	}

	public BaseException(final String code,final String failureMessage) {
		super(failureMessage);
		this.code = code;
		this.tips = failureMessage;
	}
	
	public BaseException(final String code, final String failureMessage, final String tips) {
		super(failureMessage);
		this.code = code;
		this.tips = tips;
	}

	public BaseException(final String code, String failureMessage, final Exception failure, final String tips) {
		super(failureMessage);
		this.code = code;
		this.tips = tips;
		this.setFailure(failure);
	}

	public BaseException(BaseException be) {
		super(be.getMessage());
		this.code = be.getCode();
		this.tips = be.getTips();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Exception getFailure() {
		return failure;
	}

	public void setFailure(Exception failure) {
		this.failure = failure;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}
}
