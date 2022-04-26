package wangyuandong.week3.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterServlet",value = "/register")
public class RegisterServlet extends HttpServlet {
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
           conn= (Connection) getServletContext().getAttribute("conn");//name of attibute
        }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/registerwww.jsp").forward(request, response);
    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String ID=request.getParameter("ID");
            String username=request.getParameter("username");
            String passwords=request.getParameter("passwords");
            String emails=request.getParameter("emails");
            String gender=request.getParameter("gender");
            String birthdate=request.getParameter("birthdate");

//        PrintWriter writer =response.getWriter();
//            writer.println("<br>ID :"+ID);
//            writer.println("<br>username :"+username);
//            writer.println("<br>passwords :"+passwords);
//            writer.println("<br>emails :"+emails);
//            writer.println("<br>gender :"+gender);
//            writer.println("<br>birthdate :"+birthdate);
//            writer.close();
//            writer.print("        <!DOCTYPE html>");
//            writer.print("<html>");
//            writer.print("    <head>");
//            writer.print("        <meta charset='UTF-8'>");
//            writer.print("        <title>Register</title>");
//            writer.print("    </head>");
//            writer.print("    <body>");
//            writer.print("        <h1 align='center'>Register</h1>");
//            writer.print("        <hr>");
//            writer.print("        <table border='3px' align='center' width='60%'>");
//            writer.print("            <tr>");
//            writer.print("                <th>ID</th>");
//            writer.print("                <th>username</th>");
//            writer.print("                <th>passwords</th>");
//            writer.print("                <th>email</th>");
//            writer.print("                <th>gender</th>");
//            writer.print("                <th>birthdate</th>");
//            writer.print("            </tr>");

            try {
                String sql = "insert into Registers(ID, username, passwords, emails, gender, birthdate) values(?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1,"23");
                ps.setString(2, username);
                ps.setString(3, passwords);
                ps.setString(4, emails);
                ps.setString(5, gender);
                ps.setString(6, birthdate);
                ps.executeUpdate();

               // String sql1 = "select * from Registers";
                //ps = conn.prepareStatement(sql1);
                //rs = ps.executeQuery();
//                while (rs.next()){
//                    String ID1 = rs.getString("ID");
//                    String username1 = rs.getString("username");
//                    String passwords1 = rs.getString("passwords");
//                    String emails1 = rs.getString("emails");
//                    String gender1 = rs.getString("gender");
//                    String birthdate1 = rs.getString("birthdate");
////                    writer.print("            <tr>");
////                    writer.print("                <td>"+ ID1 +"</td>");
////                    writer.print("            <td>"+ username1 +"</td>");
////                    writer.print("                <td>"+ passwords1 +"</td>");
////                    writer.print("                <td>"+ emails1 +"</td>");
////                    writer.print("    <td>"+ gender1 +"</td>");
////                    writer.print("                <td>"+ birthdate1 +"</td>");
////                    writer.print("            </tr>");
//                }
                response.sendRedirect("Loing.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if (rs!=null){
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (ps!=null){
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (conn!=null){
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
//
//            writer.print("        </table>");
//            writer.print("        <hr>");
//            writer.print("    </body>");
//            writer.print("</html>");
//
//            writer.close();
        }
}


