package com.atguigu.cloud.resp;

import lombok.Data;

/**
 * @author Echo
 * @date 2024/3/18
 */
@Data
public class ResultData<T> {
    private String code;
    private String message;
    private T data;
    private long timestamp;

    //无参构造初始化时间戳
    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static ResultData success() {
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        return resultData;
    }

    public static <T> ResultData<T> success(T data) {
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(String code, String message) {
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }
}
