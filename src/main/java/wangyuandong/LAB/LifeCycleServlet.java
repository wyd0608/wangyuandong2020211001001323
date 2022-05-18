package wangyuandong.LAB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LifeCycleServlet",value = "/life")
public class LifeCycleServlet extends HttpServlet {

    int number=0;
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("......");
        System.out.println("I AM from default constructor");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("service");
        number++;
       // System.out.println(getServletConfig().getInitParameter("emails"));
        response.setContentType("text/html");

        PrintWriter writer=response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>" +"Since loading,this servlet has been accessed "+number+"times"+"</h1>");
        writer.println("</body></html>");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destory");
    }
}
