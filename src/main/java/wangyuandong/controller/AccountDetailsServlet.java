package wangyuandong.controller;

import wangyuandong.Dao.OrderDao;
import wangyuandong.model.Order;
import wangyuandong.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/accountDetails")
public class AccountDetailsServlet extends HttpServlet {
    private Connection con;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("conn");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user")!=null){
            User user = (User) session.getAttribute("user");
            int userID = Integer.parseInt(user.getID());
            request.setAttribute("user", user);
            OrderDao orderDao = new OrderDao();
            List<Order> orderList = orderDao.findByUserId(con, userID);
            request.setAttribute("orderList", orderList);
            request.getRequestDispatcher("/WEB-INF/views/accountDetails.jsp").forward(request, response);
        }else {
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
