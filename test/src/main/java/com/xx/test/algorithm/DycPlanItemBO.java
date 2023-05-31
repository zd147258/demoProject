package com.xx.test.algorithm;

import lombok.Data;

/**
 * 标题: DycPlanItemBO
 * 说明: 计划信息bo
 * 时间: 2022/12/19 11:48
 * @author 郑冬
 **/
@Data
public class DycPlanItemBO {
    /**
     * 计划编号
     */
    private String planNo;
    /**
     * 计划编号明细
     */
    private String planItemNo;
    /**
     * 计划编码明细
     */
    private String planItemCode;
    /**
     * 计划编码
     */
    private String planCode;
    /**
     * 可加入的最大数量
     */
    private String joinMaxAmount;
    /**
     * 计划行号
     */
    private String planLineNo;
    /**
     * 业主工厂编号
     * */
    private String factoryCode;

    /**
     * 业主工厂名称
     * */
    private String factoryName;
}
