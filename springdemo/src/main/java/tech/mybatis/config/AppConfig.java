package tech.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import tech.mybatis.processor.CustomFactoryBeanDefinitionRegisterPostProcessor;

/**
 * @author liuzhifei
 * @date 2022/2/17 7:36 下午
 */
@Configuration
@ComponentScan(value = "tech.mybatis")
@Import(CustomFactoryBeanDefinitionRegisterPostProcessor.class)
//@ImportResource("classpath:spring/spring-config.xml")
@MapperScan
public class AppConfig {
}
