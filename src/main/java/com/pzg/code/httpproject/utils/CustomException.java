package com.pzg.code.httpproject.utils;

/**
 * 自定义异常类，用于控制显示异常信息
 *
 * @ModifiedBy:
 */
public class CustomException extends Exception {

    public CustomException() {
        super();
    }

    public CustomException(String msg) {
        super(msg);
    }

}