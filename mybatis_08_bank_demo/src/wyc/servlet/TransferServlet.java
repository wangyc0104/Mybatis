package wyc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wyc.pojo.Account;
import wyc.service.AccountService;
import wyc.service.impl.AccountServiceImpl;

/**
 * 转账操作Servlet（事务在AccountServiceImpl中进行编程）
 * @author Yicheng Wang
 */
@SuppressWarnings("serial")
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {

	private AccountService accService = new AccountServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Account accOut = new Account();
		accOut.setAccNo(req.getParameter("accOutAccNo"));
		accOut.setPassword(Integer.parseInt(req.getParameter("accOutPassword")));
		accOut.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
		Account accIn = new Account();
		accIn.setAccNo(req.getParameter("accInAccNo"));
		accIn.setName(req.getParameter("accInName"));
		int index = accService.transfer(accIn, accOut);
		if (index == AccountService.SUCCESS) {
			resp.sendRedirect("/bank/show");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("code", index);
			resp.sendRedirect("/bank/error/error.jsp");
		}

	}
}
