package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;

import eshop.entity.Customer;
import eshop.entity.EshopV10;

@WebServlet("/login.php")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie[] cookie =req.getCookies();
		if(cookie!=null){
			for(Cookie cki : cookie){
				String name = cki.getName();
				if(name.equals("uid")){
					String value = cki.getValue();
					System.out.println(value);
				}
			}
		}
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		String re = req.getParameter("remember");
		
		Session session = EshopV10.openSession();
		try {
			Customer user = (Customer) session.load(Customer.class, id);
			if (pw.equals(user.getPassword())) {
				req.setAttribute("message", "Login successfully");
				//kt đã dăng nhập hay chưa
				HttpSession session2 = req.getSession();
				session2.setAttribute("user", user);
				Cookie cookie = new Cookie("uid", id);
				Cookie cpw = new Cookie("cpw", pw);
				if(re!=null){
					cookie.setMaxAge(30*24*60*60);
					cpw.setMaxAge(30*24*60*60);
				}
				else {
					cookie.setMaxAge(0);//xóa cookie
					cpw.setMaxAge(0);
				}
				resp.addCookie(cookie);
				resp.addCookie(cpw);
			} else {
				req.setAttribute("message", "Wrong password");
			
			}
		} catch (Exception e) {
			req.setAttribute("message", "Invalid user");
		}
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}
