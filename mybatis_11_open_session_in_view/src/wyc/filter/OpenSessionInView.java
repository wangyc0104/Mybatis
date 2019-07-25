package wyc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

import wyc.util.MyBatisUtil;

/**
 * 对关联对象、属性进行延迟加载 <br>
 * 最开始是由Spring框架提出的 <br>
 * 整合Hibernate框架是使用的是OpenSessionInView <br>
 * @author Administrator
 */
@WebFilter("/*")
public class OpenSessionInView implements Filter {

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain) throws IOException, ServletException {
		// 将session的初始化代码在MyBatisUtil中进行封装
		SqlSession session = MyBatisUtil.getSession();
		try {
			filterchain.doFilter(servletrequest, servletresponse);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
	}

	@Override
	public void destroy() {}

}
