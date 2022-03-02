package tech.mybatis.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * 通过jdk动态代理生成的真正的对象
 * @author liuzhifei
 * @date 2022/2/17 7:35 下午
 */
public interface IndexDao {

	@Select("select * from test")
	List<String> list();

}
