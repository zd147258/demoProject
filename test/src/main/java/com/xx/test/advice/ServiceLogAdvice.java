package com.xx.test.advice;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.xx.test.base.Exception.ZTBusinessException;
import com.xx.test.base.page.RspPage;
import com.xx.test.bo.RspBaseBO;
import com.xx.test.constant.BaseRspConstants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;

/**
 * 标题: ServiceLogAdvice
 * 说明: 服务日志切面
 * 时间: 2021/12/20 14:14
 * @author 郑冬
 **/
@Aspect
@Component
@Order(value = 20)
public class ServiceLogAdvice {
    private static final Logger log = LoggerFactory.getLogger(ServiceLogAdvice.class);
    /**
     * 分隔符
     */
    private static final String SEPARATOR = "|";
    /**
     * 类与方法名的连接符
     */
    private static final String CLASS_METHOD_SEPARATOR = ".";
    /**
     * 调用链表示
     */
    private static final String TRACE_IDENTIFICATION = "TRACE_ID";
    /**
     * 开始标识
     */
    private static final String START_IDENTIFICATION = "START";
    /**
     * 异常标识
     */
    private static final String ERROR_IDENTIFICATION = "ERROR";
    /**
     * 结束标识
     */
    private static final String END_IDENTIFICATION = "END";

    private static final String VOID_NM = "void";

    /**
     * 线程全局map，线程生命周期内始终存在
     */
    private static final InheritableThreadLocal<Map<String, String>> THREAD_MAP = new InheritableThreadLocal<>();

    /**
     * 切点
     */
    @Pointcut("(execution(* com.xx.*..service.impl..*.*(..)))" +
            " || (execution(* com.xx.*..atom.impl..*.*(..)))")
    public void pointCut() {
    }

    @Pointcut("(execution(* com.xx.*..service.impl..*.*(..)))")
    public void abilityPointCut() {
    }

    /**
     * 前置通知
     */
    @Before("pointCut()")
    public void deBefore(JoinPoint jp) {
        log.info("前置通知");
        if (THREAD_MAP.get() == null) {
            //设置线程全局map
            Map<String, String> mapInfo = Maps.newHashMapWithExpectedSize(2);
            UUID uuid = UUID.randomUUID();
            System.out.println("uuid:" + uuid);
            mapInfo.put(TRACE_IDENTIFICATION, uuid.toString().replace("-", ""));
            System.out.println("mapinfo:" + JSON.toJSONString(mapInfo));
            mapInfo.put(START_IDENTIFICATION, Long.toString(System.currentTimeMillis()));
            System.out.println("mapinfo:" + JSON.toJSONString(mapInfo));
            THREAD_MAP.set(mapInfo);
        }

        String[] infos = new String[3];
        infos[0] = getLogHeadInfo(jp);
        // 添加开始标识
        infos[1] = START_IDENTIFICATION;
        // 入参
        Object[] params = jp.getArgs();
        if (params != null && params.length > 0) {
            if (params.length == 1) {
                // 请求报文
                try {
                    infos[2] = JSON.toJSONString(params[0]);
                } catch (Exception e) {
                    infos[2] = params[0].toString();
                }

            } else {
                StringBuilder paramsStr = new StringBuilder();
                paramsStr.append("[");
                for (Object obj : params) {
                    String objStr = null;
                    if (obj != null) {
                        objStr = JSON.toJSONString(obj);
                    }
                    paramsStr.append(objStr);
                    paramsStr.append(",");
                }
                paramsStr.setLength(paramsStr.length() - 1);
                paramsStr.append("]");
                infos[2] = paramsStr.toString();
            }
        }
        // 打印接口服务请求日志
        log.info("打印接口服务请求日志:" + getLogInfoByStrings(infos));
    }

    /**
     * 环绕通知
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        log.info("环绕通知");
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        Class<?> rspClass = method.getReturnType();

        Object rspObj = null;
        try {
            rspObj = pjp.proceed();
        } catch (ZTBusinessException e) {
            if (!VOID_NM.equals(rspClass.getSimpleName())) {
                rspObj = rspClass.newInstance();
            }
            String msgCode = e.resolverExceptionCode();
            String desc = e.getMessage();

            if (!StringUtils.hasText(msgCode)) {
                msgCode = BaseRspConstants.RSP_CODE_FAILD;
            }
            if (!StringUtils.hasText(desc)) {
                desc = BaseRspConstants.RSP_DESC_FAILD;
            }
            log.info("环绕1");
            printAopErrorLog(e, "业务调用失败原因：", pjp);
            this.putCodeToRsp(rspObj, msgCode, desc);
        } catch (DataAccessException e) {
            if (!VOID_NM.equals(rspClass.getSimpleName())) {
                rspObj = rspClass.newInstance();
            }
            log.info("环绕2");
            printAopErrorLog(e, "数据异常信息：", pjp);
            this.putCodeToRsp(rspObj, BaseRspConstants.RSP_CODE_DbErrorOccurred, "数据异常:" + e.getCause().getMessage());
        } catch (Throwable e) {
            if (!VOID_NM.equals(rspClass.getSimpleName())) {
                rspObj = rspClass.newInstance();
            }
            log.info("环绕3");
            printAopErrorLog(e, "服务调用异常信息：", pjp);
            this.putCodeToRsp(rspObj, BaseRspConstants.RSP_CODE_ERROR, BaseRspConstants.RSP_DESC_ERROR + ":" + e.getMessage());
        }

        return rspObj;
    }

    /**
     * 后置返回通知，方法正常返回后执行
     */
    @AfterReturning(returning = "rspObj", pointcut = "pointCut() && abilityPointCut()")
    public void doAfterCall(JoinPoint jp, Object rspObj) {
        log.info("后置返回通知，方法正常返回后执行");
        //打印日志
        doAfterReturning(jp, rspObj);
        //每次调用返回后初始化全局参数
        THREAD_MAP.remove();
    }

