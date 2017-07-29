package web.listener;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class AppListener implements HttpSessionListener , ServletContextListener {
	int visitor = 0;
	@Override
	public void sessionCreated(HttpSessionEvent e) {
		visitor++;
		ServletContext app = e.getSession().getServletContext();
		app.setAttribute("visitor", visitor);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		String path = "C:/temp/visitor.txt";
		try {
			FileOutputStream fos = new FileOutputStream(path);
			byte[] data = String.valueOf(visitor).getBytes();
			fos.write(data);
			fos.close();
			System.out.println("Write file successfully!");

		} catch (Exception e) {
			System.out.println("Write file failed!");
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		String path = "C:/temp/visitor.txt";
		try {
			FileInputStream fis = new FileInputStream(path);
			byte[] data = new byte[fis.available()];
			fis.read(data);
			fis.close();
			visitor = Integer.parseInt(new String(data));
			System.out.println("Read file successfully!");
		} catch (Exception e) {
			System.out.println("Read file failed!");
		}
	}

}
