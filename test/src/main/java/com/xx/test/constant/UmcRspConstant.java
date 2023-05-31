package com.xx.test.constant;


/**
 * 描述：会员中心返回编码常量类
 *
 * @author: yuhao
 * @date: 2018年8月13日 下午4:09:03
 */
public class UmcRspConstant {

	/*编码生成规则：
	调用成功的编码无需再自行定义，统一使用：RESP_CODE_SUCCESS
	每个接口调用失败的编码需自行定义，规则如下：
	编码key：以RESP_CODE开头，以ERROR结束，中间为自定义部分，
	自定义原则为具有可读性的英文单词（可简写），多个单词以“_”分隔，如：RESP_CODE_DEAL_ORDER_ERROR。
	编码值：原子层以1开头，如：1001；业务层以2开头，如：2001；组合层以3开头，如：3001，ability层以4开头，如：4001；编码值长度为4位*/
    /**
     * 成功编码
     */
    public static final String RESP_CODE_SUCCESS = "0000";
    /**
     * 成功描述
     */
    public static final String RESP_DESC_SUCCESS = "成功";

    /**
     * 失败编码
     */
    public static final String RESP_CODE_ERROR = "8888";
    /**
     * 失败描述
     */
    public static final String RESP_DESC_ERROR = "失败";
    /**
     * 商品导入失败编码
     */
    public static final String RESP_CODE_ERROR_UPLOAD = "181777";

    /**
     * 会员中心基础信息维护原子服务错误编码
     */
    public static final String RESP_CODE_MENM_INFO_UPDATE_ATOM_ERROR = "1001";
    /**
     * 会员中心基础信息维护原子服务错误编码
     */
    public static final String RESP_CODE_MULTI_COND_QUERY_MEM_ATOM_ERROR = "164002";
    /**
     * 会员中心判断是否是连续和重复签到原子服务实现
     */
    public static final String JUDGE_CONTINUE_REPEAT_SIGN_ERROR = "1003";


    /**
     * 会员中心新增积分操作日志记录原子服务错误编码
     */
    public static final String ADD_INTEGRAL_LOG_ERROR = "1004";
    /**
     * 会员中心积分抵扣原子服务错误编码
     */
    public static final String INTEGRAL_DEDUCT_ATOM_ERROR = "1005";
    /**
     * 会员中心业务控制数量更新原子服务错误编码
     */
    public static final String UPDATE_OPER_CONTROL_ATOM_ERROR = "1006";
    /**
     * 会员中心成长值增加原子服务错误编码
     */
    public static final String GROW_VALUE_ADD_ATOM_ERROR = "1007";
    /**
     * 会员中心成长值扣减原子服务错误编码
     */
    public static final String GROW_VALUE_DEDUCT_ATOM_ERROR = "1008";
    /**
     * 会员中心成长值扣减原子服务--更新成长值错误编码
     */
    public static final String GROW_VALUE_DEDUCT_ATOM_UPDATE_GROW_VALUE_ERROR = "1017";
    /**
     * 会员中心成长值扣减原子服务--插入成长值日志记录错误编码
     */
    public static final String GROW_VALUE_DEDUCT_ATOM_ADD_CHG_REC_VALUE_ERROR = "1018";


    /**
     * 会员中心规则计算原子服务错误编码——未查询到规则定义信息
     */
    public static final String RESP_CODE_NOT_FIND_RULE_DEFINE_ATOM_ERROR = "164009";

    /**
     * 会员中心规则计算原子服务错误编码——非法的计算方式类型
     */
    public static final String RESP_CODE_NOT_METHOD_MODE_ATOM_ERROR = "164010";

    /**
     * 会员中心规则计算原子服务错误编码——未配置默认值
     */
    public static final String RESP_CODE_NOT_CONFIGURATION_DEFAULT_VALUE_ATOM_ERROR = "164011";

    /**
     * 会员中心业务积分及成长值计算原子服务错误编码——未查询到业务编码所对应的规则信息
     */
    public static final String RESP_CODE_NOT_FIND_OPER_RULE_ATOM_ERROR = "164012";

    /**
     * 会员中心会员优惠券创建原子服务错误编码
     */
    public static final String RESP_CODE_CREATE_COUPON_ATOM_ERROR = "1013";

    /**
     * 会员中心优惠卷使用情况记录原子服务错误编码——记录插入失败
     */
    public static final String RESP_CODE_CREATE_COUPON_RECORD_ATOM_ERROR = "164014";

    /**
     * 会员中心校验会员是否合法错误编码
     */
    public static final String RESP_CODE_VERIFY_MEMBER_ATOM_ERROR = "164016";

    /**
     * 会员中心业务定义表操作原子服务错误编码
     */
    public static final String RESP_CODE_OPER_DEFINE_ATOM_ERROR = "1019";

    /**
     * 会员中心业务规则表操作原子服务错误编码
     */
    public static final String RESP_CODE_OPER_RULE_ATOM_ERROR = "1020";

    /**
     * 会员中心规则表操作原子服务错误编码
     */
    public static final String RESP_CODE_RULE_DEFINE_ATOM_ERROR = "164021";

    public static final String RESP_CODE_RULE_DEFINE_IS_INVALID = "164022";

    //规则计算策略类原子服务错误编码设定
    /**
     * 评价赠送积分策略服务——未配置目标值
     */
    public static final String RESP_CODE_EVALUATE_GIVE_INTEGRAL_NOT_CONFIG_TARGET_ERROR = "1901";

    /**
     * 评价赠送积分策略服务——目标值格式配置错误
     */
    public static final String RESP_CODE_EVALUATE_GIVE_INTEGRAL_TARGET_VALUE_FORMAT_ERROR = "1902";

    /**
     * 评价/回答/分享成长值计算策略服务错误编码
     */
    public static final String RESP_CODE_SHAORELTORANS_GROW_VALUE_ERROR = "1907";
    /**
     * 成长值积分兑换计算策略服务错误编码
     */
    public static final String RESP_CODE_EXCHANGE_INTEGRAL_AND_GROW_VALUE_ERROR = "1908";

    /**
     * 参数校验失败
     */
    public static final String RESP_CODE_PARAM_VERIFY_ERROR = "161000";
    public static final String RESP_CODE_PARAM_VERIFY_BUSI_ERROR = "163001";

    /**
     * 登陆用户名密码错误
     */
    public static final String RESP_CODE_LOGIN_ERROR = "161001";

    /**
     * 登陆用户状态异常
     */
    public static final String RESP_CODE_USER_STATUS_ERROR = "161002";

    /**
     * 会员中心发送随机码业务服务错误编码
     */
    public static final String SEND_VF_CODER_ERROR = "163001";

    /**
     * 会员中心随机码校验业务服务错误编码
     */
    public static final String VERIFY_VF_CODER_ERROR = "163002";

    /**
     * 会员中心会员新增商品收藏业务服务错误编码
     */
    public static final String ADD_COLLECTION_GOODS_ERROR = "163003";

    /**
     * 会员中心会员签到送积分业务服务错误编码
     */
    public static final String SING_OBTAIN_INTEGRAL_ERROR = "163004";

    /**
     * 会员中心二维码解析和查询会员信息业务服务错误编码
     */
    public static final String PARSE_QR_AND_QRY_MEM_ERROR = "163005";

    /**
     * 会员中心二维码解析和查询会员信息业务服务错误编码
     */
    public static final String INTEGRAL_DEDUCT_RETURN_SALE_ERROR = "163006";

    /**
     * 会员中心会员新增积分业务服务错误编码
     */
    public static final String ADD_INTEGRAL_ERROR = "163007";

    /**
     * 会员中心会员评级业务服务——未查询到会员信息
     */
    public static final String RESP_CODE_NOT_FIND_MEMBER_INFO_ERROR = "163008";

    /**
     * 会员中心会员评级业务服务——未查询到业务编码所对应的规则信息
     */
    public static final String RESP_CODE_NOT_FIND_OPER_RULE_BUSI_ERROR = "163009";

    /**
     * 会员中心会员评级业务服务——更新会员新等级、新生、失效时间失败编码
     */
    public static final String RESP_CODE_UPDATE_MEMBER_INFO_BUSI_ERROR = "163010";

    /**
     * 收货信息相关服务执行失败
     */
    /**
     * 设置默认服务执行失败
     */
    public static final String RESP_CODE_SET_DEFAULT_LOGISTICS_RELA_ERROR = "2011";
    /**
     * 查询服务执行失败
     */
    public static final String RESP_CODE_QUERY_LOGISTICS_RELA_ERROR = "2012";

    /**
     * 会员中心业务增加成长值业务服务——获取到的成长值为空
     */
    public static final String RESP_CODE_GROW_VALUE_IS_NULL_ERROR = "163013";

    /**
     * 会员中心积分抵扣计算业务服务——获取到的可抵扣积分为空
     */
    public static final String RESP_CODE_DEDUCTION_INTEGRAL_IS_NULL_ERROR = "2014";

    /**
     * 会员中心积分抵扣计算业务服务——获取到的抵扣金额为空
     */
    public static final String RESP_CODE_DEDUCTION_MONEY_IS_NULL_ERROR = "2015";

    /**
     * 会员中心积分抵扣计算业务服务——未查询到业务编码与规则对应信息
     */
    public static final String RESP_CODE_NOT_FIND_OPER_RULE_ERROR = "2016";

    /**
     * 会员中心会员签到送积分业务服务——控制信息条数大于一
     */
    public static final String SIGN_GIVE_INTEGRAL_CONTROL_INFO_SIZE_GL_ONE_ERROR = "2017";

    /**
     * 会员中心会员签到送积分业务服务——赠送积分以达到上限制
     */
    public static final String GIVE_INTEGRAL_REACH_CEILING_VALUE_ERROR = "2018";

    /**
     * 会员中心会员评级业务服务——插入会员新等级、新生、失效时间日志记录失败
     */
    public static final String RESP_CODE_RECORD_MEMBER_LONG_BUSI_ERROR = "163019";

    /**
     * 会员中心优惠卷抵扣业务服务错误编码
     */
    public static final String RESP_CODE_COUPON_DEDUCTION_BUSI_ERROR = "163020";

    /**
     * 会员中心会员注销业务服务错误编码
     */
    public static final String CANCELLATION_MEM_BUSI_ERROR = "2021";

    /**
     * 发票抬头信息相关服务执行失败
     */
    /**
     * 设置默认服务执行失败
     */
    public static final String RESP_CODE_SET_DEFAULT_INVOICE_TITLE_INFO_ERROR = "2021";
    /**
     * 查询服务执行失败
     */
    public static final String RESP_CODE_QUERY_INVOICE_TITLE_INFO_ERROR = "2022";

    /**
     * 会员中优惠卷返销错误编码
     */
    public static final String RESP_CODE_COUPON_DED_BUY_BACK_BUSI_ERROR = "2023";

    /**
     * 会员中心商品浏览记录保存错误编码
     */
    public static final String RESP_CODE_GOODS_BROWSE_REC_BUSI_ERROR = "163998";

