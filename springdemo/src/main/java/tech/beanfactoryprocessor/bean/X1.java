package tech.beanfactoryprocessor.bean;

import org.springframework.stereotype.Component;

/**
 * @author liuzhifei
 * @date 2022/3/8 7:24 下午
 */
@Component
public class X1 implements X {

	private Y y;

	/**
	 * 当ignoreDependencyInterface X.class时，Y不会被自动注入，因为没有了set方法
	 */
	@Override
	public void setY(Y y) {
		this.y = y;
	}

	public void printY() {
		System.out.println("Y=" + y);
	}
}
