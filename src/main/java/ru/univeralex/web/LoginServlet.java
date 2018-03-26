package ru.univeralex.web;

import ru.univeralex.web.model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author - Alexander Kostarev
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() {
        this.userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if (userDao.isUserExists(name, password)) {
            // создаем для него сессию
            HttpSession session = req.getSession();
            // кладем в атрибуты сессии атрибут user с именем пользователя
            session.setAttribute("user", name);
            resp.sendRedirect(req.getContextPath() + "/productList");
//            req.getServletContext().getRequestDispatcher("/productList").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }
}