    /**
     * 会员中心会员评级定时任务-扣减默认成长值任务错误编码
     */
    public static final String RESP_CODE_TIMING_TASK_MEM_RATING_BUSI_ERROR = "2025";

    /**
     * 会员中心删除优惠卷失败编码
     */
    public static final String RESP_CODE_DELETE_COUPON_BUSI_ERROR = "163999";

    /**
     * 会员标签相关服务执行失败
     */
    /**
     * 查询服务执行失败
     */
    public static final String RESP_CODE_QUERY_MEM_LABEL_INFO_ERROR = "2031";

    /**
     * 站内信相关服务执行失败
     */
    /**
     * 站内信发送业务服务失败
     */
    public static final String RESP_CODE_SYS_MAIL_SEND_ERROR = "163041";
    /**
     * 站内信阅读服务失败
     */
    public static final String RESP_CODE_MAIL_READ_ERROR = "163042";
    /**
     * 站内信删除服务失败
     */
    public static final String RESP_CODE_MAIL_DELETE_ERROR = "163043";
    /**
     * 我的站内信查询服务失败
     */
    public static final String RESP_CODE_MY_MAIL_LIST_QUERY_ERROR = "163044";

    /**
     * 二维码服务失败编码
     */
    /**
     * 加密失败
     */
    public static final String RESP_CODE_QR_CREATE_ENCRYPT_ERROR = "163997";
    /**
     * 插入数据库失败
     */
    public static final String RESP_CODE_QR_CREATE_INSERT_ERROR = "163996";

    /**
     * 机构相关业务服务失败
     */
    public static final String RESP_CODE_ORG_ERROR = "2053";
    /**
     * 会员用户相关业务服务失败
     */
    public static final String RESP_CODE_MEM_USER_ERROR = "163054";
    /**
     * 会员企业相关业务服务失败
     */
    public static final String RESP_CODE_ENTERPRISE_ERROR = "2055";

    /**
     * 登录时验证码校验失败
     */
    public static final String RESP_CODE_LOGIN_VF_CODE_CHECK_ERROR = "3001";
    /**
     * 登录时查询会员信息失败
     */
    public static final String RESP_CODE_LOGIN_QUERY_MEM_INFO_ERROR = "3002";
    /**
     * 登录时黑名单会员
     */
    public static final String RESP_CODE_LOGIN_IS_BLACK_LIST_ERROR = "3003";
    /**
     * 登录时密码校验失败
     */
    public static final String RESP_CODE_LOGIN_PASSWD_ERROR = "3004";

    /**
     * 机构相关组合服务失败
     */
    public static final String RESP_CODE_ORG_COMB_ERROR = "162005";
    /**
     * 代客下单未查询到用户
     */
    public static final String RESP_CODE_PROXY_NONE_MEMBER = "163101";
    /**
     * 修改密码失败
     */
    public static final String RESP_CODE_MODIFY_MEMBER_PASSWORD = "163003";

    /**
     * 返回中心编码
     */
    public static final String RESP_CENTER_CODE = "16";
    public static final String RESP_INFORMATION_ERROR = "0100";
    public static final String RESP_INFORMATION_NOTNULL = "0001";
    public static final String RESP_INFORMATION_NOTSTANDARD = "0002";


	/*异常编码生成规则：
	每个接口业务异常的编码需自行定义，规则如下：
	编码key：，以EXCEPTION结束，前段为自定义部分，
	自定义原则为具有可读性的英文单词（可简写），多个单词以“_”分隔，如：QUERY_ORDER_DETAIL_EXCEPTION。
	编码值：原子层以5开头，如：5001；业务层以6开头，如：6001；组合层以7开头，如：7001，ability层以开头，如：8001；编码值长度为4位*/

    /**
     * 会员中心注册原子服务手机号码已经被注册异常
     */
    public static final String REGIST_MOBILE_ALREADY_EXIST = "5001";
    /**
     * 会员中心注册原子服务账号已经被注册
     */
    public static final String REGIST_ACCOUNT_ALREADY_EXIST = "5002";
    /**
     * 会员中心注册原子服务第三方账号已经被注册
     */
    public static final String REGIST_THIRD_AUTH_ALREADY_EXIST = "5003";
    /**
     * 会员中心注册原子服务FaceID已经被注册
     */
    public static final String REGIST_FACE_ID_ALREADY_EXIST = "5004";
    /**
     * 会员中心注册原子服务获取会员ID异常
     */
    public static final String REGIST_GET_MEN_ID_SEQUENCE_EXCEPTION = "5005";

    /**
     * 会员中心人脸信息修改业务服务异常
     */
    public static final String FACE_INFO_UPDATE_BUSI_EXCEPTION = "6001";
    /**
     * 会员中心人脸信息删除业务服务异常
     */
    public static final String FACE_INFO_DELETE_BUSI_EXCEPTION = "6002";
    /**
     * 会员中心人脸信息新增业务服务异常
     */
    public static final String FACE_INFO_ADD_BUSI_EXCEPTION = "163003";
    /**
     * 会员中心基础信息维护业务服务异常
     */
    public static final String MEM_INFO_UPDATE_BUSI_EXCEPTION = "163004";
    /**
     * 会员中心三方鉴权信息新增业务服务异常
     */
    public static final String THIRD_BIND_INFO_ADD_BUSI_EXCEPTION = "6005";
    /**
     * 会员中心三方鉴权信息删除业务服务异常
     */
    public static final String THIRD_BIND_INFO_UPDATE_BUSI_EXCEPTION = "6006";
    /**
     * 会员中心多条件查询会员业务服务异常
     */
    public static final String MULTI_COND_QUERY_MENM_BUSI_EXCEPTION = "6007";
    /**
     * 会员中心会员详情查询业务服务异常
     */
    public static final String MEM_DETAIL_QUERY_BUSI_EXCEPTION = "163008";
    /**
     * 会员中心会员注册验证码校验失败异常
     */
    public static final String REGIST_CHECK_VF_CODE_EXCEPTION = "6009";
    /**
     * 会员中心积分抵扣返销业务服务异常
     */
    public static final String INTEGRAL_DEDUCT_RETURN_SALE_CODE_EXCEPTION = "6010";
    /**
     * 会员中心成长值兑换积分业务服务异常
     */
    public static final String GROW_EXCHANGE_INTEGRAL_CODE_EXCEPTION = "6011";
    /**
     * 会员中心会员优惠券状态更新业务服务异常
     */
    public static final String UPDATE_COUPON_STATE_CODE_EXCEPTION = "6012";
    /**
     * 会员中心成长值获取返销业务服务业务服务异常
     */
    public static final String RETURN_SALE_GROW_VALUE_CODE_EXCEPTION = "6013";

    /**
     * 会员中心积分状态改变业务服务实现类异常
     */
    public static final String CHANGE_INTEGRAL_STATE_CODE_EXCEPTION = "163014";

    /**
     * 会员中心会员店铺收藏/取消业务服务异常
     */
    public static final String OPER_SHOP_CODE_EXCEPTION = "6015";
    /**
     * 会员中心购物年限增加成长值业务服务异常
     */
    public static final String ADDGV_PURYEAR_CODE_EXCEPTION = "6016";
    /**
     * 会员中心积分成长值规则操作业务服务异常
     */
    public static final String INTEGRAL_OR_GROW_VALUE_RULE_CODE_EXCEPTION = "163017";
    /**
     * 会员中心会员批量操作业务服务异常
     */
    public static final String OPER_MEM_CODE_EXCEPTION = "6018";
    /**
     * 会员中心成长值增减业务服务异常
     */
    public static final String GROW_VALUE_ADD_OR_CUT_EXCEPTION = "163019";
    /**
     * 会员中心人脸信息维护Ability服务异常
     */
    public static final String FACE_INFO_OPER_ABILITY_EXCEPTION = "161001";
    /**
     * 会员中心基础信息维护Ability服务异常
     */
    public static final String MEM_INFO_OPER_ABILITY_EXCEPTION = "161002";
    /**
     * 三方鉴权绑定服务Ability服务异常
     */
    public static final String THIRD_AUTH_INFO_BIND_ABILITY_EXCEPTION = "161003";
    /**
     * 三方鉴权解绑服务Ability服务异常
     */
    public static final String THIRD_AUTH_INFO_UNBIND_ABILITY_EXCEPTION = "161004";
    /**
     * 会员详情查询Ability服务异常
     */
    public static final String MEM_DETAIL_QUERY_ABILITY_EXCEPTION = "161005";
    /**
     * 会员中心多条件查询会员信息Ability服务异常
     */
    public static final String MULTI_COND_QUERY_MEM_ABILITY_EXCEPTION = "161006";

    /**
     * 参数校验失败
     */
    public static final String PARAM_VERIFY_EXCEPTION = "163000";

    /**
     * 收货信息相关服务执行异常
     */
    /**
     * 新增异常
     */
    public static final String ADD_LOGISTICS_RELA_EXCEPTION = "163011";
    /**
     * 修改异常
     */
    public static final String UPDATE_LOGISTICS_RELA_EXCEPTION = "163012";
    /**
     * 删除异常
     */
    public static final String DELETE_LOGISTICS_RELA_EXCEPTION = "163013";

    /**
     * 发票抬头信息相关服务执行异常
     */
    /**
     * 新增异常
     */
    public static final String ADD_INVOICE_TITLE_INFO_EXCEPTION = "163021";
    /**
     * 修改异常
     */
    public static final String UPDATE_INVOICE_TITLE_INFO_EXCEPTION = "163022";
    /**
     * 删除异常
     */
    public static final String DELETE_INVOICE_TITLE_INFO_EXCEPTION = "163023";

    /**
     * 企业账套信息相关服务执行异常
     */
    /**
     * 新增异常
     */
    public static final String BUSI_ADD_ENTERPRISE_ACCOUNT_INFO_EXCEPTION = "163024";
    /**
     * 修改异常
     */
    public static final String BUSI_UPDATE_ENTERPRISE_ACCOUNT_INFO_EXCEPTION = "163025";
    /**
     * 审批结果处理异常
     */
    public static final String APPROVAL_RESULT_ENTERPRISE_ACCOUNT_EXCEPTION = "163026";
    /**
     * 查询异常
     */
    public static final String BUSI_QRY_ENTERPRISE_ACCOUNT_INFO_EXCEPTION = "163026";

    /**
     * 企业账套发票信息相关服务执行异常
     */
    /**
     * 新增异常
     */
    public static final String ADD_ACCOUNT_INVOICE_INFO_EXCEPTION = "163027";
    /**
     * 修改异常
     */
    public static final String UPDATE_ACCOUNT_INVOICE_INFO_EXCEPTION = "163028";


    /**
     * 企业账套发票地址信息相关服务执行异常
     */
    /**
     * 新增异常
     */
    public static final String ADD_INVOICE_ADDRESS_INFO_EXCEPTION = "163029";
    /**
     * 修改异常
     */
    public static final String UPDATE_INVOICE_ADDRESS_INFO_EXCEPTION = "163030";


    /**
     * 企业账套审核相关服务执行异常
     */
    /**
     * 审核异常
     */
    public static final String BUSI_UPDATE_ACCOUNT_APPROVAL_EXCEPTION = "163031";

