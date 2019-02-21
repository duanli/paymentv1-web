package cn.com.payment.admin.dto;

public interface IResponse {

	/**
	 * 成功
	 */
	public static String SUCCESS = "0000";

	/**
	 * 成功但无数据
	 */
	public static String SUCCESS_NODATA = "0001";
	/**
	 * 请求过期，需要重新登录
	 */
	public static String ERROR_EXPIRED = "1000";

	/**
	 * 无效的请求
	 */
	public static String INVALID_REQUEST = "1001";
	/**
	 * 数据不存在
	 */
	public static String DATA_NOT_FONUD = "1002";

	/**
	 * 数据存在
	 */
	public static String DATA_EXISTS = "1003";
	
	

	/**
	 * 无法识别的类型
	 */
	public static String UNRECOGNIABLE_CALSS = "1004";

	/**
	 * 数据解析错误
	 */
	public static String DATA_RESOLVE = "1005";

	/**
	 * 数据为空
	 */
	public static String DATA_NULL = "1006";
	
	
	/**
	 * 无权限访问
	 */
	public static String NO_ACCESS = "2000";
	/**
	 * 操作不被允许
	 */
	public static String DISALLOW_OPERATION = "2001";
	/**
	 * 认证异常
	 */
	public static String ERROR_AUTH = "2002";
	/**
	 * 验证异常
	 */
	public static String ERROR_VERIFICATION = "2003";

	/**
	 * 
	 */
	public static String FILE_OPERATION = "2004";

	/**
	 * 网络异常
	 * 
	 */
	public static String NET_ERROR = "3000";

	/**
	 * 调用接口异常
	 */
	public static String THIRD_API = "3001";
	/**
	 * 重定向异常
	 * 
	 */
	public static String NET_REDIRECT = "3002";

	/**
	 * 数据库操作异常
	 * 
	 */
	public static String DB_OPRATOR = "4000";

	/**
	 * 系统内部异常
	 * 
	 */
	public static String SYSTEM_ERR = "5000";

	/**
	 * 数据库操作异常
	 * 
	 */
	public static String LOADING_ERR = "6000";

}
