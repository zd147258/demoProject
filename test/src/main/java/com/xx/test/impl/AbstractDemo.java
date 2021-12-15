package com.xx.test.impl;

public class AbstractDemo extends AbstractConsumer {
    @Override
    protected String callback(String str) {
        return  str + "demo";
    }

    @Override
    public String getBusinessTypeCode() {
        return "demo";
    }

    @Override
    public String getLogPrefix() {
        return "demo";
    }
}
