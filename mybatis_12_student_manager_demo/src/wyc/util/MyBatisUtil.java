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
	
	/*
	 * 单例处理
	 */
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取SqlSession对象
	 * @return 当前线程ThreadLocal下的单例SqlSession对象
	 */
	public static SqlSession getSession() {
		SqlSession session = tl.get();
		if (session == null) {
			tl.set(factory.openSession());
		}
		return tl.get();
	}

	/**
	 * 关闭资源
	 */
	public static void closeSession() {
		SqlSession session = tl.get();
		if (session != null) {
			session.close();
		}
		tl.set(null);
	}
	
}
