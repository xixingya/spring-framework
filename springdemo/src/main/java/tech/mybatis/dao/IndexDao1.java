package tech.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liuzhifei
 * @date 2022/3/1 7:25 下午
 */
public interface IndexDao1 {

    @Select("select * from test where id=IndexDao1")
    List<String> list();
}
