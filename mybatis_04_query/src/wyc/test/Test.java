package wyc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 测试
 * @author Yicheng Wang
 */
public class Test {
	
	public static void main(String[] args) throws IOException {
		
		InputStream is = Resources.getResourceAsStream("myabtis.xml");
		
		// 基于构建者设计模式的工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		// 生产SqlSession
		SqlSession session = factory.openSession();
		
//		List<Flower> list = session.selectList("a.b.selAll");
//		for (Flower flower : list) {
//			System.out.println(flower.toString());
//		}
//		int count = session.selectOne("a.b.selById");
//		System.out.println(count);
		
		// 把数据库中哪个列的值当作map的key
		Map<Object, Object> map = session.selectMap("a.b.c", "name123");
		System.out.println(map);
		
		session.close();
		
	}
	
}
