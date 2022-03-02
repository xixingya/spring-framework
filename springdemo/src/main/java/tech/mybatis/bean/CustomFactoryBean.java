package tech.mybatis.bean;

import org.springframework.beans.factory.FactoryBean;
import tech.mybatis.invoke.CustomSqlSession;

/**
 *
 * 1.xml 不行
 * 2.@Bean 不能动态注入
 * 3.beanDefinition 可以
 * @author liuzhifei
 * @date 2022/2/23 7:43 下午
 */
public class CustomFactoryBean implements FactoryBean<Object> {


	Class<?> mapperInterface;


	@Override
	public Object getObject() throws Exception {
		CustomSqlSession customSqlSession = new CustomSqlSession();
		return customSqlSession.getMapper(mapperInterface);
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}

	public void  setMapperInterface(Class<?> mapperInterface){
		this.mapperInterface = mapperInterface;
	}
}
