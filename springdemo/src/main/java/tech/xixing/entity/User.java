package tech.xixing.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuzhifei
 * @version 1.0
 * @date 2021/11/15 7:32 PM
 */
@Component
public class User {

	@Autowired
	private Man man;


	public User(){
		System.out.println("user create");
	}
}
