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
		// ��session��ȡ���û�����Ϣ   
		
		// �ж����û��ȡ���û���Ϣ,����ת����½ҳ��   
		if (session.getAttribute("person")==null&& !requesturi.endsWith("/index.jsp")
				&& !requesturi.endsWith("/loginAction.do")
				&& !requesturi.endsWith("/mainAction.do")
				&& !requesturi.endsWith("/enAction.do")
				&& !requesturi.endsWith(req.getContextPath()
                        + "/")
		)
		{
			// ��ת����½ҳ��   
			//System.out.println("requesturi=="+requesturi);
			//dispatcher.forward(request, response);
			PrintWriter out = res.getWriter();   
			out.write("<script>window.parent.parent.location.href='manage.jsp'</script>");   
			//System.out.println("�û�û�е�½�����������");   

		} else {
			// �Ѿ���½,�����˴�����   
			chain.doFilter(request, response);
			   //System.out.println("�û��Ѿ���½���������");   
		}
	}

	public void destroy() {

	}
}
