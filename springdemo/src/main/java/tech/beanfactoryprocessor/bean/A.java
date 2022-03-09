package tech.beanfactoryprocessor.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuzhifei
 * @date 2022/3/7 7:31 下午
 */
@Component
public class A {


	B b;

	//这样子是可以装配成功的，半自动
	//@Autowired
	C c1;


	//这样子不成功
	//@Autowired
	//	C c;

	public void setB(B b) {
		this.b = b;
	}

	public void setC1(C c1) {
		this.c1 = c1;
	}

	public void printInfo(){
		System.out.println("bean b :"+b);
		System.out.println("bean c :"+c1);
	}
}