    /**
     * 会员密码更新执行异常
     */
    /**
     * 审核异常
     */
    public static final String UPDATE_MEMBER_PWD_EXCEPTION = "6032";

    /**
     * 字典异常
     */
    /**
     * 字典异常
     */
    public static final String DIC_EXCEPTION = "163033";
    /**
     * 附件删除异常
     */
    /**
     * 附件删除异常
     */
    public static final String BUSI_ACCESSORY_DEL_EXCEPTION = "163034";
    public static final String BUSI_ACCESSORY_QRY_EXCEPTION = "163035";
    public static final String BUSI_ACCESSORY_INSERT_EXCEPTION = "163036";
    /**
     * 调岗异常
     */
    public static final String MEM_CHANGE_POZITION_EXCEPTION = "6037";


    /**
     * 用户下载记录新增原子服务异常
     */
    public static final String USER_DOWNLOAD_RECORD_ADD_BUSI_EXCEPTION = "6501";
    /**
     * 用户下载记录分页获取原子服务异常
     */
    public static final String USER_DOWNLOAD_RECORD_LIST_PAGE_BUSI_EXCEPTION = "6502";


    /**
     * 用户下载记录新增原子服务异常
     */
    public static final String USER_DOWNLOAD_RECORD_ADD_ABILITY_EXCEPTION = "8501";
    /**
     * 用户下载记录分页获取原子服务异常
     */
    public static final String USER_DOWNLOAD_RECORD_LIST_PAGE_ABILITY_EXCEPTION = "8502";


    /**
     * 发放名目新增异常
     */
    public static final String ADD_GRANT_TYPE_EXCEPTION = "6034";
    /**
     * 发放名目更新异常
     */
    public static final String UPDATE_GRANT_TYPE_EXCEPTION = "6035";
    /**
     * 银行转账凭证新增异常
     */
    public static final String ADD_BANK_TRANSFER_VOUCHER_EXCEPTION = "6036";
    /**
     * 银行转账凭证更新异常
     */
    public static final String UPDATE_BANK_TRANSFER_VOUCHER_EXCEPTION = "6037";
    /**
     * 保证金新增异常
     */
    public static final String ADD_SUPPLIER_DEPOSIT_EXCEPTION = "163038";
    /**
     * 保证金更新异常
     */
    public static final String UPDATE_SUPPLIER_DEPOSIT_EXCEPTION = "163039";
    /**
     * 产销会员码新增异常
     */
    public static final String ADD_SUPPLIER_PRODUCTION_MARKET_EXCEPTION = "163040";
    /**
     * 产销会员码更新异常
     */
    public static final String UPDATE_SUPPLIER_PRODUCTION_MARKET_EXCEPTION = "163041";
    /**
     * 委托方入驻信息新增异常
     */
    public static final String ADD_ENTRUST_PARTY_EXCEPTION = "163042";

    /**
     * 不良记录通知书模板新增异常
     */
    public static final String SUP_MIS_NOTICE_TEMPLATE_CREATE_ATOM_EXCEPTION = "163503";
    public static final String SUP_MIS_NOTICE_TEMPLATE_CREATE_BUSI_EXCEPTION = "6503";
    public static final String SUP_MIS_NOTICE_TEMPLATE_CREATE_ABILITY_EXCEPTION = "161503";

    /**
     * 不良记录通知书模板修改异常
     */
    public static final String SUP_MIS_NOTICE_TEMPLATE_UPDATE_ATOM_EXCEPTION = "163504";
    public static final String SUP_MIS_NOTICE_TEMPLATE_UPDATE_BUSI_EXCEPTION = "6504";
    public static final String SUP_MIS_NOTICE_TEMPLATE_UPDATE_ABILITY_EXCEPTION = "161504";

    /**
     * 不良记录通知书模板列表异常
     */
    public static final String QRY_MISNOTICE_TEMPLATE_LIST_ATOM_EXCEPTION = "5505";
    public static final String QRY_MISNOTICE_TEMPLATE_LIST_BUSI_EXCEPTION = "6505";
    public static final String QRY_MISNOTICE_TEMPLATE_LIST_ABILITY_EXCEPTION = "8505";

    /**
     * 不良记录通知书模板详情异常
     */
    public static final String QRY_MISNOTICE_TEMPLATE_DETAIL_ATOM_EXCEPTION = "163506";
    public static final String QRY_MISNOTICE_TEMPLATE_DETAIL_BUSI_EXCEPTION = "6506";
    public static final String QRY_MISNOTICE_TEMPLATE_DETAIL_ABILITY_EXCEPTION = "161506";

    /**
     * 不良记录通知书详情异常
     */
    public static final String QRY_MISNOTICE_DETAIL_ATOM_EXCEPTION = "163507";
    public static final String QRY_MISNOTICE_DETAIL_BUSI_EXCEPTION = "6507";
    public static final String QRY_MISNOTICE_DETAIL_ABILITY_EXCEPTION = "8507";

    /**
     * 用户下载记录新增原子服务异常
     */
    public static final String USER_DOWNLOAD_RECORD_ADD_ATOM_EXCEPTION = "5501";
    /**
     * 用户下载记录删除原子服务异常
     */
    public static final String USER_DOWNLOAD_RECORD_DELETE_ATOM_EXCEPTION = "5503";


    /**
     * 入参为空
     */
    public static final String RESP_PARAM_EMPTY = "0001";

    /**
     * 通知中心发送短信成功编码
     */
    public static final String code = "0";

    /**
     * 法大大成功编码
     */
    public static final String FDD_CODE_SUCCESS = "1";

    /**
     * e签宝成功编码
     */
    public static final String EQB_CODE_SUCCESS = "0";

