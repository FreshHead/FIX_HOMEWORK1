package ru.univeralex.web.servlet;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.univeralex.web.config.spring.AppConfig;
import ru.univeralex.web.dao.api.UserDao;
import ru.univeralex.web.model.User;

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

    private UserDao userDao;

    @Override
    public void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        this.userDao = context.getBean(UserDao.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDao.findAll();
        req.setAttribute("usersFromServer", users);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        userDao.save(new User(name, BCrypt.hashpw(password, BCrypt.gensalt())));
        HttpSession session = req.getSession();
        session.setAttribute("user", name);
        resp.sendRedirect(req.getContextPath() + "/productList");
    }
}