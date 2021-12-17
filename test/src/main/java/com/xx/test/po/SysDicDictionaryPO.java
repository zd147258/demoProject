package com.xx.test.po;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class SysDicDictionaryPO implements Serializable {
	private static final long serialVersionUID =  -2220135852477590901L;

	private String code;
	private String pCode;
	/**
	 * 系统编码
	 */
	private String sysCode;
	private String title;
	/**
	 * 同级排序
	 */
	private Integer orderId;
	private String descrip;
	private Long createUid;
	private Date createTm;
	private Long updateUid;
	private Date updateTm;
	/**
	 * 删除标示 0 删除，1 有效
	 */
	private Integer delFlag;
	private String orderBy;
}