    /**
     * 客服服务异常
     */
    /**
     * 新增异常
     */
    public static final String ADD_CUST_SERVICE_EXCEPTION = "163995";
    /**
     * 修改异常
     */
    public static final String UPDATE_CUST_SERVICE_EXCEPTION = "163994";
    /**
     * 查询异常
     */
    public static final String QRY_CUST_SERVICE_EXCEPTION = "5603";
    /**
     * 入参校验异常
     */
    public static final String VALIDATA_CUST_SERVICE_EXCEPTION = "5604";
    /**
     * 坐席保存异常
     */
    public static final String SAVE_CSID_EXCEPTION = "163605";
    /**
     * 客服用户导入异常
     */
    public static final String ABILITY_USERS_ADD_CUST_SERVICE_EXCEPTION = "161606";
    /**
     * 客服用户导入异常
     */
    public static final String USERS_ADD_CUST_SERVICE_EXCEPTION = "163606";
    /**
     * 客服用户导入异常
     */
    public static final String ATOM_USERS_ADD_CUST_SERVICE_EXCEPTION = "164606";
    /**
     * 客服租户新增异常
     */
    public static final String TENANT_ADD_CUST_SERVICE_EXCEPTION = "5607";
    /**
     * 客服租户更新异常
     */
    public static final String TENANT_UPDATE_CUST_SERVICE_EXCEPTION = "5608";
    /**
     * 技能组查询异常
     */
    public static final String SKILL_GROUP_QRY_EXCEPTION = "5609";
    public static final String USERS_ADD_CSID_EXCEPTION = "163606";











/*-----------------------------busi----------------------------------*/
    /**
     * 当前操作人不存在异常
     */
    public static final String CURRENT_OPERATOR_DOES_NOT_EXIST_EXCEPTION = "163888";
    /**
     * 账套发票表更新失败异常
     */
    public static final String INVOICE_UPDATE_FAILED_EXCEPTION = "163801";
    /**
     * 不存在账套发票异常
     */
    public static final String NO_INVOICE_EXCEPTION = "163802";
    /**
     * 该机构不存在有效的营业执照
     */
    public static final String ORGANIZATION_DOES_NOT_HAVE_A_VALID_BUSINESS_LICENSE_EXCEPTION = "163803";
    /**
     * 第三方同步失败
     */
    public static final String THIRD_PARTY_SYNCHRONIZATION_FAILURE_EXCEPTION = "163804";
    /**
     * 京东专票资质审批状态修改失败
     */
    public static final String FAILED_TO_MODIFY_THE_APPROVAL_STATUS_JD_EXCEPTION = "163805";
    /**
     * 请求京东增票资质修改返回为空
     */
    public static final String REQUEST_JD_TO_MODIFY_TICKET_ADDING_QUALIFICATION_IS_NULL_EXCEPTION = "163806";
    /**
     * 京东增票资质修改返回结果转换JSON为空
     */
    public static final String THE_CONVERSION_JSON_OF_THE_RETURNED_RESULT_OF_JD_TICKET_ADDING_QUALIFICATION_MODIFICATION_IS_NULL = "163807";
    /**
     * 请求京东增加资质发票返回为空
     */
    public static final String THE_INVOICE_REQUESTING_JD_TO_ADD_QUALIFICATION_IS_NULL_EXCEPTION = "163808";
    /**
     * reqBO转换json为空
     */
    public static final String JSON_CHANGE_EXCEPTION = "163809";
    /**
     * 机构相关业务服务失败
     */
    public static final String RESP_CODE_ORG_ERROR_IS_EMPTY_EXCEPTION = "163053";
    /**
     * 会员中心新增机构失败
     */
    public static final String FAILED_TO_ADD_ORGANIZATION_IN_MEMBER_CENTER_EXCEPTION = "163054";
    /**
     * 会员中心新增erp机构编码失败
     */
    public static final String FAILED_TO_ADD_ERP_ORGANIZATION_CODE_IN_MEMBER_CENTER_EXCEPTION = "163055";
    /**
     * 会员中心更新erp机构编码失败
     */
    public static final String FAILED_TO_UPDATE_ERP_ORGANIZATION_CODE_EXCEPTION = "163056";
    /**
     * 会员中心机构修改失败
     */
    public static final String FAILED_TO_UPDATE_ORGANIZATION_EXCEPTION = "163057";
    /**
     * 系统机构不允许修改
     */
    public static final String THE_SYSTEM_MECHANISM_CANNOT_BE_MODIFIED = "163058";
    /**
     * 系统机构不允许修改
     */
    public static final String ORGANIZATION_ID_IS_EMPTY = "163059";
    /**
     * 机构不存在
     */
    public static final String THE_CORRESPONDING_ORGANIZATION_DOES_NOT_EXIST = "163060";
    /**
     * 会员中心机构详情查询父机构信息查询出错
     */
    public static final String PARENT_ORGANIZATION_INFORMATION_QUERY_ERROR = "163061";
    /**
     * 会员中心机构详情查询业务服务失败
     */
    public static final String ORGANIZATION_DETAILS_QUERY_FAILED = "163062";
    /**
     * 金额转换异常
     */
    public static final String AMOUNT_CONVERSION_EXCEPTION = "163063";
    /**
     * 机构分页查询业务服务失败
     */
    public static final String ORGANIZATION_PAGING_QUERY_SERVICE_FAILED = "163064";
    /**
     * 平级查询机构ID不能为空
     */
    public static final String PEER_QUERY_ORGANIZATION_ID_CANNOT_BE_EMPTY = "163065";
    /**
     * 本机构没有深度
     */
    public static final String THIS_ORGANIZATION_HAS_NO_DEPTH = "163066";
    /**
     * 机构服务入参为空
     */
    public static final String ORGANIZATION_SERVICE_INPUT_PARAMETER_IS_NULL = "163067";
    /**
     * 活动用户批量删除-传入的用户为空
     */
    public static final String BUSI_THE_INCOMING_USER_IS_NULL = "163001";
    /**
     * 活动用户批量删除-传入的活动编码为空
     */
    public static final String BUSI_THE_INCOMING_ACTIVITY_CODE_IS_EMPTY = "163002";
    /**
     * 该活动已经删除
     */
    public static final String THE_ACTIVITY_HAS_BEEN_DELETED = "163003";
    /**
     * 用户删除失败
     */
    public static final String USER_DELETION_FAILED = "163004";
    /**
     * 更新活动信息失败
     */
    public static final String FAILED_TO_UPDATE_ACTIVITY_INFORMATION = "163005";
    /**
     * 签署失败
     */
    public static final String SIGNING_FAILED = "163006";
    /**
     * 记录登录日志失败
     */
    public static final String LOGGING_FAILED = "163007";
    /**
     * 协议更新失败
     */
    public static final String PROTOCOL_UPDATE_FAILED = "163008";
    /**
     * 订单状态异常
     */
    public static final String ABNORMAL_ORDER_STATUS = "163009";
    /**
     * 支付中心获取支付码异常
     */
    public static final String OBTAINING_PAYMENT_CODE_EXCEPTION = "163010";
    /**
     * 支付流水号不存在
     */
    public static final String PAYMENT_SERIAL_NUMBER_DOES_NOT_EXIST = "163011";
    /**
     * 支付中心返回失败
     */
    public static final String PAYMENT_CENTER_FAILED_TO_RETURN = "163012";
    /**
     * 企业充值失败
     */
    public static final String ENTERPRISE_RECHARGE_FAILED = "163013";
    /**
     * 支付状态更新失败
     */
    public static final String PAYMENT_STATUS_UPDATE_FAILED = "163014";
    /**
     * 支付流水不存在
     */
    public static final String PAYMENT_FLOW_DOES_NOT_EXIST = "163015";
    /**
     * 商品浏览历史新增失败
     */
    public static final String BUSI_ADD_COLLECTION_GOODS_ERROR = "163016";
    /**
     * 未查询到该条积分细项
     */
    public static final String THIS_POINT_ITEM_IS_NOT_QUERIED = "163017";
    /**
     * 该条积分状态已经是将变化的状态
     */
    public static final String THE_INTEGRAL_STATE_IS_ALREADY_A_STATE_THAT_WILL_CHANGE = "163018";
    /**
     * 会员不存在
     */
    public static final String MEMBER_DOES_NOT_EXIST = "163019";
    /**
     * 已收藏该店铺
     */
    public static final String THE_STORE_HAS_BEEN_COLLECTED = "163020";
    /**
     * 店铺收藏表插入失败
     */
    public static final String FAILED_TO_INSERT_STORE_COLLECTION_TABLE = "163021";
    /**
     * 会员未收藏该店铺，取消收藏失败
     */
    public static final String FAILED_TO_CANCEL_COLLECTION = "163022";
    /**
     * 店铺收藏表删除失败
     */
    public static final String FAILED_TO_DELETE_STORE_COLLECTION_TABLE = "163023";
    /**
     * 操作类型不合法
     */
    public static final String ILLEGAL_OPERATION_TYPE = "163024";
    /**
     * 菜单ID为空
     */
    public static final String MENU_ID_IS_EMPTY = "163025";
    /**
     * 操作类型为空
     */
    public static final String OPER_TYPE_IS_EMPTY = "163026";
    /**
     * 常用菜单新增失败
     */
    public static final String FAILED_TO_ADD_COMMON_MENU = "163027";
    /**
     * 会员中优惠卷返销错误编码
     */
    public static final String BUSI_RESP_CODE_COUPON_DED_BUY_BACK_BUSI_ERROR = "163028";
    /**
     * 会员中心优惠卷抵扣业务服务错误编码
     */
    public static final String THE_COUPON_DOES_NOT_EXIST_OR_HAS_EXPIRED = "163029";
    /**
     * 优惠券不可用
     */
    public static final String COUPON_NOT_AVAILABLE = "163030";
    /**
     * 折扣类型优惠卷的当前抵扣金额入参不能为空
     */
    public static final String CURRENT_DEDUCTION_AMOUNT_CANNOT_BE_BLANK = "163031";
    /**
     * 优惠卷剩余抵扣金额不足以抵扣当前金额
     */
    public static final String INSUFFICIENT_DEDUCTION_AMOUNT = "163032";
    /**
     * 优惠卷使用状况更新失败
     */
    public static final String COUPON_USAGE_UPDATE_FAILED = "163033";
    /**
     * 转换优惠卷使用量时出错
     */
    public static final String ERROR_CONVERTING_COUPON_USAGE = "163034";
    /**
     * 转换优惠卷订单总金额出错
     */
    public static final String ERROR_CONVERTING_TOTAL_AMOUNT_OF_COUPON_ORDER = "163035";
    /**
     * 账套日志记录不存在
     */
    public static final String ACCOUNT_LOG_DOES_NOT_EXIST = "163036";
    /**
     * 日志记录删除失败
     */
    public static final String LOG_RECORD_DELETION_FAILED = "163037";
    /**
     * 钱包导入日志列表删除失败
     */
    public static final String WALLET_IMPORT_LOG_LIST_DELETION_FAILED = "163038";
    /**
     * 已有相同组织机构名称
     */
    public static final String THE_SAME_ORGANIZATION_NAME_ALREADY_EXISTS = "163039";
    /**
     * 组织机构简称首字母缩写不能重复
     */
    public static final String ORGANIZATION_ABBREVIATION_INITIALS_CANNOT_BE_REPEATED = "163040";
    /**
     * 上级机构不存在
     */
    public static final String PARENT_ORGANIZATION_DOES_NOT_EXIST = "163041";
    /**
     * 该系统机构不能新增子机构
     */
    public static final String THIS_SYSTEM_CANNOT_ADD_SUB_ORGANIZATION = "163042";
    /**
     * 客商机构不能新增运营机构
     */
    public static final String CUSTOMER_ORGANIZATIONS_CANNOT_ADD_OPER_ORGANIZATIONS = "163043";
    /**
     * 权限中心新增机构失败
     */
    public static final String FAILED_TO_ADD_ORGANIZATION_IN_AUTHORITY_CENTER_EXCEPTION = "163044";
    /**
     * 新增组织机构扩展横表业务失败
     */
    public static final String FAILED_TO_ADD_ORGANIZATION_EXTENSION_BUSINESS = "163045";
    /**
     * 未查找到机构详情信息
     */
    public static final String NO_ORGANIZATION_DETAILS_FOUND = "163046";
    /**
     * 内部供应商维护修改机构异常
     */
    public static final String INTERNAL_SUPPLIER_MODIFY_ORGANIZATION_EXCEPTION = "163047";
    /**
     * 内部供应商维护删除机构异常
     */
    public static final String INTERNAL_SUPPLIER_DELETE_ORGANIZATION_EXCEPTION = "163048";
    /**
     * 内部供应商启用异常
     */
    public static final String INTERNAL_SUPPLIER_ACTIVATION_EXCEPTION = "163049";
    /**
     * 内部供应商停用异常
     */
    public static final String INTERNAL_SUPPLIER_STOP_EXCEPTION = "163050";
    /**
     * 新增供应商信息失败
     */
    public static final String FAILED_TO_ADD_SUPPLIER_INFORMATION = "163051";
    /**
     * 更新用户扩展横表业务失败
     */
    public static final String FAILED_TO_UPDATE_THE_USER_EXTENSION_TABLE_BUSINESS = "163052";
    /**
     * 系统机构下不允许创建用户
     */
    public static final String USER_NOT_ALLOWED_CREATE_UNDER_SYSTEM_MECHANISM = "163053";
    /**
     * 请求登录机构信息不存在
     */
    public static final String LOGIN_ORGANIZATION_INFORMATION_DOES_NOT_EXIST = "163054";
    /**
     * 该机构非有效机构
     */
    public static final String THE_AGENCY_IS_NOT_AN_EFFECTIVE_AGENCY = "163055";
    /**
     * 用户名不存在
     */
    public static final String USER_NAME_DOES_NOT_EXIST = "163056";
    /**
     * 该手机号已被绑定
     */
    public static final String THE_PHONE_NUMBER_HAS_BEEN_BOUND = "163057";
    /**
     * 新增用户信息失败
     */
    public static final String FAILED_TO_ADD_USER_INFORMATION = "163058";
    /**
     * 新增权限用户信息失败
     */
    public static final String FAILED_TO_ADD_PERMISSION_USER_INFORMATION = "163059";
    /**
     * 默认密码未配置
     */
    public static final String THE_DEFAULT_PASSWORD_IS_NOT_CONFIGURED = "163060";
    /**
     * 未查找到用户信息
     */
    public static final String NO_USER_INFORMATION_FOUND = "163061";
    /**
     * 未查找到用户关联信息
     */
    public static final String NO_USER_ASSOCIATION_INFORMATION_FOUND = "163062";
    /**
     * 新密码解密失败
     */
    public static final String NEW_PASSWORD_DECRYPTION_FAILED = "163063";
    /**
     * 更新用户贸易类型失败
     */
    public static final String FAILED_TO_UPDATE_USER_TRADE_TYPE = "163064";
    /**
     * 该手机号已存在
     */
    public static final String PHONE_NUMBER_ALREADY_EXISTS = "163065";
    /**
     * 更新用户失败
     */
    public static final String FAILED_TO_UPDATE_USER = "163066";
    /**
     * 内部供应商管理员不能删除或者停用
     */
    public static final String INTERNAL_SUPPLIER_ADMINISTRATOR_CANNOT_DELETE_OR_DEACTIVATE = "163067";
    /**
     * 内部供应商管理员不能删除或者停用
     */
    public static final String MEMBER_STATUS_UPDATE_FAILED = "163068";

    /**
     * 企业不存在
     */
    public static final String BUSI_RESP_CODE_ENTERPRISE_ORG_ERROR = "163069";

    /**
     * 余额预警设置失败
     */
    public static final String FAILED_TO_SET_BALANCE_ALERT = "163070";

    /**
     * 未找到该机构信息
     */
    public static final String NOT_FOUND_ORGANIZATION_INFORMATION = "163071";

