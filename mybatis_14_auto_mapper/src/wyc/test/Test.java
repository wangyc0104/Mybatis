package wyc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import wyc.pojo.Teacher;

/**
 * 测试
 * @author Yicheng Wang
 */
public class Test {
	public static void main(String[] args) throws IOException {
		// 初始化Session
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		// 查询
		List<Teacher> list = session.selectList("wyc.mapper.TeacherMapper.selAll");
		System.out.println(list);
		
		// 释放资源，结束程序
		session.close();
		System.out.println("程序执行结束");
	}
	
}
