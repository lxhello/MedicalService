package com.medical.vo;

import lombok.Data;

/**
 * 响应
 * @author: lixiang
 * @date: 2022/5/5
 * @version: 1.0版本
 */
@Data
public class ResponseResult {
    private String code;
    private String message;
    private String data;

    public ResponseResult() {}

    public ResponseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
