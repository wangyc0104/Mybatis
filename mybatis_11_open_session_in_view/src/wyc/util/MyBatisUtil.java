package wyc.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis工具类
 * @author Yicheng Wang
 */
public class MyBatisUtil {

	// 单例模式
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从Session中获取SqlSession
	 */
	public static SqlSession getSession() {
		SqlSession session = tl.get();
		if (session == null) {
			tl.set(factory.openSession());
		}
		return tl.get();
	}

	/**
	 * 关闭SqlSession
	 */
	public static void closeSession() {
		SqlSession session = tl.get();
		if (session != null) {
			session.close();
		}
		tl.set(null);
	}
	
}
