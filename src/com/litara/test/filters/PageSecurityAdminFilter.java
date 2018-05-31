package com.litara.test.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.litara.test.entities.Passenger;

/**
 * Servlet Filter implementation class PageSecurityAdminFilter
 */
@WebFilter(urlPatterns= {"/admin","/jsp/admin/*"}, servletNames= {"Admin"}, 
initParams= {@WebInitParam(name="INDEX_PATH", value="/index.jsp")})
public class PageSecurityAdminFilter implements Filter {
	private String indexPath;
	private static final String PASS_ATTR="passenger";
    /**
     * Default constructor. 
     */
    public PageSecurityAdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Passenger passenger =(Passenger) req.getSession().getAttribute("passenger");
		if(passenger==null || passenger.getRole().equals("PASSENGER")) {
			System.out.println(passenger.getRole());
			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		indexPath=fConfig.getInitParameter("INDEX_PATH");
	}

}
