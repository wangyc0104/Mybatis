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
 * 
 * @author Yicheng Wang
 */
public class Test {
	public static void main(String[] args) throws IOException {
		// 初始化Session
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		// 查询学生列表
		List<Teacher> list = session.selectList("wyc.mapper.TeacherMapper.selAll1");
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}
		System.out.println(list);
		// 关闭资源
		session.close();
		System.out.println("程序执行结束");
	}
}
