package ru.univeralex.web;

import org.mindrot.jbcrypt.BCrypt;
import ru.univeralex.web.model.User;
import ru.univeralex.web.dao.UserDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author - Alexander Kostarev
 */
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UserDaoImpl userDaoImpl;

    @Override
    public void init() {
        this.userDaoImpl = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDaoImpl.findAll();
        req.setAttribute("usersFromServer", users);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        userDaoImpl.save(new User(name, BCrypt.hashpw(password,BCrypt.gensalt())));
        HttpSession session = req.getSession();
        session.setAttribute("user", name);
        resp.sendRedirect(req.getContextPath() + "/productList");
    }
}