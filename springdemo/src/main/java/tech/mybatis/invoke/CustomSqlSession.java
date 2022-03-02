package tech.mybatis.invoke;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liuzhifei
 * @date 2022/2/23 7:33 下午
 */
public class CustomSqlSession {

	public Object getMapper(Class<?> clazz){


		return Proxy.newProxyInstance(CustomSqlSession.class.getClassLoader(),new Class<?>[]{clazz},
				new CustomInvokeHandler());



	}
	static class CustomInvokeHandler implements InvocationHandler{

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if(method.isAnnotationPresent(Select.class)){
				Select select = method.getAnnotation(Select.class);
				String sql = select.value()[0];
				System.out.println("sql exec "+sql);
			}

			return null;
		}
	}
}
