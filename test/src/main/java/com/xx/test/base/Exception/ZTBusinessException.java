package com.xx.test.base.Exception;

public class ZTBusinessException extends ExceptionStrategy {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String code;
    private String msg;
    private String detail;

    public ZTBusinessException() {
    }

    public ZTBusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public ZTBusinessException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ZTBusinessException(String code, String msg, String userId) {
        super(msg);
        this.userId = userId;
        this.code = code;
        this.msg = msg;
    }

    public ZTBusinessException(String code, String msg, String userId, String detail) {
        super(msg);
        this.userId = userId;
        this.code = code;
        this.msg = msg;
        this.detail = detail;
    }

    public String resolverExceptionCode() {
        return this.code;
    }

    public String resolverExceptionMsg() {
        return this.msg;
    }

    public String resolverExceptionUserId() {
        return this.userId;
    }
}