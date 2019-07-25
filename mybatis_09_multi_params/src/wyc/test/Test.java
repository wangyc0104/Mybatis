package wyc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import wyc.mapper.LogMapper;
import wyc.pojo.Log;

/**
 * 测试
 * @author Yicheng Wang
 */
public class Test {
	
	public static void main(String[] args) throws IOException {
		
		//初始化session
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();

		/**
		 * 使用的JDK的动态代理设计模式进行接口实例化 <br>
		 * 面向接口的代理设计模式(必须有接口) <br>
		 */
		LogMapper logMapper1 = session.getMapper(LogMapper.class);
		List<Log> list1 = logMapper1.selAll();
		for (Log log : list1) {
			System.out.println(log);
		}

		LogMapper logMapper2 = session.getMapper(LogMapper.class);
		List<Log> list2 = logMapper2.selByAccInAccout("3", "1");
		for (Log log : list2) {
			System.out.println(log);
		}

		session.close();
		System.out.println("程序执行结束");
	}
	
}
