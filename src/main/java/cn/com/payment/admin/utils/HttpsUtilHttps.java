package cn.com.payment.admin.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpsUtilHttps {
	private static Logger log = Logger.getLogger(String.valueOf(HttpsUtilHttps.class));

	private static class TrustAnyTrustManager implements X509TrustManager {
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}
	}

	private static class TrustAnyHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String httpSendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				log.info(key + "---> " + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.info("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		log.info("返回原始数据===>" + result);
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 *            multipart/form-data
	 * @return 所代表远程资源的响应结果
	 */
	public static String httpPostFormData(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=----WebKitFormBoundaryW47Rk9FS5QgIUyPX");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.info("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		log.info("返回原始数据===>" + result);
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2
	 *            的形式。application/x-www-form-urlencoded
	 * @return 所代表远程资源的响应结果
	 */
	public static String httpPostWWWForm(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// application/x-www-form-urlencoded

			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			// conn.setRequestProperty("Content-Length","255");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			log.info("请求url==>" + url + "\r\n" + "请求原始数据===>" + param);
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.info("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		log.info("返回原始数据===>" + result);
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 json 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String httpPostJson(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// application/x-www-form-urlencoded

			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			// conn.setRequestProperty("Content-Length","255");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("accept", "application/json");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			log.info("请求url==>" + url + "/n/r" + "请求原始数据===>" + param);
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.info("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		log.info("返回原始数据===>" + result);
		return result;
	}

	/**
	 * 向指定URL发送POST方法的请求 (Https 模式)
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param content
	 *            发送的数据
	 * @param charset
	 *            字符集
	 * @return 所代表远程资源的响应结果
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 * @throws IOException
	 */
	public static String doSslPostRaw(String url, String content, String charset) {
		InputStream is = null;
		DataOutputStream out = null;
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
			URL console = new URL(url);
			HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
			conn.setSSLSocketFactory(sc.getSocketFactory());
			conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			conn.connect();
			log.info("url==>" + url + "/n/r" + "请求原始数据===>" + content);
			out = new DataOutputStream(conn.getOutputStream());
			out.write(content.getBytes(charset));
			// flush输出流的缓冲
			out.flush();
			is = conn.getInputStream();
			if (is != null) {
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = is.read(buffer)) != -1) {
					outStream.write(buffer, 0, len);
				}
				return new String(outStream.toByteArray(), charset);
			}
		} catch (Exception e) {
			log.info("请求地址为[" + url + "],请求的数据为[" + content + "]发送https请求发生异常：" + e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * 向指定URL发送GET方法的请求 (Https 模式)
	 * 
	 * @param url
	 *            发送请求的URL 包含请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @param charset
	 *            字符集
	 * @return 所代表远程资源的响应结果
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 * @throws IOException
	 */
	public static String doSslGet(String url, String charset)
			throws NoSuchAlgorithmException, KeyManagementException, IOException {
		InputStream is = null;
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
			URL console = new URL(url);
			HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
			conn.setSSLSocketFactory(sc.getSocketFactory());
			conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			conn.connect();
			is = conn.getInputStream();
			if (is != null) {
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = is.read(buffer)) != -1) {
					outStream.write(buffer, 0, len);
				}
				try {
					return new String(outStream.toByteArray(), charset);
				} catch (Exception e) {
					throw new RuntimeException("发送GET请求出现异常.");
				} finally {
					is.close();
					is = null;
					outStream.close();
					outStream = null;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("发送GET请求出现异常.");
		} finally {
			if (is != null)
				is.close();
		}
		return null;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 *            multipart/form-data
	 * @return 所代表远程资源的响应结果
	 */
	public static String doSslPostFormData(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=----WebKitFormBoundaryW47Rk9FS5QgIUyPX");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			log.info("url==>" + url + "/n/r" + "请求原始数据===>" + param);
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.info("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		log.info("返回原始数据===>" + result);
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2
	 *            的形式。application/x-www-form-urlencoded
	 * @return 所代表远程资源的响应结果
	 */
	public static String doSslPostWWWForm(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			log.info("url==>" + url + "/n/r" + "请求原始数据===>" + param);
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.info("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		log.info("返回原始数据===>" + result);
		return result;
	}

	public static String uploadFile(String url, Map<String, String> param) {
		List<String> list = new ArrayList<String>(); // 要上传的文件名,如：d:\haha.doc.你要实现自己的业务。我这里就是一个空list.
		list.add("C:\\Users\\Administrator\\Desktop\\1.jpg");
		String line = null;
		try {
			String BOUNDARY = "---------7d4a6d158c9"; // 定义数据分隔线
			URL realurl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) realurl.openConnection();
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setRequestProperty("Charsert", "UTF-8");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

			OutputStream out = new DataOutputStream(conn.getOutputStream());
			byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();// 定义最后数据分隔线
			// 参数
			for (String key : param.keySet()) {
				StringBuilder sbparam = new StringBuilder();
				sbparam.append("--");
				sbparam.append(BOUNDARY);
				sbparam.append("\r\n");
				sbparam.append("Content-Disposition: form-data;name=\"" + key + "\"\r\n\r\n");
				sbparam.append(param.get(key));
				out.write(sbparam.toString().getBytes());
			}
			// 文件
			int leng = list.size();
			for (int i = 0; i < leng; i++) {
				String fname = list.get(i);
				File file = new File(fname);
				StringBuilder sb = new StringBuilder();
				sb.append("--");
				sb.append(BOUNDARY);
				sb.append("\r\n");
				sb.append("Content-Disposition: form-data;name=\"file" + i + "\";filename=\"" + file.getName()
						+ "\"\r\n");
				sb.append("Content-Type:application/octet-stream\r\n\r\n");

				byte[] data = sb.toString().getBytes();
				out.write(data);
				DataInputStream in = new DataInputStream(new FileInputStream(file));
				int bytes = 0;
				byte[] bufferOut = new byte[1024];
				while ((bytes = in.read(bufferOut)) != -1) {
					out.write(bufferOut, 0, bytes);
				}
				out.write("\r\n".getBytes()); // 多个文件时，二个文件之间加入这个
				in.close();
			}
			out.write(end_data);
			out.flush();
			out.close();

			// 定义BufferedReader输入流来读取URL的响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		}
		return line;
	}

	/**
	 * 下载远程文件并保存到本地
	 * 
	 * @param remoteFilePath
	 *            远程文件路径
	 * @param localFilePath
	 *            本地文件路径
	 */
	public static void downloadFile(String remoteFilePath, String localFilePath) {
		URL urlfile = null;
		HttpURLConnection httpUrl = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		File f = new File(localFilePath);
		try {
			urlfile = new URL(remoteFilePath);
			httpUrl = (HttpURLConnection) urlfile.openConnection();
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(f));
			int len = 2048;
			byte[] b = new byte[len];
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
			}
			bos.flush();
			bis.close();
			httpUrl.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * hashMap 转化成表单字符串
	 * 
	 * @param map
	 * @return
	 */
	public static String mapStrToFormStr(Map<String, String> map) {
		StringBuilder stringBuilder = new StringBuilder();
		if (map == null) {
			return stringBuilder.toString();
		} else {
			for (Map.Entry<String, String> entry : map.entrySet()) {
				if (null != entry.getValue() && !"".equals(entry.getValue())) {
					stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
				}
			}
			return stringBuilder.substring(0, stringBuilder.length() - 1);
		}
	}

	public static String mapObjToFormStr(Map<String, Object> map) {
		if (map == null) {
			return "";
		}
		List<String> listStr = new ArrayList<String>();

		for (String name : map.keySet()) {
			Object value = map.get(name);// 得到每个key多对用value的值
			// if (!name.equals("sign") && CommonUtils.isNotEmpty(value)) {
			listStr.add(name + "=" + value);
			// }
		}
		// 节点间以&符连接，形成最终待签名字符串
		// Collections.sort(listStr);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < listStr.size(); i++) {
			String msg = listStr.get(i);
			if (i > 0) {
				sb.append("&");
			}
			sb.append(msg);
		}
		// System.out.println("signString=" + sb.toString());
		return sb.toString();
	}
}
