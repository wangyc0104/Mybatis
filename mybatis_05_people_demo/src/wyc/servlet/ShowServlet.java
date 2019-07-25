package wyc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wyc.pojo.People;
import wyc.service.PeopleService;
import wyc.service.impl.PeopleServiceImpl;

/**
 * 人的Servlet <br>
 * 补充关于注解的一点小知识：<br>
 * 1.大部分注解都有默认属性，如果注解中只给默认属性赋值，可以省略属性名 <br>
 * 2.如果使用注解的非默认属性，必须遵照@xxxAnnotation(xxxProperty = xxxValue)格式 <br>
 * 3.如果一个属性是数组类型格式: 属性名={值,值} ,如果该数组只有一个值,可以省略大括号 <br>
 * 4.如果类是不是基本数据类型或String而是一个类类型,语法: 属性名=@类型 <br>
 * 5.注解中@表示引用注解声明 <br>
 * @author Yicheng Wang
 */
@SuppressWarnings("serial")
@WebServlet("/abc/b/show")
public class ShowServlet extends HttpServlet {

	private PeopleService peopleService = new PeopleServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<People> list = peopleService.show();
		req.setAttribute("list", list);
		// 【关于相对路径、绝对路径的一点说明】
		// 只要路径中以/开头的都叫做全路径，即从项目根目录(WebContent)出发找到其他资源的过程；
		// 只要不以“/”开头都是相对路径，相对路径是从当前资源出发找到其他资源的过程；
		// 如果请求转发，“/”表示WebContent目录
		// 如果是重定向，静态资源引用，<img src=""/>，<a href="">，<script src=""/>，css引用时，其中“/”都表示的是tomcat的webapps文件夹根目录
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
}
