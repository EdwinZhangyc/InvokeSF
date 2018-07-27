package com.zyc.demo.Utils;


import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Http请求公共类
 */
public class HttpUtils {
	private static final String CHARSET = "UTF-8";
	private static final int CONNECT_TIMEOUT = 30*1000;
	private static final int SO_TIMEOUT = 65*1000;
	public static final String PROTOCOL = "http";
	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	public static String doPost(String protocol, String url, String xml) throws Exception {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse resp = null;
		String rtnValue = null;

		logger.info("url:" + url + ";xml:" + xml);
		try {
			if ("http".equals(protocol)) {
				httpClient = HttpClients.createDefault();
			} else {
				httpClient = getHttpsClient();
			}

			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SO_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT)
					.build();

			httpPost.setConfig(requestConfig);
			StringEntity s= new StringEntity(xml,Charset.forName(CHARSET));
			s.setContentType("text/xml; charset=UTF-8");
			s.setContentEncoding(CHARSET);
			httpPost.setEntity(s);
			resp = httpClient.execute(httpPost);

			rtnValue = EntityUtils.toString(resp.getEntity(), CHARSET);

			logger.info("respPojo :" + rtnValue);
			int status = resp.getStatusLine().getStatusCode();
			if (status != 200) {
				if (status == 404) {
					logger.error("this server is not found : " + rtnValue);
					throw new Exception();
				}

			}

		} catch (ConnectTimeoutException e) {
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("", e);
			e.printStackTrace();
		} finally {
			if (null != resp) {
				try {
					resp.close();
				} catch (IOException e) {
					logger.info("", e);
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					logger.info("", e);
				}
			}
		}
		return rtnValue;
	}
	public static String doPostForHtml(String protocol, String url, String str) throws Exception {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse resp = null;
		String rtnValue = null;

		logger.info("url:" + url + ";请求参数:" + str);
		try {
			if ("http".equals(protocol)) {
				httpClient = HttpClients.createDefault();
			} else {
				httpClient = getHttpsClient();
			}

			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SO_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT)
					.build();

			httpPost.setConfig(requestConfig);
			StringEntity s= new StringEntity(str,Charset.forName(CHARSET));
			s.setContentType("text/xml; charset=UTF-8");
			s.setContentEncoding(CHARSET);
			httpPost.setEntity(s);
			resp = httpClient.execute(httpPost);

			rtnValue = EntityUtils.toString(resp.getEntity(), CHARSET);

			logger.info("respPojo :" + rtnValue);
			int status = resp.getStatusLine().getStatusCode();
			if (status != 200) {
				if (status == 404) {
					logger.error("this server is not found : " + rtnValue);
					throw new Exception();
				}

			}

			return rtnValue;
		} catch (ConnectTimeoutException e) {
			throw new Exception();
		} catch (SocketTimeoutException e) {
			throw new Exception();
		} catch (Exception e) {
			logger.error("", e);
			throw new Exception();
		} finally {
			if (null != resp) {
				try {
					resp.close();
				} catch (IOException e) {
					logger.info("", e);
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					logger.info("", e);
				}
			}
		}
	}
	public static String doGet(String protocol, String url, String xml) throws Exception {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse resp = null;
		String rtnValue = null;

		logger.info("url:" + url + ";xml:" + xml);
		try {
			if ("http".equals(protocol)) {
				httpClient = HttpClients.createDefault();
			} else {
				httpClient = getHttpsClient();
			}
			//请求参数拼接
            url=url+"?"+xml;  
			HttpGet httpGet = new HttpGet(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SO_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT)
					.build();

			httpGet.setConfig(requestConfig);
			// 设置请求头部类型
			httpGet.setHeader("Content-Type", "text/xml");
			httpGet.setHeader("charset", CHARSET);
			resp = httpClient.execute(httpGet);

			rtnValue = EntityUtils.toString(resp.getEntity(), CHARSET);

			logger.info("respPojo :" + rtnValue);
			int status = resp.getStatusLine().getStatusCode();
			if (status != 200) {
				if (status == 404) {
					logger.error("this server is not found : " + rtnValue);
					throw new Exception();
				}

			}

			return rtnValue;
		} catch (ConnectTimeoutException e) {
			throw new Exception();
		} catch (SocketTimeoutException e) {
			throw new Exception();
		} catch (Exception e) {
			logger.error("", e);
			throw new Exception();
		} finally {
			if (null != resp) {
				try {
					resp.close();
				} catch (IOException e) {
					logger.info("", e);
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					logger.info("", e);
				}
			}
		}
	}
	public static String doGetForHtml(String protocol, String url, String str) throws Exception {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse resp = null;
		String rtnValue = null;

		logger.info("url:" + url+ "?"+  str);
		try {
			if ("http".equals(protocol)) {
				httpClient = HttpClients.createDefault();
			} else {
				httpClient = getHttpsClient();
			}
			//请求参数拼接
            url=url+"?"+str;  
			HttpGet httpGet = new HttpGet(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SO_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT)
					.build();

			httpGet.setConfig(requestConfig);
			// 设置请求头部类型
			httpGet.setHeader("Content-Type", "text/html");
			httpGet.setHeader("charset", CHARSET);
	
			resp = httpClient.execute(httpGet);

			rtnValue = EntityUtils.toString(resp.getEntity(), CHARSET);

			logger.info("respPojo :" + rtnValue);
			int status = resp.getStatusLine().getStatusCode();
			if (status != 200) {
				if (status == 404) {
					logger.error("this server is not found : " + rtnValue);
					throw new Exception();
				}
			}
			return rtnValue;
		} catch (ConnectTimeoutException e) {
			throw new Exception();
		} catch (SocketTimeoutException e) {
			throw new Exception();
		} catch (Exception e) {
			logger.error("", e);
			throw new Exception();
		} finally {
			if (null != resp) {
				try {
					resp.close();
				} catch (IOException e) {
					logger.info("", e);
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					logger.info("", e);
				}
			}
		}
	}

	public static CloseableHttpClient getHttpsClient() throws Exception {
		try {
			TrustManager[] trustManagers = { new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
						throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
						throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			} };
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(new KeyManager[0], trustManagers, new SecureRandom());
			SSLContext.setDefault(sslContext);
			sslContext.init(null, trustManagers, null);
			SSLConnectionSocketFactory connectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			HttpClientBuilder clientBuilder = HttpClients.custom().setSSLSocketFactory(connectionSocketFactory);
			clientBuilder.setRedirectStrategy(new LaxRedirectStrategy());
			return clientBuilder.build();
		} catch (Exception e) {
			throw new Exception("http client 远程连接失败", e);
		}
	}
}
