package cn.intellif.bucheng.common.configuration;


import cn.intellif.bucheng.common.annotation.EnableLoggerConfiguration;
import cn.intellif.bucheng.common.aop.PrintArgDetailAop;
import cn.intellif.bucheng.common.aop.TimeUseAop;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志打印控制
 */
@Configuration
@ConditionalOnBean(annotation = {EnableLoggerConfiguration.class})
public class LogPrintAutoConfig {

    @Bean
    public BeanPostProcessor beanPostProcessor(){
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                PrintArgDetailAop.open=true;
                TimeUseAop.open= true;
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                return bean;
            }
        };
    }
}
