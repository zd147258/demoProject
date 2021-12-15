package com.xx.test.impl;

public abstract class AbstractConsumer {

    public void method1 (){
        System.out.println("businessTypeCode:" + getBusinessTypeCode());
        System.out.println("logPrefix:" + getBusinessTypeCode());
        System.out.println(callback("str"));
    }


    protected abstract String callback(String str);

    /**
     * 必设，设置审批业务编码。例：P01. ApprovalCommonConstants.ApprovalBillBussiness.PLAN
     *
     * @return
     */
    public abstract String getBusinessTypeCode();


    /**
     * 设置日志打印前缀
     *
     * @return
     */
    public abstract String getLogPrefix();
}
