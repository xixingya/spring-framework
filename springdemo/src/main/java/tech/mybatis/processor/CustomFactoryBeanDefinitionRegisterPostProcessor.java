package tech.mybatis.processor;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;
import tech.mybatis.bean.CustomFactoryBean;
import tech.mybatis.dao.IndexDao;
import tech.mybatis.dao.IndexDao1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhifei
 * @date 2022/3/1 7:04 下午
 */
@Component
public class CustomFactoryBeanDefinitionRegisterPostProcessor implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		List<Class<?>> list =new ArrayList<>();
		list.add(IndexDao.class);
		list.add(IndexDao1.class);
		for (Class<?> aClass : list) {
			BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(CustomFactoryBean.class);
			AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
			//添加属性值
			beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", aClass);
			registry.registerBeanDefinition(aClass.getSimpleName(),beanDefinition);
		}

		ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry);
	}
}
