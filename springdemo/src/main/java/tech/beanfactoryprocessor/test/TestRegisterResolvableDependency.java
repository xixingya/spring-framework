package tech.beanfactoryprocessor.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import tech.beanfactoryprocessor.bean.C;
import tech.beanfactoryprocessor.bean.C1;

/**
 * @author liuzhifei
 * @date 2022/3/9 7:13 下午
 */
public class TestRegisterResolvableDependency implements BeanFactoryPostProcessor {

	public C1 c1 =new C1();

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//表示只有遇到需要注入C类型的依赖时，把c1赋值给它
		beanFactory.registerResolvableDependency(C.class,c1);

		/**
		 * Spring 源码中的使用
		 * {@link org.springframework.context.annotation.AnnotationConfigApplicationContext#prepareBeanFactory(ConfigurableListableBeanFactory)}
		 */
		/*
		 * beanFactory.registerResolvableDependency(BeanFactory.class, beanFactory);
		 * 		beanFactory.registerResolvableDependency(ResourceLoader.class, this);
		 * 		beanFactory.registerResolvableDependency(ApplicationEventPublisher.class, this);
		 * 		beanFactory.registerResolvableDependency(ApplicationContext.class, this);
		 */

	}
}
