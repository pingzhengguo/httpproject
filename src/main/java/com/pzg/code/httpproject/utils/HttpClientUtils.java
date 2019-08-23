package com.pzg.code.httpproject.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 第三方接口
 */
public class HttpClientUtils {

    /**
     * Description :
     *
     * @param url         如：   http://api.91ganlu.com
     * @param methodPath  如：   /get/pressure
     * @param accessToken 如：   a9c8866a8b4b4e3480dcffc2cdcb39fb
     * @param requestBody 如：   {\"sn\":\"BB0201C0010C3107\",\"date\":\"2019-05-31\"}
     * @return : java.lang.String
     */
    public static String acquireData(String url, String methodPath, String accessToken, String requestBody) {
        String result = "";
        url = "" + url + methodPath;
        if ("".equals(url) || accessToken == null || "".equals(accessToken)
                || requestBody == null || "".equals(requestBody)) {
            return result;
        }
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.addHeader("accessToken", accessToken);
        post.setHeader("Content-Type", "application/json");
        CloseableHttpResponse httpResponse = null;
        try {
            post.setEntity(new StringEntity(requestBody));
            httpResponse = httpClient.execute(post);
            HttpEntity entity = httpResponse.getEntity();       //获取response的body部分
            result = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource(httpResponse, httpClient);
        }
        return result;
    }

    //释放资源
    private static void closeResource(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) {
        try {
            if (httpResponse != null) {
                httpResponse.close();
            }
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据的相关api的工具-查询设备联网状态
     */
    public static String acquireDataOnline(String url, String methodPath, String sn, String accessToken) {
        url = "" + url + methodPath + "/" + sn;
        String result = "";
        if ("".equals(url) || accessToken == null || "".equals(accessToken)) {
            return result;
        }
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        get.addHeader("accessToken", accessToken);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(get);
            HttpEntity entity = httpResponse.getEntity();       //获取response的body部分
            result = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource(httpResponse, httpClient);
        }
        return result;
    }


}
