package ru.univeralex.web.servlets;

import ru.univeralex.web.dao.OfficeDao;
import ru.univeralex.web.dao.impl.OfficeDaoHibernateImpl;
import ru.univeralex.web.models.Office;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author - Alexander Kostarev
 */
@WebServlet("/officeList")
public class OfficeListServlet extends HttpServlet {
    private OfficeDao officeDao;

    @Override
    public void init() throws ServletException {
        super.init();
        officeDao = new OfficeDaoHibernateImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("offices", officeDao.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/officeList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("add") != null) {
            String officeName = req.getParameter("name");
            String officeAddress = req.getParameter("address");
            String officePhone = req.getParameter("phone");
            officeDao.save(new Office(officeName, officeAddress, officePhone));
        } else if (req.getParameter("delete") != null) {
            Integer officeId = Integer.valueOf(req.getParameter("id"));
            officeDao.delete(officeId);
        } else if (req.getParameter("update") != null) {
            Integer officeId = Integer.valueOf(req.getParameter("id"));
            String officeName = req.getParameter("name");
            String officeAddress = req.getParameter("address");
            String officePhone = req.getParameter("phone");
            officeDao.update(new Office(officeId, officeName, officeAddress, officePhone));
        }
        doGet(req, resp);
    }
}
