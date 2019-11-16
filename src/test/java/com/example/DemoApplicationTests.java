package com.example;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class DemoApplicationTests {

	@Test
	public void test1() {
		String url ="http://127.0.0.1:8081/api/getAll";
		String response =httpPost(url,new JSONObject());
		System.out.println(response);

	}

	@Test
	public void test2() {
		String url ="http://127.0.0.1:8081/api/readConfig";
		String response =httpPost(url,new JSONObject());
		System.out.println(response);

	}


	/**http请求**/
	public String httpPost(String url, JSONObject jsonParam) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
		httpPost.setConfig(requestConfig);
		String jsonStr="";
		try {
			if (null != jsonParam) {
				// 解决中文乱码问题
				jsonStr = jsonParam.toJSONString();
				StringEntity entity = new StringEntity(jsonStr, "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				httpPost.setEntity(entity);//存入body

			}
			CloseableHttpResponse result = httpClient.execute(httpPost);
			System.out.println("STATUS:"+result.getStatusLine().getStatusCode());
			//请求发送成功，并得到响应
			if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String str = "";
				try {
					//读取服务器返回过来的json字符串数据
					str = EntityUtils.toString(result.getEntity(), "utf-8");
					return str;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpPost.releaseConnection();
		}
		return null;
	}

}
