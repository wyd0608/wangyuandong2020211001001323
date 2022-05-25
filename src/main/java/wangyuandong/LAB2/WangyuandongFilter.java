package wangyuandong.LAB2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "WangyuandongFilter")
public class WangyuandongFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("WangyuandongFilter-->before chain");
        chain.doFilter(request, response);
        System.out.println("WangyuandongFilter-->after chain");
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
