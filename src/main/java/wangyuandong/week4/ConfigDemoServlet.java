package wangyuandong.week4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Config", value="/config",
        initParams = {
                @WebInitParam(name="Name", value="Wangyuandong"),
                @WebInitParam(name="StudentId", value="2020211001001323")
        } )
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取参数
        String name = getServletConfig().getInitParameter("Name");
        String id = getServletConfig().getInitParameter("StudentId");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Name : " + name + "<br>");
        out.print("Studentid : " + id + "<br>");
    }
}
