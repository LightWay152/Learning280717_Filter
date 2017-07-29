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
@WebFilter(urlPatterns={"/*"},
dispatcherTypes=DispatcherType.REQUEST)
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("Myfilter destroy");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter before");
		chain.doFilter(req, resp);
		System.out.println("doFilter after");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init filter");
	}

}
