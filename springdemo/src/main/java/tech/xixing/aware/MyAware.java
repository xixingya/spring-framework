package tech.xixing.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuzhifei
 * @version 1.0
 * @date 2021/11/15 8:07 PM
 */
@Configuration
public class MyAware implements ApplicationContextAware, BeanNameAware {

	private ApplicationContext applicationContext;
	private String beanName;

	public void print(){
		System.out.println("I am "+beanName);
		final String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println("beanDefinitionName: "+beanDefinitionName);
		}
	}
	@Override
	public void setBeanName(String name) {
		this.beanName =name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext =applicationContext;
	}
}
