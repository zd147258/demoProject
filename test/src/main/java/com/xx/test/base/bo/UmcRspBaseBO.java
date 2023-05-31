package com.xx.test.base.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 描述：会员中心出参基类   
 * @author: yuhao 
 * @date:   2018年8月13日 下午4:01:09   
 *     
*/
@Data
public class UmcRspBaseBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1321081984905426605L;

	/**
	 * 返回编码
	 */
	private String respCode;
	/**
	 * 返回描述
	 */
	private String respDesc;
}
