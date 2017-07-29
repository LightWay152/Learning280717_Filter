package web.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import eshop.entity.EshopV10;
import eshop.entity.HitCounter;

@WebFilter(urlPatterns = { "/*" }, 
dispatcherTypes = DispatcherType.REQUEST)
public class HitCounterFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;		
		Session session = EshopV10.openSession();
		String url = request.getRequestURI();
		Transaction t = session.beginTransaction();
		try {
			try {
				HitCounter h = (HitCounter) session.get(HitCounter.class, url);
				h.setClicks(h.getClicks() + 1);
				session.update(h);
			} catch (Exception e) {
				HitCounter entity = new HitCounter();
				entity.setUrl(url);
				entity.setClicks(1);
				session.save(entity);
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