    /**
     * 已存在待审核的信息
     */
    public static final String ALREADY_HAVE_INFORMATION_TO_BE_APPROVED = "163072";
    /**
     * 保存提交信息失败
     */
    public static final String FAILED_TO_SAVE_SUBMISSION_INFORMATION = "163073";
    /**
     * 机构相关业务服务失败
     */
    public static final String BUSI_RESP_CODE_ORG_ERROR = "163074";
    /**
     * 会员维护异常
     */
    public static final String BUSI_RESP_CODE_USER_ERROR = "163075";
    /**
     * 修改企业认证信息错误
     */
    public static final String MODIFYING_ENTERPRISE_AUTHENTICATION_INFORMATION_ERROR = "163076";
    /**
     * 未查询到对应机构
     */
    public static final String NO_CORRESPONDING_ORGANIZATION_FOUND = "163077";
    /**
     * 保存企业认证信息错误
     */
    public static final String ERROR_SAVING_ENTERPRISE_AUTHENTICATION_INFORMATION = "163078";
    /**
     * 提交企业认证信息错误
     */
    public static final String ERROR_SUBMITTING_ENTERPRISE_AUTHENTICATION_INFORMATION = "163079";
    /**
     * 服务模块不存在
     */
    public static final String SERVICE_MODULE_DOES_NOT_EXIST = "163080";
    /**
     * 服务模块已存在
     */
    public static final String SERVICE_MODULE_ALREADY_EXIST = "163081";
    /**
     * 服务模块异常
     */
    public static final String RESP_CODE_SERVICE_MODULE_EXCEPTION = "163082";
    /**
     * 未登录用户查寻所在地服务异常
     */
    public static final String RESP_CODE_SEARCH_LOCATION_UNLISTED_EXCEPTION = "163083";
    /**
     * 转换编码异常
     */
    public static final String RESP_CODE_CONVERSION_CODING_EXCEPTION = "163084";
    /**
     * 发票邮寄地址异常
     */
    public static final String RESP_CODE_INVOICE_MAILING_ADDRESS_EXCEPTION = "163085";
    /**
     * 无对应会员
     */
    public static final String RESP_CODE_NO_CORRESPONDING_MEMBER_EXCEPTION = "163086";
    /**
     * 更新帐号状态失败
     */
    public static final String RESP_CODE_UPDATE_ACCOUNT_STATUS_FAILED = "163087";
    /**
     * busi层入参异常
     */
    public static final String RESP_CODE_BUSI_REQ_EXCEPTION = "163088";
    /**
     * 未找到登录信息
     */
    public static final String RESP_CODE_LOGIN_INFORMATION_NOT_FOUND = "163089";
    /**
     * 新增三方绑定信息异常
     */
    public static final String RESP_CODE_ADDING_THIRD_PARTY_BINDING_INFORMATION_EXCEPTION = "163090";

    /**
     * 用户未登录
     */
    public static final String  RESP_CODE_USER_NOT_LOGGED_IN = "163091";
    /**
     * 没有找到该会话
     */
    public static final String  RESP_CODE_THE_SESSION_NOT_FOUND = "163092";
    /**
     * 用户红包导入异常
     */
    public static final String  RESP_CODE_USER_RED_ENVELOPE_IMPORT_EXCEPTION = "163093";
    /**
     * 未找到充值用户
     */
    public static final String  RESP_CODE_RECHARGE_USER_NOT_FOUND = "163094";
    /**
     * 机构剩余充值金额不足
     */
    public static final String RESP_CODE_ORGANIZATION_LEFT_MONEY_INSUFFICIENT = "163095";
    /**
     * 组织机构余额扣减失败
     */
    public static final String  RESP_CODE_ORGANIZATION_BALANCE_DEDUCTION_FAILED = "163096";
    /**
     * 用户余额不足
     */
    public static final String  RESP_CODE_INSUFFICIENT_USER_BALANCE = "163097";
    /**
     * 无效余额类型
     */
    public static final String  RESP_CODE_INVALID_BALANCE_TYPE = "163098";
    /**
     * 新增企业余额变化日志异常
     */
    public static final String  RESP_CODE_ADD_ENTERPRISE_BALANCE_CHANGE_LOG_EXCEPTION= "163099";
    /**
     * 充值金额需大于0
     */
    public static final String  RESP_CODE_RECHARGE_AMOUNT_MUST_BE_GREATER_THAN_0= "163100";
    /**
     * 充值日志记录失败
     */
    public static final String  RESP_CODE_RECHARGE_LOGGING_FAILED= "163101";
    /**
     * 发放名目记录不存在
     */
    public static final String  RESP_CODE_DISTRIBUTION_RECORD_DOES_NOT_EXIST= "163102";
    /**
     * 发放名目更新失败
     */
    public static final String  RESP_CODE_FAILED_TO_UPDATE_DISTRIBUTION_NAME= "163103";
    /**
     * 机构类型维护异常
     */
    public static final String  RESP_CODE_ORG_TYPE_MAINTENANCE_EXCEPTION= "163104";
    /**
     * 机构流程模板维护异常
     */
    public static final String  RESP_CODE_ORG_PROCESS_TEMPLATE_EXCEPTION= "163105";
    /**
     * 该编码已存在当前自定义配置
     */
    public static final String  RESP_CODE__ALREADY_EXISTS_IN_CUSTOM_CONFIGURATION= "163106";
    /**
     * 新增银行信息失败
     */
    public static final String  RESP_CODE_FAILED_TO_ADD_BANK_INFORMATION= "163107";
    /**
     * 不存在该银行信息
     */
    public static final String  RESP_CODE_BANK_INFORMATION_DOES_NOT_EXIST= "163108";
    /**
     * 新增银行信息失败
     */
    public static final String  RESP_CODE_FAILED_TO_UPDATE_BANK_INFORMATION= "163109";
    /**
     * 日期格式转换错误
     */
    public static final String  RESP_CODE_DATE_FORMAT_CONVERSION_ERROR= "163110";
    /**
     * 用户不存在
     */
    public static final String  RESP_CODE_USER_DOES_NOT_EXIST= "163111";
    /**
     * 会员信息查询异常
     */
    public static final String  RESP_CODE_MEMBER_INFORMATION_QUERY_EXCEPTION= "163112";
    /**
     * 不存在该会员Id
     */
    public static final String  RESP_CODE_MEMBER_ID_EXCEPTION= "163113";
    /**
     * 无对应账套记录
     */
    public static final String  RESP_CODE_NO_CORRESPONDING_ACCOUNT_RECORD_EXCEPTION= "163114";
    /**
     * 关系服务异常
     */
    public static final String RESP_CODE_RELATIONSHIP_EXCEPTION = "163115";
    /**
     * 企业余额充值异常
     */
    public static final String RESP_CODE_ENTERPRISE_BALANCE_RECHARGE_EXCEPTION = "163116";
    /**
     * 机构额度抵扣异常
     */
    public static final String RESP_CODE_INSTITUTIONAL_LIMIT_DEDUCTION_EXCEPTION = "163117";
    /**
     * 供应商整改异常
     */
    public static final String RESP_CODED_SUPPLIER_RECTIFICATION_EXCEPTION = "163118";
    /**
     * 三方绑定失败
     */
    public static final String RESP_CODED_THIRD_PARTY_BINDING_FAILED = "163119";
    /**
     * 账套名称已存在
     */
    public static final String RESP_CODED_ACCOUNT_NAME_ALREADY_EXISTS = "163120";
    /**
     * 复制活动会员钱包失败
     */
    public static final String RESP_CODED_COPY_ACTIVE_MEMBER_WALLET_FAILED = "163120";
    /**
     * 钱包金额回收业务服务异常
     */
    public static final String RESP_CODED_WALLET_AMOUNT_RECOVERY_EXCEPTION = "163121";
    /**
     * 更新部门年度预算额异常
     */
    public static final String RESP_CODED_UPDATE_DEPARTMENT_ANNUAL_BUDGET_EXCEPTION = "163121";
    /**
     * 该活动没有金额汇总信息
     */
    public static final String RESP_CODED_NO_AMOUNT_SUMMARY_INFORMATION_THIS_ACTIVITY = "163121";
    /**
     * 该活动没有对应钱包信息
     */
    public static final String RESP_CODE_ACTIVITY_HAS_NO_WALLET_INFORMATION = "163121";
    /**
     * 用户钱包设置失败
     */
    public static final String RESP_CODE_USER_WALLET_SETTING_FAILED = "163121";
    /**
     * 活动金额汇总更新信息失败
     */
    public static final String RESP_CODE_UPDATE_ACTIVITY_AMOUNT_SUMMARY_INFORMATION_FAILED = "163121";
    /**
     * 活动查询异常
     */
    public static final String RESP_CODE_ACTIVITY_QUERY_EXCEPTION = "163121";
    /**
     * 工作台新增失败
     */
    public static final String RESP_CODE_ADD_WORKBENCH_FAILED = "163121";




    /*-----------------------------ability----------------------------------b*/

    /**
     * 企业不存在
     */
    public static final String ABILITY_RESP_CODE_ENTERPRISE_ORG_ERROR = "161999";

