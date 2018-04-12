package ru.univeralex.web.servlet;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.univeralex.web.dao.ProductDao;
import ru.univeralex.web.dao.ProductDaoJdbcTemplateImpl;
import ru.univeralex.web.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
    private ProductDao productDao;

    @Override
    public void init() throws ServletException {
        super.init();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("product_manager");
        dataSource.setPassword("qwerty_prod");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/fix_course_product_db");
        dataSource.setDriverClassName("org.postgresql.Driver");
        productDao = new ProductDaoJdbcTemplateImpl(dataSource);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("products", productDao.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/productList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("name");
        Double productCost = Double.valueOf(req.getParameter("cost"));
        productDao.save(new Product(productName, productCost));
        doGet(req, resp);
    }
}
