package tech.beanfactoryprocessor.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.stereotype.Component;
import tech.beanfactoryprocessor.bean.B;
import tech.beanfactoryprocessor.bean.C;
import tech.beanfactoryprocessor.bean.X;

/**
 * @author liuzhifei
 * @date 2022/3/8 7:06 下午
 */
@Component
public class TestIgnoreDependencyInterface implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		ScannedGenericBeanDefinition beanDefinition = (ScannedGenericBeanDefinition) beanFactory.getBeanDefinition("a");
		//设置A的自动注入模型为AUTOWIRE_BY_TYPE
		beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);

		//这样子是不能忽略的，下面才是这个类的真正用法
		beanFactory.ignoreDependencyInterface(C.class);


		ScannedGenericBeanDefinition beanDefinitionX = (ScannedGenericBeanDefinition) beanFactory.getBeanDefinition("x1");
		//设置A的自动注入模型为AUTOWIRE_BY_NAME
		beanDefinitionX.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);
		beanFactory.ignoreDependencyInterface(X.class);

		/**
		 * 为什么要有这个类，原因是，某些特殊的类，spring需要忽略掉自动注入，
		 * 在某些特殊代码中进行注入，比如说{@link tech.beanfactoryprocessor.bean.Z} 类，
		 * 实现了ApplicationAware则，需要忽略自动注入，不能自动注入ApplicationContext
		 *
		 * prepareBeanFactory(beanFactory);
		 *
		 * 		beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
		 * 		beanFactory.ignoreDependencyInterface(EnvironmentAware.class);
		 * 		beanFactory.ignoreDependencyInterface(EmbeddedValueResolverAware.class);
		 * 		beanFactory.ignoreDependencyInterface(ResourceLoaderAware.class);
		 * 		beanFactory.ignoreDependencyInterface(ApplicationEventPublisherAware.class);
		 * 		beanFactory.ignoreDependencyInterface(MessageSourceAware.class);
		 * 		beanFactory.ignoreDependencyInterface(ApplicationContextAware.class);
		 */
	}
}