    /**
     * 活动用户批量删除-传入的用户为空
     */
    public static final String THE_INCOMING_USER_IS_NULL = "161001";
    /**
     * 活动用户批量删除-传入的活动编码为空
     */
    public static final String THE_INCOMING_ACTIVITY_CODE_IS_EMPTY = "161002";
    /**
     * 协议内容不能为空
     */
    public static final String AGREEMENT_CONTENT_CANNOT_BE_EMPTY = "161003";
    /**
     * 时间转换异常
     */
    public static final String TIME_CONVERSION_EXCEPTION = "161004";
    /**
     * 无效的操作类型
     */
    public static final String INVALID_OPERATION_TYPE = "161005";
    /**
     * 用户名不能为空
     */
    public static final String USER_NAME_CANNOT_BE_EMPTY = "161006";
    /**
     * 解密回调参数异常
     */
    public static final String DECRYPTION_CALLBACK_PARAMETER_EXCEPTION = "161007";
    /**
     * 用户贸易身份选择为空
     */
    public static final String USER_TRADE_IDENTITY_SELECTION_IS_BLANK = "161008";
    /**
     * 修改异常
     */
    public static final String ABILITY_UPDATE_ENTERPRISE_ACCOUNT_INFO_EXCEPTION = "161009";
    /**
     * 该手机号已被绑定
     */
    public static final String ABILITY_THE_PHONE_NUMBER_HAS_BEEN_BOUND = "161010";
    /**
     * 验证码错误
     */
    public static final String ABILITY_RESP_CODE_LOGIN_VF_CODE_CHECK_ERROR = "161011";
    /**
     * 会员ID为空
     */
    public static final String ABILITY_MEM_ID_IS_EMPTY = "161012";
    /**
     * 不支持该操作类型
     */
    public static final String ABILITY_OPERATION_TYPE_IS_NOT_SUPPORTED = "161013";
    /**
     * 用户已停用，请联系管理员
     */
    public static final String USER_DISABLED_ERROR = "161014";
    /**
     * 新密码解密失败
     */
    public static final String ABILITY_NEW_PASSWORD_DECRYPTION_FAILED = "161015";
    /**
     * 旧密码解密失败
     */
    public static final String ABILITY_OLD_PASSWORD_DECRYPTION_FAILED = "161016";
    /**
     * 机构相关业务服务失败
     */
    public static final String ABILITY_RESP_CODE_ORG_ERROR = "161017";
    /**
     * 统一社会信用代码已存在
     */
    public static final String UNIFIED_SOCIAL_CREDIT_CODE_ALREADY_EXISTS = "161018";
    /**
     * 发送邮件失败
     */
    public static final String FAILED_TO_SEND_MAIL = "161019";
    /**
     * 企业名称已存在
     */
    public static final String ENTERPRISE_NAME_ALREADY_EXISTS = "161020";
    /**
     * 用户名不存在
     */
    public static final String ABILITY_USER_NAME_DOES_NOT_EXIST = "161021";
    /**
     * 获取供应商机构编码异常
     */
    public static final String  OBTAINING_SUPPLIER_ORGANIZATION_CODE_EXCEPTION = "161022";
    /**
     * 会员横向扩展表异常
     */
    public static final String  MEMBER_LATERAL_EXPANSION_TABLE_EXCEPTION = "161023";
    /**
     * 新增供应商信息失败
     */
    public static final String  ABILITY_FAILED_TO_ADD_SUPPLIER_INFORMATION = "161024";
    /**
     * 新增企业信息失败
     */
    public static final String  FAILED_TO_ADD_ENTERPRISE_INFORMATION = "161025";
    /**
     * 新增企业变更信息失败
     */
    public static final String  FAILED_TO_ADD_ENTERPRISE_CHANGE_INFORMATION = "161026";
    /**
     * 新增银行信息失败
     */
    public static final String  FAILED_TO_ADD_BANK_INFORMATION = "161027";
    /**
     * 新增银行变更信息失败
     */
    public static final String  FAILED_TO_ADD_BANK_CHANGE_INFORMATION = "161028";
    /**
     * 企业详情查询参数错误
     */
    public static final String  ENTERPRISE_DETAILS_QUERY_PARAMETER_ERROR = "161029";
    /**
     * 页数配置错误
     */
    public static final String  RESP_CODE_PAGE_NUMBER_CONFIGURATION_ERROR = "161030";
    /**
     * 生成验证码图片异常
     */
    public static final String  RESP_CODE_GENERATING_VERIFICATION_CODE_PICTURE = "161031";
    /**
     * 验证码错误
     */
    public static final String  RESP_CODE_VERIFICATION_CODE_ERROR = "161032";
    /**
     * 不允许登录
     */
    public static final String  RESP_CODE_LOGIN_NOT_ALLOWED = "161033";
    /**
     * 用户密码错误
     */
    public static final String  ABILITY_RESP_CODE_LOGIN_ERROR = "161034";
    /**
     * 保存登陆日志失败
     */
    public static final String  ABILITY_RESP_CODE_FAILED_TO_SAVE_LOGIN_LOG = "161035";
    /**
     * 绑定微信用户信息失败
     */
    public static final String  ABILITY_RESP_CODE_FAILED_TO_BIND_WECHAT = "161035";
    /**
     * 手机号或者验证码错误
     */
    public static final String  ABILITY_RESP_CODE_WRONG_MOBILE_PHONE_NUMBER_OR_VERIFICATION_CODE = "161035";
    /**
     * 账套业务服务失败
     */
    public static final String  ABILITY_RESP_CODE_ACCOUNT_SERVICE_FAILED = "161035";
    /**
     * 无权限操作
     */
    public static final String  ABILITY_RESP_CODE_UNAUTHORIZED_OPERATION = "161035";
    /**
     * 登录企业不存在
     */
    public static final String  ABILITY_RESP_CODE_LOGIN_ENTERPRISE_DOES_NOT_EXIST = "161035";
    /**
     * 用户名已存在
     */
    public static final String  ABILITY_RESP_CODE_USER_NAME_ALREADY_EXISTS = "161035";
    /**
     * 该手机号已被绑定
     */
    public static final String  ABILITY_RESP_CODE_PHONE_HAS_BOUND = "161035";
    /**
     * 默认密码未配置
     */
    public static final String  ABILITY_RESP_CODE_DEFAULT_PASSWORD_IS_NOT_CONFIGURED = "161035";
    /**
     * 京东PIN为空
     */
    public static final String  ABILITY_RESP_CODE_JD_PIN_IS_EMPTY = "161035";
    /**
     * 京东PIN密码为空
     */
    public static final String  ABILITY_RESP_CODED_JD_PIN_PASSWORD_IS_EMPTY = "161035";
    /**
     * 字典编码为空
     */
    public static final String  ABILITY_RESP_CODED_DICTIONARY_CODE_IS_EMPTY = "161035";
    /**
     * 新增内容为空
     */
    public static final String  ABILITY_RESP_CODED_ADD_CONTENT_IS_EMPTY = "161035";
    /**
     * 字典维护服务异常
     */
    public static final String  ABILITY_RESP_CODED_DIC_SERVICE_MAINTAIN_EXCEPTION = "161035";
    /**
     * 配置ID为空
     */
    public static final String  ABILITY_RESP_CODED_CONFIGURATION_ID_IS_EMPTY = "161035";
    /**
     * 机构类型名称为空
     */
    public static final String  ABILITY_RESP_CODED_ORG_TYPE_IS_EMPTY = "161035";
    /**
     * 证件号已存在
     */
    public static final String  ABILITY_RESP_CODED_CERTIFICATE_NUMBER_ALREADY_EXISTS = "161035";
    /**
     * 查询机构失败
     */
    public static final String  ABILITY_RESP_CODED_ORG_QRY_FIALD = "161035";
    /**
     * 金额转换异常
     */
    public static final String  ABILITY_RESP_CODED_AMOUNT_CONVERSION_EXCEPTION = "161035";
    /**
     * 会员信息查询失败
     */
    public static final String  ABILITY_RESP_CODED_QRY_MEM_INFO_EXCEPTION = "161035";
    /**
     * 修改密码失败
     */
    public static final String  ABILITY_RESP_CODED_FAILED_TO_MODIFY_PASSWORD = "161035";
    /**
     * 供应商整改异常
     */
    public static final String  ABILITY_RESP_CODED_SUPPLIER_RECTIFICATION_EXCEPTION = "161035";
    /**
     * 机构不存在
     */
    public static final String  ABILITY_RESP_CODED_ORGANIZATION_DOES_NOT_EXIST = "161035";
    /**
     * 查询企业余额失败
     */
    public static final String  ABILITY_RESP_CODED_QUERY_ENTERPRISE_BALANCE_FAILED = "161035";
    /**
     * 已有相同组织机构名称
     */
    public static final String ABILITY_THE_SAME_ORGANIZATION_NAME_ALREADY_EXISTS = "161035";
    /**
     * 部门年度预算额写入失败
     */
    public static final String ABILITY_WRITE_DEPARTMENT_ANNUAL_BUDGET_AMOUNT_FAILED  = "161035";



    /*-----------------------------comb----------------------------------a*/
    /**
     * 用户名不能为空
     */
    public static final String COMB_USER_NAME_CANNOT_BE_EMPTY = "162001";
    /**
     * 会员信息不存在
     */
    public static final String MEMBER_INFORMATION_DOES_NOT_EXIST = "162002";
    /**
     * 用户新增入参为空
     */
    public static final String THE_USER_ADDED_INPUT_PARAMETER_IS_NULL = "162003";
    /**
     * 权限中心新增用户异常
     */
    public static final String ADDING_USER_IN_PERMISSION_CENTER_EXCEPTION = "162004";
    /**
     * 用户修改入参为空
     */
    public static final String USER_MODIFIED_ENTRY_IS_EMPTY = "162005";
    /**
     * 权限中心修改用户异常
     */
    public static final String UPDATE_USER_IN_PERMISSION_CENTER_EXCEPTION = "162006";
    /**
     * 用户启用入参为空
     */
    public static final String USER_ENABLED_INPUT_PARAMETER_IS_NULL = "162007";
    /**
     * 权限中心启用用户异常
     */
    public static final String PERMISSION_CENTER_ENABLE_USER_EXCEPTION = "162008";
    /**
     * 权限中心停用用户异常
     */
    public static final String PERMISSION_CENTER_STOP_USER_EXCEPTION = "162009";
    /**
     * 权限中心删除用户异常
     */
    public static final String PERMISSION_CENTER_DELETE_USER_EXCEPTION = "162010";
    /**
     * 用户删除入参为空
     */
    public static final String THE_USER_DELETE_INPUT_PARAMETER_IS_NULL = "162011";
    /**
     * 用户修改密码入参为空
     */
    public static final String USER_MODIFICATION_PASSWORD_INPUT_PARAMETER_IS_BLANK = "162012";
    /**
     * 权限中心修改密码失败
     */
    public static final String PERMISSION_CENTER_FAILED_TO_MODIFY_PASSWORD = "162013";
    /**
     * 用户角色查询入参为空
     */
    public static final String USER_ROLE_QUERY_INPUT_PARAMETER_IS_NULL = "162014";
    /**
     * 用户岗位查询入参为空
     */
    public static final String USER_POSITION_QUERY_INPUT_PARAMETER_IS_BLANK = "162015";
    /**
     * 根据用户名查询用户信息入参为空
     */
    public static final String QUERYING_USER_INFORMATION_PARAM_IS_EMPTY = "162016";
    /**
     * 权限中心修改用户登录名失败
     */
    public static final String PERMISSION_CENTER_FAILED_TO_MODIFY_USER_LOGIN = "162017";
    /**
     * 权限中心复制密码给另一个用户失败
     */
    public static final String FAILED_TO_COPY_PASSWORD = "162018";
    /**
     * 获取当前在子系统能访问的用户权限菜单失败
     */
    public static final String FAILED_TO_GET_USER_PERMISSION_MENU = "162019";
    /**
     * 调用权限中心角色授权提交服务失败
     */
    public static final String ROLE_AUTHORIZATION_SUBMISSION_FAILED = "162020";
    /**
     * 调用权限中心角色查询用户异常
     */
    public static final String ROLE_QUERY_USER_EXCEPTION = "162021";
    /**
     * 用户批量新增入参为空
     */
    public static final String THE_INPUT_PARAMETER_ADDED_BY_THE_USER_IN_BATCH_IS_EMPTY = "162022";
    /**
     * 用户批量新增入参为空
     */
    public static final String BATCH_ADD_USER_EXCEPTION = "162023";
    /**
     * 用户停用异常
     */
    public static final String USER_STOP_EXCEPTION = "162024";
    /**
     * 用户启用异常
     */
    public static final String USER_ENABLED_EXCEPTION = "162025";
    /**
     * 旧密码不匹配
     */
    public static final String OLD_PASSWORDS_DO_NOT_MATCH = "162026";
    /**
     * 新密码不能与旧密码相同
     */
    public static final String NEW_PASSWORD_CANNOT_EQUALS_OLD_PASSWORD = "162027";
    /**
     * comb层 机构相关业务服务失败
     */
    public static final String COMB_RESP_CODE_ORG_ERROR = "162028";
    /**
     * comb层 该用户导入日志不存在
     */
    public static final String COMB_RESP_CODE_THE_USER_IMPORT_LOG_DOES_NOT_EXIST = "162029";
    /**
     * comb层 默认密码未配置
     */
    public static final String COMB_RESP_CODE_DEFAULT_PASSWORD_NOT_CONFIGURED = "162030";
    /**
     * comb层 微信接口返回为空
     */
    public static final String COMB_RESP_CODE_WECHAT_INTERFACE_RETURNED_NULL = "162031";
    /**
     * comb层 会员兼职异常
     */
    public static final String COMB_RESP_CODE_MEMBER_PART_TIME_EXCEPTION = "162032";
    /**
     * comb层 获取会员昵称ID异常
     */
    public static final String COMB_RESP_CODE_GET_MEMBER_ID_EXCEPTION = "162033";
    /**
     * comb层 无对应企业账套余额
     */
    public static final String COMB_RESP_CODE_NO_CORRESPONDING_ENTERPRISE_ACCOUNT_BALANCE= "162034";
    /**
     * 当前登录用户不存在
     */
    public static final String  RESP_CODE_CURRENTLY_LOGGED_USER_DOES_NOT_EXIST= "162035";
    /**
     * comb层 该手机号已被绑定
     */
    public static final String COMB_THE_PHONE_NUMBER_HAS_BEEN_BOUND = "162036";
    /**
     * comb层 该手机号已被绑定
     */
    public static final String COMB_BINDING_MOBILE_EXCEPTION = "162037";
    /**
     * comb层 钱包余额单位转换异常
     */
    public static final String COMB_WALLET_BALANCE_UNIT_CONVERSION_EXCEPTION = "162038";
    /**
     * comb层 机构不存在
     */
    public static final String COMB_ORGANIZATION_DOES_NOT_EXIST = "162039";
    /**
     * comb层 金额转换异常
     */
    public static final String COMB_AMOUNT_CONVERSION_EXCEPTION = "162040";
    /**
     * comb层 会员兼职失败
     */
    public static final String COMB_MEMBER_PART_TIME_FAILED = "162041";
    /**
     * comb层 钱包批量充值服务异常
     */
    public static final String COMB_WALLET_BATCH_RECHARGE_SERVICE_EXCEPTION = "162041";
    /**
     * comb层 该红包导入日志不存在
     */
    public static final String COMB_RED_PACKET_LOG_DOES_NOT_EXIST = "162041";
    /**
     * comb层 红包导入日志修改失败
     */
    public static final String COMB_RED_RED_PACKET_IMPORT_LOG_MODIFICATION_FAILED = "162041";









