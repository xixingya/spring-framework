package tech.beanfactoryprocessor.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tech.beanfactoryprocessor.bean.A;
import tech.beanfactoryprocessor.bean.X1;

/**
 * @author liuzhifei
 * @date 2022/3/7 7:33 下午
 */

@Configuration
@ComponentScan(value = "tech.beanfactoryprocessor")
public class Test {

	public static void main(String[] args) {
		try{
			AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(Test.class);
			context.getBean(A.class).printInfo();
			context.getBean(X1.class).printY();
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}
