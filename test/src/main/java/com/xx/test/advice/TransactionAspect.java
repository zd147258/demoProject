package com.xx.test.advice;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * 标题: TransactionAspect
 * 说明: 事务切面
 * 时间: 2021/12/20 14:22
 * @author 郑冬
 **/
@Aspect
@Configuration
@Order(-100) //优先级：负数优先级大于正数，数轴的执行顺序
public class TransactionAspect {

    /**
     * 定义切点路径
     */
    private static final String AOP_POINTCUT_EXPRESSION = "execution(* cn.ccccltd.*..service..*.*(..))";

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice() {

        /*事务管理规则，声明具备事务管理的方法名*/
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        /*只读事物、不做更新删除等*/
        /*当前存在事务就用当前的事务，当前不存在事务就创建一个新的事务*/
        RuleBasedTransactionAttribute readOnlyRule = new RuleBasedTransactionAttribute();
        /*设置当前事务是否为只读事务，true为只读*/
        readOnlyRule.setReadOnly(true);
        /* transactionDefinition 定义事务的隔离级别；
         * PROPAGATION_NOT_SUPPORTED事务传播级别5，以非事务运行，如果当前存在事务，则把当前事务挂起*/
        readOnlyRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
        RuleBasedTransactionAttribute requireRule = new RuleBasedTransactionAttribute();
        /*抛出异常后执行切点回滚*/
        requireRule.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Throwable.class)));
        /*PROPAGATION_REQUIRED:事务隔离性为1，若当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。 */
        requireRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        /*设置事务失效时间，如果超过N秒，则回滚事务*/
        requireRule.setTimeout(60);

        // 建立一个map，用来储存要需要进行事务管理的方法名（模糊匹配）
        Map<String, TransactionAttribute> txMap = new HashMap<>();
        txMap.put("create*", requireRule);
        txMap.put("register*", requireRule);
        txMap.put("update*", requireRule);
        txMap.put("delete*", requireRule);
        txMap.put("insert*", requireRule);
        txMap.put("add*", requireRule);
        txMap.put("modify*", requireRule);
        txMap.put("save*", requireRule);
        txMap.put("cancel*", requireRule);
        txMap.put("change*", requireRule);
        txMap.put("notify*", requireRule);
        txMap.put("break*", requireRule);
        txMap.put("marking*", requireRule);
        txMap.put("execute*", requireRule);
        txMap.put("process*", requireRule);
        txMap.put("set*", requireRule);
        txMap.put("record*", requireRule);
        txMap.put("log*", requireRule);
        txMap.put("deal*", requireRule);
        txMap.put("complete*", requireRule);
        txMap.put("approval*", requireRule);
        txMap.put("batch*", requireRule);
        txMap.put("audit*", requireRule);
        txMap.put("market*", requireRule);
        txMap.put("stop*", requireRule);
        txMap.put("on*", requireRule);
        txMap.put("truncate*", requireRule);
        txMap.put("edit*", requireRule);
        txMap.put("submit*", requireRule);

        txMap.put("query*", readOnlyRule);
        txMap.put("qry*", readOnlyRule);
        txMap.put("*", readOnlyRule);

        // 注入设置好的map
        source.setNameMap(txMap);
        // 实例化事务拦截器
        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        // 声明切点要切入的面
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        // 设置需要被拦截的路径
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        // 设置切面和配置好的事务管理
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }

    @Bean
    public TransactionInterceptor nonTxAdvice() {
        /*事务管理规则，声明具备事务管理的方法名*/
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        /*只读事物、不做更新删除等*/
        /*当前存在事务就用当前的事务，当前不存在事务就创建一个新的事务*/
        RuleBasedTransactionAttribute readOnlyRule = new RuleBasedTransactionAttribute();
        /*设置当前事务是否为只读事务，true为只读*/
        readOnlyRule.setReadOnly(true);
        /* transactionDefinition 定义事务的隔离级别；
        PROPAGATION_NOT_SUPPORTED事务传播级别5，以非事务运行，如果当前存在事务，则把当前事务挂起*/
        readOnlyRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
        Map<String, TransactionAttribute> txMap = new HashMap<>(4);
        txMap.put("*", readOnlyRule);
        source.setNameMap(txMap);
        return new TransactionInterceptor(transactionManager, source);
    }
}

