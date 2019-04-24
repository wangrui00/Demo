package com.chatboard.remote;

import com.chatboard.config.AppConfig;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class JsonRpcManager {

	private static Logger log = LoggerFactory.getLogger(JsonRpcManager.class);

	private static JsonRpcHttpClient getClient(String url) {
		JsonRpcHttpClient client = null;
		try {
			client = new JsonRpcHttpClient(new URL(url));
			// 请求头中添加的信息
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("appId", AppConfig.appId);
			// 添加到请求头中去
			client.setHeaders(headers);
			return client;
		} catch (Exception e) {
			log.error("error:", e);
			return null;
		}
	}

	public static <T> T invoke(Object[] params, Class<T> clazz, String url, String methodName) {
		JsonRpcHttpClient client = getClient(url);
		log.debug("params is {},url is {},clazz is {},methodName is {}",params,url,clazz,methodName);
		try {
			return client.invoke(methodName, params, clazz);
		} catch (Throwable e) {
			log.error("", e);
			System.out.println(""+e.toString());
		}
		return null;
	}

}
