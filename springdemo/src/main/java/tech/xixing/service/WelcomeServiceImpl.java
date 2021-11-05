package tech.xixing.service;

import org.springframework.stereotype.Service;

/**
 * @author liuzhifei
 * @version 1.0
 * @date 2021/11/4 7:30 PM
 */
@Service
public class WelcomeServiceImpl implements WelcomeService{
	@Override
	public String sayHello(String name) {
		System.out.println("欢迎你："+name);
		return "success";
	}
}
