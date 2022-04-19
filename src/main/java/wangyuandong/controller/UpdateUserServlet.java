package wangyuandong.controller;

import wangyuandong.Dao.UserDao;
import wangyuandong.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet",value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ID = request.getParameter("ID");
        String username = request.getParameter("username");
        String passwords = request.getParameter("passwords");
        String emails = request.getParameter("emails");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");

        User user = new User();
        user.setID(ID);
        user.setUsername(username);
        user.setPasswords(passwords);
        user.setEmails(emails);
        user.setGender(gender);
        user.setBirthdate(Date.valueOf(birthdate));

        UserDao userDao = new UserDao();
        ServletContext application = getServletContext();
        Connection conn = (Connection) application.getAttribute("conn");
        int num = 0;
        try {
            num = userDao.updateUser(conn, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (num != 0){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
        }else {
            request.setAttribute("message", "Update fail!");
            request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }
}
