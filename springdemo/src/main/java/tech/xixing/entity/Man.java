package tech.xixing.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Man {

	@Autowired
	private User user;

	public Man(){
		System.out.println("man create");
	}
}
