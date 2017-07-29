package web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scope.php")
public class ScopeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			req.setAttribute("a", 2017);
			
			HttpSession session = req.getSession();
			session.setAttribute("b", 2018);
			
			ServletContext application = req.getServletContext();
			application.setAttribute("c", 2019);
			
			req.getRequestDispatcher("scope.jsp").forward(req, resp);
	}
}
