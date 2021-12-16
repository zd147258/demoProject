package com.xx.test.base.page;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public class ReqPage implements Serializable {
    private static final long serialVersionUID = -7485827693286591127L;
    private int pageNo = 0;
    private int pageSize = 10;
    private String sortName;
    private String sortOrder;

    public ReqPage() {
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortName() {
        return this.sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

