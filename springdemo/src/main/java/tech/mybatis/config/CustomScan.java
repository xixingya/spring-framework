package tech.mybatis.config;

import org.springframework.context.annotation.Import;
import tech.mybatis.processor.CustomFactoryBeanDefinitionRegisterPostProcessor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liuzhifei
 * @date 2022/3/1 7:34 下午
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CustomFactoryBeanDefinitionRegisterPostProcessor.class)
public @interface CustomScan {
	String value();
}
