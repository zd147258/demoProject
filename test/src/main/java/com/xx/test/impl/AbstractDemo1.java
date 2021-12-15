package com.xx.test.impl;

public class AbstractDemo1 extends AbstractConsumer {
    @Override
    protected String callback(String str) {
        return str + "demo1";
    }

    @Override
    public String getBusinessTypeCode() {
        return "demo1";
    }

    @Override
    public String getLogPrefix() {
        return "demo1";
    }
}
