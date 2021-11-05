package tech.xixing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import tech.xixing.service.WelcomeService;

/**
 * @author liuzhifei
 * @version 1.0
 * @date 2021/11/3 7:46 PM
 */
@ComponentScan("tech.xixing")
@Configuration
public class Entrance {

	public static void main1(String[] args) {
		String path = "//Users/liuzhifei/workspace/sourcecode/my/spring-framework/springdemo/src/main/resources/spring/spring-config.xml";
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(path);
		WelcomeService welcomeService =(WelcomeService) context.getBean("welcomeService");
		welcomeService.sayHello("aaa");


	}

	public static void main(String[] args){
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Entrance.class);
		final String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
		WelcomeService welcomeService =  context.getBean(WelcomeService.class);
		welcomeService.sayHello("aaa");
	}
}
