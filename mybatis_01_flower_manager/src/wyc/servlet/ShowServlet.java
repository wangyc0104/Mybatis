package wyc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wyc.pojo.Flower;
import wyc.service.FlowerService;
import wyc.service.impl.FlowerServiceImpl;

/**
 * 展示花卉信息Servlet
 * @author Yicheng Wang
 */
@SuppressWarnings("serial")
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	
	private FlowerService flowerService = new FlowerServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Flower> list = flowerService.show();
		req.setAttribute("list", list);
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
	
}
