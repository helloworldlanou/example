package util.encode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		  
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
        String requesturi = req.getRequestURI();

        
		//  //System.out.println(((HttpServletRequest) request).getRequestURI());   
		// 从session里取的用户名信息   
		
		// 判断如果没有取到用户信息,就跳转到登陆页面   
		if (session.getAttribute("person")==null&& !requesturi.endsWith("/index.jsp")
				&& !requesturi.endsWith("/loginAction.do")
				&& !requesturi.endsWith("/mainAction.do")
				&& !requesturi.endsWith("/enAction.do")
				&& !requesturi.endsWith(req.getContextPath()
                        + "/")
		)
		{
			// 跳转到登陆页面   
			//System.out.println("requesturi=="+requesturi);
			//dispatcher.forward(request, response);
			PrintWriter out = res.getWriter();   
			out.write("<script>window.parent.parent.location.href='manage.jsp'</script>");   
			//System.out.println("用户没有登陆，不允许操作");   

		} else {
			// 已经登陆,继续此次请求   
			chain.doFilter(request, response);
			   //System.out.println("用户已经登陆，允许操作");   
		}
	}

	public void destroy() {

	}
}
