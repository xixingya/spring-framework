package tech.mybatis.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tech.mybatis.config.AppConfig;
import tech.mybatis.dao.IndexDao;
import tech.mybatis.dao.IndexDao1;

/**
 * @author liuzhifei
 * @date 2022/2/23 7:55 下午
 */
public class Test {

	public static void main(String[] args) {
		try{
			System.out.println("aaa");
			final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			IndexDao bean = context.getBean("IndexDao", IndexDao.class);
			IndexDao1 bean2 = context.getBean("IndexDao1", IndexDao1.class);
			bean.list();
			bean2.list();
		}catch (Exception e){
			e.printStackTrace();
		}

		//System.out.println(bean);

	}
}
