package wyc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wyc.service.LogService;
import wyc.service.impl.LogServiceImpl;

/**
 * 查看日志Servlet
 * @author Yicheng Wang
 */
@SuppressWarnings("serial")
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	
	private LogService logService = new LogServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 如果没有设置分页信息，则设置默认分页配置
		int pageSize = 2;
		String pageSizeStr = req.getParameter("pageSize");
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		String pageNumberStr = req.getParameter("pageNumber");
		if (pageNumberStr != null && !pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		// 返回数据并转发
		req.setAttribute("pageinfo", logService.showPage(pageSize, pageNumber));
		req.getRequestDispatcher("/log.jsp").forward(req, resp);
	}
	
}
