package wyc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import wyc.pojo.Flower;

/**
 * 测试Mybatis
 * @author Yicheng Wang
 */
public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("myabtis.xml");
		// 使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		// 生产SqlSession
		SqlSession session = factory.openSession();
		// 此处实际上就是mybatis.xml中的namespace所定位的查询
		List<Flower> list = session.selectList("a.b.selAll");
		for (Flower flower : list) {
			System.out.println(flower.toString());
		}
		session.close();
	}
}
