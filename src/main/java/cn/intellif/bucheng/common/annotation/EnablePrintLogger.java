package cn.intellif.bucheng.common.annotation;

import cn.intellif.bucheng.common.aop.PrintArgDetailAop;
import cn.intellif.bucheng.common.aop.TimeUseAop;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({PrintArgDetailAop.class, TimeUseAop.class})
public @interface EnablePrintLogger {
}
