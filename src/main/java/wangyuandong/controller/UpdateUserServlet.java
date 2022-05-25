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

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    private Connection con;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("conn");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");

        User user = new User();
        user.setID(String.valueOf(Integer.valueOf(ID)));
        user.setUsername(username);
        user.setPasswords(password);
        user.setEmails(email);
        user.setGender(gender);
        user.setBirthdate(Date.valueOf(birthday));

        UserDao userDao = new UserDao();
        int num = 0;
        try {
            num = userDao.updateUser(con, user);
            User updateUser = userDao.findById(con, ID);
            if (num != 0){
                HttpSession session = request.getSession();
                session.removeAttribute("user");
                session.setAttribute("user", updateUser);
                request.getRequestDispatcher("accountDetails").forward(request, response);
            }else {
                request.setAttribute("message", "Update fail!");
                request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
