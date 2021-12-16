package com.xx.test.base.page;

import com.xx.test.bo.RspBaseBO;

import java.util.List;

public class RspPage<T> extends RspBaseBO {
    private static final long serialVersionUID = -6183978037199049936L;
    private List<T> rows;
    private int recordsTotal;
    private int total;
    private int pageNo;

    public RspPage() {
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getRecordsTotal() {
        return this.recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public String toString() {
        return "RspPageBO [rows=" + this.rows + ", recordsTotal=" + this.recordsTotal + ", total=" + this.total + ", toString()=" + super.toString() + "]";
    }
}