    /**
     * 后置返回通知，方法正常返回后执行
     */
    @AfterReturning(returning = "rspObj", pointcut = "pointCut() && !abilityPointCut()")
    public void doAfterReturning(JoinPoint jp, Object rspObj) {
        log.info("后置返回通知，方法正常返回后执行");
        String[] infos = new String[5];
        infos[0] = getLogHeadInfo(jp);
        long nowTime = System.currentTimeMillis();
        // 修改标识为结束标识
        infos[1] = END_IDENTIFICATION;
        if (rspObj instanceof RspPage) {
            RspPage resp = (RspPage) rspObj;
            if (log.isDebugEnabled()) {
                //debug级别打印全部出参
                infos[2] = JSON.toJSONString(rspObj);
            } else {
                infos[2] = resp.getCode();
                infos[3] = resp.getMessage();
            }
            try {
                infos[4] = "用时：" + (nowTime - Long.parseLong(THREAD_MAP.get().get(START_IDENTIFICATION)) + "ms");
            } catch (NullPointerException e) {
                infos[4] = "用时： ? ms";
            }

        } else if (rspObj instanceof RspBaseBO) {
            RspBaseBO resp = (RspBaseBO) rspObj;
            if (log.isDebugEnabled()) {
                //debug级别打印全部出参
                infos[2] = JSON.toJSONString(rspObj);
            } else {
                infos[2] = resp.getCode();
                infos[3] = resp.getMessage();
            }
            try {
                infos[4] = "用时：" + (nowTime - Long.parseLong(THREAD_MAP.get().get(START_IDENTIFICATION)) + "ms");
            } catch (NullPointerException e) {
                infos[4] = "用时： ? ms";
            }

        }
        // 打印接口服务结束日志
        log.info(getLogInfoByStrings(infos));
    }

    /**
     * 后置异常通知，方法异常时执行
     */
    @AfterThrowing(throwing = "ex", pointcut = "pointCut()")
    public void doAfterThrowing(JoinPoint jp, Throwable ex) {
        log.info("后置异常通知，方法异常时执行");
        printAopErrorLog(ex, "环绕通知异常信息：", jp);
    }

    /**
     * 获取日志头信息
     */
    private String getLogHeadInfo(JoinPoint jp) {
        log.info("获取日志头信息");
        // 添加调用链traceId
        StringBuilder logHead;
        try {
            logHead = new StringBuilder(THREAD_MAP.get().get(TRACE_IDENTIFICATION) + SEPARATOR);
        } catch (NullPointerException e) {
            logHead = new StringBuilder(" ? " + SEPARATOR);
        }

        // 获取目标对象对应的类名
        String className = jp.getTarget().getClass().getName();
        // 获取目标对象上正在执行的方法名
        String methodString = jp.getSignature().getName();
        // 添加类名.方法名
        logHead.append(className);
        logHead.append(CLASS_METHOD_SEPARATOR);
        logHead.append(methodString);
        log.info("logHead:{}", logHead.toString());
        return logHead.toString();
    }

    /**
     * 转换日志信息
     */
    private String getLogInfoByStrings(String[] infos) {
        log.info("转换日志信息");
        StringBuilder str = new StringBuilder();
        for (String info : infos) {
            if (!StringUtils.hasText(info)) {
                info = "";
            }
            str.append(info).append(SEPARATOR);
        }
        if (str.length() > 1) {
            str.setLength(str.length() - 1);
        }
        return str.toString();
    }

    /**
     * 打印错误日志
     */
    private void printAopErrorLog(Throwable e, String desc, JoinPoint jp) {
        log.info("打印错误日志");
        String[] infos = new String[3];
        infos[0] = getLogHeadInfo(jp);
        // 修改标识为结束标识
        infos[1] = ERROR_IDENTIFICATION;
        // 异常信息
        infos[2] = desc + e.getMessage();
        // 打印接口服务异常日志
        log.error(getLogInfoByStrings(infos), e);
    }

    /**
     * 出参赋值
     */
    private void putCodeToRsp(Object object, String code, String desc) throws NoSuchFieldException, IllegalAccessException {
        log.info("出参赋值");
        if (object instanceof RspPage) {
            Field field = RspPage.class.getSuperclass().getDeclaredField("code");
            // 如果业务中已经加入的返回值，则不予以赋值
            field.setAccessible(true);
            if (field.get(object) == null) {
                field.set(object, code);
                field = RspPage.class.getSuperclass().getDeclaredField("message");
                field.setAccessible(true);
                field.set(object, desc);
            }
        } else if (object instanceof RspBaseBO) {
            Field field = RspBaseBO.class.getDeclaredField("code");
            log.info("field:" + field);
            // 如果业务中已经加入的返回值，则不予以赋值
            field.setAccessible(true);
            if (field.get(object) == null) {
                field.set(object, code);
                field = RspBaseBO.class.getDeclaredField("message");
                field.setAccessible(true);
                field.set(object, desc);
            }
        } else {
            try {
                Field field = object.getClass().getDeclaredField("code");
                field.setAccessible(true);
                if (field.get(object) == null) {
                    field.set(object, code);
                    field = object.getClass().getDeclaredField("message");
                    field.setAccessible(true);
                    field.set(object, desc);
                }
            } catch (Exception ignored) {
            }
        }
    }

}
