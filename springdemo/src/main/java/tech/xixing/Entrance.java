package tech.xixing;

import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.CollectionFactory;
import tech.xixing.aware.MyAware;
import tech.xixing.entity.Man;
import tech.xixing.entity.User;
import tech.xixing.service.WelcomeService;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liuzhifei
 * @version 1.0
 * @date 2021/11/3 7:46 PM
 */
@ComponentScan("tech.xixing.entity")
@Configuration
public class Entrance {

	public static void main1(String[] args) {
		String path = "//Users/liuzhifei/workspace/sourcecode/my/spring-framework/springdemo/src/main/resources/spring/spring-config.xml";
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(path);
		WelcomeService welcomeService =(WelcomeService) context.getBean("welcomeService");
		welcomeService.sayHello("aaa");


	}

	public static void main(String[] args){
//		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Entrance.class);
//		final String[] beanDefinitionNames = context.getBeanDefinitionNames();
//		for (String beanDefinitionName : beanDefinitionNames) {
//			System.out.println(beanDefinitionName);
//		}
		ManagedList<RuntimeBeanReference> myCommandHandler = Stream.of(new RuntimeBeanReference("myCommandHandler")).collect(Collectors.toCollection(ManagedList::new));

		ManagedList<RuntimeBeanReference> aaa = getSingletonCollection(new RuntimeBeanReference("aaa"), ManagedList::new);

		System.out.println(aaa);
//		WelcomeService welcomeService =  context.getBean(WelcomeService.class);
//		welcomeService.sayHello("aaa");
//		final MyAware bean = context.getBean(MyAware.class);
//		bean.print();
//		final User user5 = context.getBean("user5", User.class);
//		System.out.println(user5);
	}

	public static void main3(String[] args){
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Man.class);
		context.register(User.class);
		context.refresh();
	}

	public static <T, C extends Collection<T>> C getSingletonCollection(T t, Supplier<C> supplier) {
		final C apply = supplier.get();
		apply.add(t);
		return apply;
	}

}
