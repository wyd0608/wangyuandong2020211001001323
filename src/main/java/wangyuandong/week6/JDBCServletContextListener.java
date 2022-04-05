package wangyuandong.week6;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener  implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        String driver = application.getInitParameter("driver");
        String url = application.getInitParameter("url");
        String username = application.getInitParameter("username");
        String password = application.getInitParameter("password");


        try {
            Class.forName(driver);
           Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("i am in contextInitialized()-- >"+conn);
            application.setAttribute("conn",conn);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        System.out.println("i am in contextInitialized()");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("i am in contextDestroyed()");
        sce.getServletContext().removeAttribute("conn");
    }
}
