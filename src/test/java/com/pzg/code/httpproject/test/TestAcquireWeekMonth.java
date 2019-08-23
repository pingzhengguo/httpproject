package com.pzg.code.httpproject.test;

import com.pzg.code.httpproject.utils.HttpClientUtils;
import org.junit.Test;

public class TestAcquireWeekMonth {
    /**
     * 获取数据-获取月睡眠报告
     */
    @Test
    public void test1() {
        String body = "{\"sn\":\"BB0201C0010C3107\",\"date\":\"2019-05-31\"}";
        String result = HttpClientUtils.acquireData("http://api.91ganlu.com", "/get/report/month",
                "a9c8866a8b4b4e3480dcffc2cdcb39fb", body);
        System.out.println("result:" + result);
    }

    /**
     * 获取数据-获取周睡眠报告
     */
    @Test
    public void test2() {
        String body = "{\"sn\":\"BB0201C0010C3107\",\"date\":\"2019-05-31\"}";
        String result = HttpClientUtils.acquireData("http://api.91ganlu.com", "/get/report/week",
                "a9c8866a8b4b4e3480dcffc2cdcb39fb", body);
        System.out.println("result:" + result);
    }


}
