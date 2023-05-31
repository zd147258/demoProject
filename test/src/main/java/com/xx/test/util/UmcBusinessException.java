package com.xx.test.util;

public class UmcBusinessException extends RuntimeException {
    public static final ThreadLocal<UmcBusinessException> MQ_THREAD_EXCEPTION = new ThreadLocal();
    private static final long serialVersionUID = -1814155355569144196L;
    private String msgCode;
    private String[] args;

    public String getMsgCode() {
        return this.msgCode;
    }

    public String[] getArgs() {
        return this.args;
    }

    public String getMsgInfo() {
        return this.getMessage();
    }

    public UmcBusinessException(String msgId, String message) {
        super(message);
        this.msgCode = msgId;
        MQ_THREAD_EXCEPTION.set(this);
    }

    public UmcBusinessException(String msgId, String message, Throwable cause) {
        super(message, cause);
        this.args = new String[1];
        this.args[0] = message;
        this.msgCode = msgId;
        MQ_THREAD_EXCEPTION.set(this);
    }
}