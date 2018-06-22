package cn.intellif.bucheng.common.configuration;


import cn.intellif.bucheng.common.annotation.EnablePrintLogger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志打印控制
 */
@Configuration
@ConditionalOnBean(annotation = {EnablePrintLogger.class})
public class LogPrintAutoConfig {

}
