package wangyuandong.LAB;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyDearServlet",value = "/mydear")
public class MyDearServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("name");
        String Class = request.getParameter("Class");
        String ID = request.getParameter("ID");
        String submit = request.getParameter("submit");

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>MyDearJsp</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("name:"+name+"<br>");
        writer.println("submit:"+submit+"<br>");
        writer.println("class:"+Class+"<br>");
        writer.println("id:"+ID+"<br>");
        writer.println("</body>");
        writer.println("</html>");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //request.getRequestDispatcher("WEB-INF/MyDearJsp.jsp").forward(request,response);
    }
}
