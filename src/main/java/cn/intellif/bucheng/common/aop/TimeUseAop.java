package cn.intellif.bucheng.common.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class TimeUseAop{

    private Logger logger = Logger.getLogger(TimeUseAop.class);


    @Pointcut("@annotation(cn.intellif.bucheng.common.annotation.PrintMethodTime)")
    private void testAop(){}

    @Around("testAop()")
    public Object printTime(ProceedingJoinPoint joinPoint){
        try {
            long startTime = System.currentTimeMillis();
            Object tagert = joinPoint.getTarget();
            Signature signature = joinPoint.getSignature();
            StringBuilder sb = new StringBuilder();
            if (signature instanceof MethodSignature) {
                MethodSignature ms = (MethodSignature) signature;
                Method method = ms.getMethod();
                sb.append(method.getDeclaringClass().getName()+":"+method.getName()).append("方法");
            }
           Object result =  joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            sb.append(" 用时 ").append((endTime - startTime)).append("ms").append("=").append((endTime-startTime)/1000).append("s");
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sb.toString());
            return result;
        }catch (Throwable e){
            throw new RuntimeException(e);
        }
    }
}
