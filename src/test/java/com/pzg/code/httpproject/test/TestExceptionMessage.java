package com.pzg.code.httpproject.test;

import com.pzg.code.httpproject.utils.HttpClientUtils;
import org.junit.Test;

public class TestExceptionMessage {
    /**
     * 异常消息推送-获取异常推送设置
     */
    @Test
    public void test1() {
        String requestBody = "{\"sn\":\"BB0201C0010C3107\"}";
        String result = HttpClientUtils.acquireData("http://api.91ganlu.com", "/get/device/config", "a9c8866a8b4b4e3480dcffc2cdcb39fb", requestBody);
        System.out.println("result:" + result);
    }

    /**
     * 异常消息推送-删除异常推送
     */
    @Test
    public void test2() {
        String requestBody = "{\"id\":12}";
        String result = HttpClientUtils.acquireData("http://api.91ganlu.com", "/delete/device/config", "a9c8866a8b4b4e3480dcffc2cdcb39fb", requestBody);
        System.out.println("result:" + result);
    }

    /**
     * 异常消息推送-新增异常推送
     */
    @Test
    public void test3() {
        String requestBody = "{\"sn\":\"BB0201C0010C3107\",\"config\":{\"breathlower\":10,\"breathupper\":50,\"endTime\":\"23-14\",\"heartlower\":20,\"heartupper\":200,\"leaveBed\":true,\"leaveBedTime\":1,\"move\":true,\"moveTime\":3,\"startTime\":\"10-12\"}}";
        String result = HttpClientUtils.acquireData("http://api.91ganlu.com", "/device/config", "a9c8866a8b4b4e3480dcffc2cdcb39fb", requestBody);
        System.out.println("result:" + result);
    }

    /**
     * 异常消息推送-更改异常推送设置
     */
    @Test
    public void test4() {
        String requestBody = "{\"id\":13,\"config\":{\"breathlower\":10,\"breathupper\":500,\"endTime\":\"23-14\",\"heartlower\":20,\"heartupper\":2000,\"leaveBed\":true,\"leaveBedTime\":1,\"move\":true,\"moveTime\":3,\"startTime\":\"10-12\"}}\n";
        String result = HttpClientUtils.acquireData("http://api.91ganlu.com", "/change/device/config", "a9c8866a8b4b4e3480dcffc2cdcb39fb", requestBody);
        System.out.println("result:" + result);
    }


}
