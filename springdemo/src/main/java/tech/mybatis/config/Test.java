package tech.mybatis.config;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import tech.mybatis.dao.IndexDao;

import javax.sql.DataSource;

/**
 * @author liuzhifei
 * @date 2022/2/17 8:02 下午
 */
public class Test {

	public static void main(String[] args) {
		DataSource dataSource = null;
		TransactionFactory transactionFactory =
				null;
		Environment environment =
				new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(IndexDao.class);
		configuration.addMapper(IndexDao.class);
		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(configuration);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		IndexDao mapper = sqlSession.getMapper(IndexDao.class);


	}
}
