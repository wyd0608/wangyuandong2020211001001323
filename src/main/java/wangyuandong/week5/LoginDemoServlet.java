package wangyuandong.week5;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginDemoServlet",value="/login")
public class LoginDemoServlet extends HttpServlet {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public void init() throws ServletException {
       /* ServletContext application = getServletConfig().getServletContext();
        String driver = application.getInitParameter("driver");
        String url = application.getInitParameter("url");
        String username = application.getInitParameter("username");
        String password = application.getInitParameter("password");


        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        conn=(Connection) getServletContext().getAttribute("conn");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String passwords = request.getParameter("passwords");
        PrintWriter writer =response.getWriter();
        String sql="select * from Registers where username=? and passwords=?";
        try {
            String a=null;
            String b=null;
            String c=null;
            String d=null;
            String e=null;
            String f=null;
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, passwords);
            rs = ps.executeQuery();
            while(rs.next()) {
                 a = rs.getString("username");
                 b = rs.getString("passwords");
                c = rs.getString("ID");
                d = rs.getString("emails");
                e = rs.getString("gender");
                f = rs.getString("birthdate");
            }
            response.setContentType("text/html");
            if (a.equals(username) && b.equals(passwords)) {
              //  writer.println("LOGIN SUCCESS");
                //writer.println("WELCOME "+username);
                request.setAttribute("ID",c);
                request.setAttribute("username",a);
                request.setAttribute("passwords",b);
                request.setAttribute("emails",d);
                request.setAttribute("gender",e);
                request.setAttribute("birthdate",f);

                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }else{
                //writer.println("LOGIN FAILED");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("Loing.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
