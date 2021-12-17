package com.xx.test.base.Exception;

public abstract class ExceptionStrategy extends RuntimeException {
    private static final long serialVersionUID = 833370795496148705L;

    public ExceptionStrategy(String msg) {
        super(msg);
    }

    public ExceptionStrategy() {
    }

    public abstract String resolverExceptionUserId();

    public abstract String resolverExceptionCode();

    public abstract String resolverExceptionMsg();
}