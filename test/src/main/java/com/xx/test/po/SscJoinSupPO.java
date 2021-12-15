package com.xx.test.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 描述：供应商参与表
 * 
 * @author SuJingchun
 * @date 2021-09-01 20:48
 **/
@Data
public class SscJoinSupPO implements Serializable {
	private static final long serialVersionUID =  4942371492205276173L;

	/**
	 * 供应商参与ID
	 */
	private Long supJoinId;
	/**
	 * 供应商参与ID 批量查询
	 */
	private List<Long> supJoinIdListIn;
	/**
	 * 方案ID
	 */
	private Long schemeId;
	/**
	 * 包件ID
	 */
	private Long packId;
	/**
	 * 包件名称
	 */
	private String packName;
	/**
	 * 供应商编号
	 */
	private String supCode;
	/**
	 * 供应商名称
	 */
	private String supName;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 传真地址
	 */
	private String fax;
	/**
	 * 邮箱地址
	 */
	private String email;
	/**
	 * 联系人
	 */
	private String contractName;
	/**
	 * 参与说明
	 */
	private String joinExplain;
	/**
	 * 0：正常
            1：被淘汰
	 */
	private String joinStatus;
	/**
	 * 淘汰原因
	 */
	private String lostReason;
	/**
	 * 操作时间
	 */
	private Date operTime;
	private Date operTimeStart;
	private Date operTimeEnd;
	/**
	 * 备用1
	 */
	private String free1;
	/**
	 * 备用2
	 */
	private String free2;
	/**
	 * 备用3
	 */
	private String free3;
	/**
	 * 备用4
	 */
	private String free4;
	/**
	 * 备用5
	 */
	private String free5;
	/**
	 * 录入时间
	 */
	private Date createTime;
	private Date createTimeStart;
	private Date createTimeEnd;
	/**
	 * 1：删除
            0：正常
	 */
	private Integer deleteFlag;
	/**
	 * 是否海外供应商参与
	 */
	private String overseasFlag;
	/**
	 * 寻源环节
	 */
	private String purStep;
	/**
	 * 分组
	 */
	private String groupBy;
	/**
	 * 排序
	 */
	private String orderBy;

}
