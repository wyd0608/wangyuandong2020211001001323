package wangyuandong.LAB2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/welcome.jsp")
public class LoginFilter implements Filter {
    public void destroy() {
        System.out.println("LoginFilter--destroy()");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("LoginFilter--doFilter()-- request before chain");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getSession(false) != null && req.getSession(false).getAttribute("user") != null){
            chain.doFilter(request, response);
        }else {
            res.sendRedirect(req.getContextPath()+"/login.jsp");
        }
        System.out.println("LoginFilter--doFilter()-- response after chain");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("LoginFilter--init()");
    }

}