    /*-----------------------------atom----------------------------------*/


    /**
     * 机构相关业务服务失败
     */
    public static final String ATOM_RESP_CODE_ORG_ERROR = "164001";
    /**
     * 下载中心返回异常
     */
    public static final String ATOM_RESP_CODE_DOWNLOAD_CENTER_EXCEPTION = "164001";
    /**
     * 微信接口返回为空
     */
    public static final String ATOM_RESP_CODE_WECHAT_INTERFACE_RETURNED_NULL = "164001";
    /**
     * 获取机构名称异常
     */
    public static final String ATOM_RESP_CODE_GET_ORGANIZATION_NAME_EXCEPTION = "164001";
    /**
     * 权限中心保存登陆异常
     */
    public static final String ATOM_RESP_CODE_PERMISSION_CENTER_SAVE_LOGIN_EXCEPTION = "164001";






    /**
     * DycUmcEnterpriseAddProductionBusiService 失败异常编码
     */
    public static final String RESP_CODE_ENTERPRISE_ADD_ERROR = "161000";
    /**
     * DycUmcSupplierAddAssessmentRatingIndexBusiService 失败异常编码
     */
    public static final String RESP_CODE_ADD_ASSESSMENT_RATING_INDEX_ERROR = "161001";
    /**
     * DycUmcSupplierAddCategoryQualificationMappingAbilityService 失败异常编码
     */
    public static final String RESP_CODE_ADD_CATEGORY_QUALOFICATION_ERROR = "161002";
    /**
     * DycUmcSupplierAddCommodityQualifAbilityService 失败异常编码
     */
    public static final String RESP_CODE_ADD_COMMODY_QUALIFY_ERROR = "161003";

    /**
     * DycUmcSupplierAddRatingRulesAbilityService 失败异常编码
     */
    public static final String RESP_CODE_ADD_RATING_RULES_ERROR = "161004";

    /**
     * DycUmcSupplierAddScoreTeam 失败异常编码
     */
    public static final String RESP_CODE_ADD_ADD_CORE_TEAM_ERROR = "161005";
    /**
     * DycUmcSupplierAddScoringIndicatorsAbilityService 失败异常编码
     */
    public static final String RESP_CODE_ADD_SCORING_INDICATORS_ERROR = "161006";

    /**
     * DycUmcSupplierAuditAdjustGrade 失败异常编码
     */
    public static final String RESP_CODE_AUDIT_ADJUST_GRADE_ERROR = "161007";
    /**
     * DycUmcSupplierAuditRating 失败异常编码
     */
    public static final String RESP_CODE_AUDIT_RATING_ERROR = "161008";
    /**
     * DycUmcSupplierCreateRatingScore 失败异常编码
     */
    public static final String RESP_CODE_CREATE_RATING_SCORE_ERROR = "161009";
    /**
     * DycUmcSupplierDeleteCategoryQualificationMapping 失败异常编码
     */
    public static final String RESP_CODE_DELETE_CATEGORY_QUALIFYCATION_ERROR = "161010";
    /**
     * DycUmcSupplierDeleteLevelSet 失败异常编码
     */
    public static final String RESP_CODE_DELETE_LEVEL_SET_ERROR = "161011";
    /**
     * 同步分值信息失败
     */
    public static final String RESP_CODE_SYNCHRONIZE_SCORE_ERROR = "163001";
    /**
     * 删除一级权重失败
     */
    public static final String RESP_CODE_DELETE_LEVEL_ERROR = "163002";
    /**
     * 删除失败
     */
    public static final String RESP_CODE_DELETE_ERROR = "163003";
    /**
     * 系统指标不能删除
     */
    public static final String SYSTEM_INDICATORS_CANNOT_DELETE_ERROR = "163004";
    /**
     * 存在已分配指标项的指标分类不能删除
     */
    public static final String RESP_CODE_CLASSIFICATION_ASSIGNED_INDICATORS_CANNOT_DELETE_ERROR = "163005";
    /**
     * 未查询到调级信息
     */
    public static final String RESP_CODE_NO_LEVEL_ADJUST_INFORMATION_FOUND_ERROR = "163006";
    /**
     * 插入供应商信息修改表失败
     */
    public static final String RESP_CODE_SUPPLIER_INFORMATION_MODIFICATION_ERROR = "163007";
    /**
     * 插入信息到企业主表失败
     */
    public static final String RESP_CODE_INSERT_ENTERPRISE_INFORMATION_ERROR = "163008";
    /**
     * 删除供应商银行信息失败
     */
    public static final String RESP_CODE_DELETE_BANK_ERROR = "163009";
    /**
     * 新增供应商信息失败
     */
    public static final String RESP_CODE_ADD_SUPPLIER_INFO_ERROR = "163011";
    /**
     * 存在无效用户
     */
    public static final String RESP_CODE_INVALID_USER_ERROR = "163012";
    /**
     * 用户无管理权限
     */
    public static final String RESP_CODE_NO_AUTH_ADMIN_ERROR = "163013";
    /**
     * 审核结果为空
     */
    public static final String RESP_CODE_AUDIT_RESULT_ERROR = "161001";
    /**
     * 审核类型为空
     */
    public static final String RESP_CODE_AUDIT_TYPE_ERROR = "161002";
    /**
     * 新增审核日志记录失败
     */
    public static final String RESP_CODE_ADD_AUDIT_INFO_ERROR = "163013";
    /**
     * 删除银行信息失败
     */
    public static final String RESP_CODE_DELETE_BANK_INFO_ERROR = "163014";
    /**
     * 同步银行信息失败
     */
    public static final String RESP_CODE_SYNCHRONIZE_BANK_INFO_ERROR = "163015";
    /**
     * 同步供应商信息失败
     */
    public static final String RESP_CODE_SYNCHRONIZE_SUPPLIER_INFO_ERROR = "163016";
    /**
     * 同步企业信息失败
     */
    public static final String RESP_CODE_SYNCHRONIZE_ENTERPRISE_ERROR = "163017";
    /**
     * 同步机构信息失败
     */
    public static final String RESP_CODE_SYNCHRONIZE_ORG_INFO_ERROR = "163018";
    /**
     * 修改表企业准入状态失败
     */
    public static final String RESP_CODE_MODIFY_INTO_ERROR = "163019";
    /**
     * 未查询到供应商信息
     */
    public static final String RESP_CODE_SUPPLIER_INFO_NOT_FOUND_ERROR = "163020";
    /**
     * 未查询到企业信息
     */
    public static final String RESP_CODE_ENTERPRISE_INFO_NOT_FOUND_ERROR = "163021";
    /**
     * 未查询到银行信息
     */
    public static final String RESP_CODE_BANK_INFO_NOT_FOUND_ERROR = "163022";
    /**
     * 修改供应商状态失败
     */
    public static final String RESP_CODE_SUPPLIER_STATUS_MODIFY_ERROR = "163023";
    /**
     * 修改变更表状态失败
     */
    public static final String RESP_CODE_MODIFY_CHANGE_FORM_ERROR = "163024";
    /**
     * 字典查询结果为空
     */
    public static final String RESP_CODE_DIC_EMPTY_ERROR = "163025";
    /**
     * 会员横向扩展表新增失败
     */
    public static final String RESP_CODE_SCALE_OUT_TABLE_ERROR = "163026";
    /**
     * 入参机构ID为空
     */
    public static final String RESP_CODE_ORGID_EMPTY_ERROR = "163027";
    /**
     * 已存在申请中信息单
     */
    public static final String RESP_CODE_EXSISTENCE_APPLY_ERROR = "163028";
    /**
     * 修改信息表失败
     */
    public static final String RESP_CODE_MODIFY_INFO_ERROR = "163029";
    /**
     * 修改信息到企业修改表失败
     */
    public static final String RESP_CODE_UPDATE_ENTERPRICE_ERROR = "163030";
    /**
     * 修改供应商银行信息失败
     */
    public static final String RESP_CODE_UPDATE_BANK_INFO_ERROR = "163031";
    /**
     * 未查询到评分小组信息
     */
    public static final String RESP_CODE_ASSESS_GROUP_NOT_FOUND_ERROR = "163032";
    /**
     * 未查询到评分人信息
     */
    public static final String RESP_CODE_ASSESS_PERSON_NOT_FOUND_ERROR = "163033";
    /**
     * 修改会员评分信息失败
     */
    public static final String RESP_CODE_ASSESS_MODIFY_NOT_FOUND_ERROR = "163034";
    /**
     * 同步失信行为得分失败
     */
    public static final String RESP_CODE_ASSESS_SYNCHRONIZE_NOT_FOUND_ERROR = "163035";
    /**
     * 修改评分状态失败
     */
    public static final String RESP_CODE_MODIFY_ASSESS_STATUS_ERROR = "163036";
    /**
     * 修改评分人员最终得分失败
     */
    public static final String RESP_CODE_MODIFY_FINAL_SCORE_ERROR = "163037";
    /**
     * 修改小组评分状态失败
     */
    public static final String RESP_CODE_MODIFY_ASSESS_GROUP_STATUS_ERROR = "163038";
    /**
     * 未查询到评分记录信息
     */
    public static final String RESP_CODE_ASSESS_INDICATORS_INFO_NOT_FOUND_ERROR = "163039";
    /**
     * 评分信息为空
     */
    public static final String RESP_CODE_ASSESS_EMPTY_ERROR = "163040";
    /**
     * 修改指标信息失败
     */
    public static final String RESP_CODE_MODIFY_ASSESS_INDICATORS_ERROR = "163041";
    /**
     * 该品类与资质已添加过映射
     */
    public static final String RESP_CODE_CLASSIFICATION_ASSIGNED_MAPPING_EXSISTENCE_ERROR = "163042";
    /**
     * 修改映射关系失败
     */
    public static final String RESP_CODE_MODIFY_MAPPING_ERROR = "163043";
    /**
     * 等级修改失败
     */
    public static final String RESP_CODE_MODIFY_ASSESSLEVEL_ERROR = "163044";
    /**
     * 权重异常
     */
    public static final String RESP_CODE_WEIGHT_ERROR = "161045";
    /**
     * 评分规则异常
     */
    public static final String RESP_CODE_MODIFY_RATING_RULES_ERROR = "163046";
    /**
     * 修改小组信息失败
     */
    public static final String RESP_CODE_MODIFY_GROUP_ERROR = "163047";
    /**
     * 已提交黑名单异常
     */
    public static final String RESP_CODE_EXSISTENCE_BLACK_ERROR = "163048";
    /**
     * 黑名单更新异常
     */
    public static final String RESP_CODE_UPDATE_BLACK_ERROR = "163049";
    /**
     * 新增黑名单信息失败
     */
    public static final String RESP_CODE_ADD_BLACK_ERROR = "163050";
    /**
     * 黑名单审核异常
     */
    public static final String RESP_CODE_BLACK_AUDIT_ERROR = "163051";
    /**
     * 黑名单不存在流程信息
     */
    public static final String RESP_CODE_UOC_NOTEXSISTENCE_ERROR = "163052";
    /**
     * 黑名单审核
     */
    public static final String RESP_CODE_AUDIT_BLACK_ERROR = "163053";
    /**
     * 供应商定级信息保存失败
     */
    public static final String RESP_CODE_ADJUST_SAVE_ERROR = "163054";
    /**
     * 保存申请信息异常
     */
    public static final String RESP_CODE_ADJUST_APPLY_ERROR = "163055";
    /**
     * 定级申请异常
     */
    public static final String RESP_CODE_ADJUST_GRADE_VERIFY_ERROR = "161056";
    /**
     * 更新迭代表信息失败
     */
    public static final String RESP_CODE_UPDATE_ITERATION_ERROR = "163057";
    /**
     * 更新调级信息
     */
    public static final String RESP_CODE_UPDATE_GRADE_ERROR = "163057";
    /**
     * 新增调级迭代表信息异常
     */
    public static final String RESP_CODE_UPDATE_GRADE_ITORATOR_ERROR = "163058";
    /**
     * 修改资质信息异常
     */
    public static final String RESP_CODE_UPDATE_QUALIFY_ERROR = "163059";
    /**
     * 企业品类删除失败
     */
    public static final String RESP_CODE_ENTERPRISE_CLASSIFY_UPDATE_ERROR = "163060";
    /**
     * 企业资质信息审核异常
     */
    public static final String RESP_CODE_QUALIFY_AUDIT_ERROR = "163061";
    /**
     * 企业资质信息删除异常
     */
    public static final String RESP_COD_QUALIFY_DELETE_ERROR = "163062";
    /**
     * 未查询到调级
     */
    public static final String RESP_CODE_ADJUST_EMPTY_ERROR = "163063";
    /**
     * 资质入参校验
     */
    public static final String RESP_CODE_QUALIFY_SAVE_VERIFY_ERROR = "161064";
    /**
     * 企业资质信息修改入参校验
     */
    public static final String RESP_CODE_QUALIFY_UPDATE_VERIFY_ERROR = "161065";
    /**
     * 外部企业服务增值申请服务入参
     */
    public static final String RESP_CODE_PARAM_VERIFY_EXCEPTION = "161066";
    /**
     * 该采购企业已存在审核中的升级申请单
     */
    public static final String RESP_CODE_GROW_VALUE_EXSISTENCE_ERROR = "163067";
    /**
     * 写入营业执照或企业授权委托书或一般纳税人证明失败
     */
    public static final String RESP_CODE_INSERT_HORIZONTAL_ERROR = "163068";
    /**
     * 获取不良记录编码异常
     */
    public static final String RESP_CODE_GAIN_MISCODE_ERROR = "163069";
    /**
     * 获取申请发起人信息失败
     */
    public static final String RESP_CODE_OBTAIN_APPLY_PERSON_ERROR = "163070";
    /**
     * 用户授权角色失败
     */
    public static final String RESP_CODE_AUTH_ROLE_ERROR = "163071";
    /**
     * 增值申请状态错误
     */
    public static final String RESP_CODE_ADDED_VALU_STATUS_ERROR = "163072";
    /**
     * 该采购企业已存在审核中的升级申请单
     */
    public static final String RESP_CODE_APPLY_EXSISTENCE_ERROR = "163073";
    /**
     * 修改失败
     */
    public static final String RESP_CODE_UPDATE_ENTERPRICE_VALUE_ERROR = "163074";
    /**
     * 更新营业执照或企业授权委托书失败
     */
    public static final String RESP_CODE_UPDATE_HORIZONTAL_ERROR = "163075";

