package web.servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HitCounterController extends HttpServlet {
	int counter = 0;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		counter++;
		req.setAttribute("counter", counter);
		System.out.println("service()");
		req.getRequestDispatcher("hit-counter.jsp").forward(req, resp);

	}

	@Override
	public void init() throws ServletException {
		System.out.println("init");
		String path = "C:/temp/hit.txt";
		try {
			FileInputStream fis = new FileInputStream(path);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			fis.close();
			counter = Integer.parseInt(new String(data));
			System.out.println("Read file successfully!");
		} catch (Exception e) {
			System.out.println("Read file failed!");
		}

	}

	@Override
	public void destroy() {

		System.out.println("destroy");
		String path = "C:/temp/hit.txt";
		try {
			FileOutputStream fos = new FileOutputStream(path);
			byte[] data = String.valueOf(counter).getBytes();
			fos.write(data);
			fos.close();
			System.out.println("Write file successfully!");

		} catch (Exception e) {
			System.out.println("Write file failed!");
		}

	}
}
