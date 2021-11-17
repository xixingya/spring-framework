package tech.xixing.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuzhifei
 * @version 1.0
 * @date 2021/11/15 7:38 PM
 */
@Configuration
public class CustomizedBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName+"调用了postProcessBeforeInitialization()");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName+"postProcessAfterInitialization()");
		return bean;
	}
}
