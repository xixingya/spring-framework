package tech.beanfactoryprocessor.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.stereotype.Component;
import tech.beanfactoryprocessor.bean.B;

/**
 * @author liuzhifei
 * @date 2022/3/7 7:46 下午
 */
//@Component
public class TestIgnoreDependencyType implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		ScannedGenericBeanDefinition beanDefinition = (ScannedGenericBeanDefinition) beanFactory.getBeanDefinition("a");
		//设置A的自动注入模型为AUTOWIRE_BY_TYPE
		beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

		//设置所有自动注入的属性，如果类型为B，则忽略
		//说明@Autowired不属于自动注入
		beanFactory.ignoreDependencyType(B.class);
	}


}
