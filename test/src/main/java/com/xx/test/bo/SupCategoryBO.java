package com.xx.test.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 标题: SupCategoryBO
 * 说明: //TODO
 * 时间: 2022/2/16 10:54
 *
 * @author 郑冬
 **/
@Data
public class SupCategoryBO implements Serializable {
    private static final long serialVersionUID = -3039327065899567495L;
    /**
     * 供应商id
     */
    private Long supplierId;
    /**
     * 供应商名称
     */
    private String supplierName;
    /**
     * 供应商编码
     */
    private String supplierCode;
    /**
     * 品类id
     */
    private Long itemCategoryId;
    /**
     * 品类名称
     */
    private String itemCategoryName;
    /**
     * 保函失效日期
     */
    private Date expirationDate;
}
