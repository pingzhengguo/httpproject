package com.pzg.code.httpproject.test;

import com.pzg.code.httpproject.utils.HttpClientUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class TestAcquireData {


    /**
     * 获取数据-查询设备联网状态
     */
    @Test
    public void test4() {
        String result = HttpClientUtils.acquireDataOnline("http://api.91ganlu.com", "/get/isHardwareOnline", "BB0201C0010C3107", "a9c8866a8b4b4e3480dcffc2cdcb39fb");
        System.out.println("result:" + result);
    }

    /**
     * 获取数据-获取房颤统计
     */
    @Test
    public void test1() {
        String body = "{\"sn\":\"BB0201C0010C3107\",\"date\":\"2019-05-31\"}";
        String result = HttpClientUtils.acquireData("http://api.91ganlu.com", "/get/atriaTrembleReportByDay",
                "a9c8866a8b4b4e3480dcffc2cdcb39fb", body);
        System.out.println("result:" + result);
    }

    /**
     * 获取数据-获取呼吸统计
     */
    @Test
    public void test2() {
        String body = "{\"sn\":\"BB0201C0010C3107\",\"date\":\"2019-05-31\"}";
        String result = HttpClientUtils.acquireData("http://api.91ganlu.com", "/get/breathReportByDay",
                "a9c8866a8b4b4e3480dcffc2cdcb39fb", body);
        System.out.println("result:" + result);
    }

    /**
     * 获取数据-获取心率统计
     */
    @Test
    public void test3() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://api.91ganlu.com/get/heartReportByDay");

        post.addHeader("accessToken", "a9c8866a8b4b4e3480dcffc2cdcb39fb");
        post.setHeader("Content-Type", "application/json");
        String body = "{\"sn\":\"BB0201C0010C3107\",\"date\":\"2019-05-31\"}";
        try {
            post.setEntity(new StringEntity(body));
            HttpResponse httpResponse = httpClient.execute(post);
            HttpEntity entity = httpResponse.getEntity();       //获取response的body部分
            String result = EntityUtils.toString(entity);
            System.out.println("result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据-获取离床统计
     */
    @Test
    public void test5() {
        String body = "{\"sn\":\"BB0201C0010C3107\",\"date\":\"2019-05-31\"}";
        String result = HttpClientUtils.acquireData("http://api.91ganlu.com", "/get/leaveBedReportByDay",
                "a9c8866a8b4b4e3480dcffc2cdcb39fb", body);
        System.out.println("result:" + result);
    }

    /**
     * 获取数据-获取压力值
     */
    @Test
    public void test6() {
        String body = "{\"sn\":\"BB0201C0010C3107\",\"date\":\"2019-05-31\"}";
        String result = HttpClientUtils.acquireData("http://api.91ganlu.com", "/get/pressure",
                "a9c8866a8b4b4e3480dcffc2cdcb39fb", body);
        System.out.println("result:" + result);
    }

    /**
     * 获取数据-获取睡眠报告
     */
    @Test
    public void test7() {
        String body = "{\"sn\":\"BB0201C0010C3107\",\"date\":\"2019-05-31\"}";
        String result = HttpClientUtils.acquireData("http://api.91ganlu.com", "/get/sleepReport",
                "a9c8866a8b4b4e3480dcffc2cdcb39fb", body);
        System.out.println("result:" + result);
    }


}
