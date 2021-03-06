package com.bawei.bwboot.common.exception.response;

import com.bawei.bwboot.common.enums.response.base.ResponseEnum;

/**
 * 业务操作异常
 * 配合 com.bawei.bwboot.common.enums.response 中的枚举使用
 * 一般在 service 中的 impl 中抛出
 *
 * @author Tommy
 */
public class ResponseException extends Exception {

    private ResponseEnum responseEnum;

    public ResponseEnum getResponseEnum() {
        return this.responseEnum;
    }

    public ResponseException(ResponseEnum responseEnum) {
        super(responseEnum.message());
        this.responseEnum = responseEnum;
    }

}
