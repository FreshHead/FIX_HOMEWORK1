package ru.univeralex.web.servlet;

import org.mindrot.jbcrypt.BCrypt;
import ru.univeralex.web.dao.UserDaoJdbcImpl;
import ru.univeralex.web.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

/**
 * @author - Alexander Kostarev
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDaoJdbcImpl userDaoJdbcImpl;

    @Override
    public void init() {
        this.userDaoJdbcImpl = new UserDaoJdbcImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("name");
        String password = req.getParameter("password");
        if (validate(username, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            resp.sendRedirect(req.getContextPath() + "/productList");

        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    private boolean validate(String username, String password) {
        Optional<User> user = userDaoJdbcImpl.findByUsername(username);
        return user.filter(user1 -> BCrypt.checkpw(password, user1.getPassword())).isPresent();
    }
}