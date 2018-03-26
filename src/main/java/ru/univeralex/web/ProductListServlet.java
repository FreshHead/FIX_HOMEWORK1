package ru.univeralex.web;

import ru.univeralex.web.model.Product;
import ru.univeralex.web.model.ProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
    private ProductDao productDao;

    @Override
    public void init() throws ServletException {
        super.init();
        productDao = new ProductDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("products", productDao.getProducts());
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/showProductList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("name");
        Double productCost = Double.valueOf(req.getParameter("cost"));
        productDao.addProduct(new Product(productName, productCost));
        doGet(req, resp);
    }

}