    /**
     * 保证金信息查询结果为空
     */
    public static final String RESP_CODE_DEPOSIT_EMPTY_ERROR = "163076";
    /**
     * 金额转换异常
     */
    public static final String RESP_CODE_TRANSACTION_DEPOSIT_ERROR = "163077";
    /**
     * 罚款金额金额处理错误
     */
    public static final String RESP_CODE_PENITY_AMOUNT_ERROR = "163078";
    /**
     * 查询类型不存在
     */
    public static final String RESP_CODE_TYOE_NOT_EXSISTENCE_ERROR = "163079";
    /**
     * 修改原有银行账户失败
     */
    public static final String RESP_CODE_MODIFY_OLD_BANKINFO_ERROR = "163080";
    /**
     * 供应商银行账户新增失败
     */
    public static final String RESP_CODE_ADD_BANKINFO_ERROR = "163082";
    /**
     * 供应商银行账户修改表新增失败
     */
    public static final String RESP_CODE_UPDATE_BANKINFO_ERROR = "163081";
    /**
     * 供应商银行账户查询结果为空
     */
    public static final String RESP_CODE_BANK_INFO_EMPTY_ERROR = "163082";
    /**
     * 银行信息不存在
     */
    public static final String RESP_CODE_UPDATE_BANK_NOT_EXSISTENCE_ERROR = "163083";
    /**
     * 业绩异议新增失败
     */
    public static final String RESP_CODE_DISSENT_ADD_ERROR = "163084";
    /**
     * 记录不存在
     */
    public static final String RESP_CODE_PERFORMANCE_NOT_EXSISTENCE_ERROR = "163085";
    /**
     * 业绩异议信息状态异常
     */
    public static final String RESP_CODE_PERFORMANCE_DECENT_ERROR = "163086";
    /**
     * 业绩异议信息处理失败
     */
    public static final String RESP_CODE_PERFORMANCE_DECENT_DEAL_ERROR = "163087";
    /**
     * 供应商更新协议信息失败
     */
    public static final String RESP_CODE_AGREE_UPDATE_ERROR = "163088";
    /**
     * 记录审核日志失败
     */
    public static final String RESP_CODE_SAVE_AUDIT_LOG_ERROR = "162089";
    /**
     * 供应商变更表信息修改失败
     */
    public static final String RESP_CODE_SUPPLIER_CHNG_UPDATE_ERROR = "163090";
    /**
     * 企业变更表信息修改失败
     */
    public static final String RESP_CODE_ENTERPRICE_CHNG_UPDATE_ERROR = "163091";
    /**
     * 企业变更表信息修改失败
     */
    public static final String RESP_CODE_MODIFY_SUPSIGN_VERIFY_ERROR = "161092";
    /**
     * 企业变更表信息修改失败
     */
    public static final String RESP_CODE_MODIFY_SUPSIGN_VERIFY_BUSI_ERROR = "163092";

    /**
     * 写入供应商签约单表失败
     */
    public static final String RESP_CODE_INSERT_SUPSIGN_ERROR = "163093";
    /**
     * 写入供应商签约单日志失败
     */
    public static final String RESP_CODE_INSERT_SUPSIGN_LOG_ERROR = "163094";
    /**
     * 写入商品销售类品失败
     */
    public static final String RESP_CODE_INSERT_SPU_SALETYPE_ERROR = "163095";
    /**
     * 获取供应商签约单申请异常
     */
    public static final String RESP_CODE_CODE_SERIAL_NUMBER_ERROR = "163096";
    /**
     * 企业存在黑名单
     */
    public static final String ABILITY_RESP_CODE_BLACK_EXISTENCE_ERROR = "161054";
    /**
     * 请求登录机构信息不存在
     */
    public static final String RESP_CODE_ORG_NOT_FOUND_ERROR = "161001";
    /**
     * 该机构非有效机构
     */
    public static final String RESP_CODE_ORG_NOT_VALID_ERROR = "161002";
    /**
     * 用户名已存在
     */
    public static final String RESP_CODE_USER_NAME_EXISTE_ERROR = "161003";
    /**
     * 该手机号已被绑定
     */
    public static final String RESP_CODE_PHONE_NUMBER_EXISTES_ERROR = "161004";
    /**
     * 默认密码未配置
     */
    public static final String RESP_CODE_DEFAULT_PASSWORD_NOT_CONFIG_ERROR = "161005";
    /**
     * 华泊地址异常
     */
    public static final String RESP_CODE_HB_EMPTY_ERROR = "163006";
    /**
     * 不支持该操作类型
     */
    public static final String RESP_CODE_NOT_SUPPORT_ERROR = "161007";
    /**
     * 入参年度预算额金额转换失败
     */
    public static final String RESP_CODE_AMOUNT_CONVERT_ERROR = "163009";
    /**
     * 部门年度预算余额更新失败
     */
    public static final String RESP_CODE_UPDATE_BALANCE_ERROR = "163010";
    /**
     * 用户导入excel业务服务会员导入日志数据异常
     */
    public static final String RESP_CODE_IMPORT_EXCEL_EXCEPTION = "163456";
    /**
     * 权限读取失败
     */
    public static final Integer RESP_CODE_PERMISSION_READING_FAIL = 1;
    /**
     * 权限读取成功
     */
    public static final Integer RESP_CODE_PERMISSION_READING_SUCCESS = 0;

}
