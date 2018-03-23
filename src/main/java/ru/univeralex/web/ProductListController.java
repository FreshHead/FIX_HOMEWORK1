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
 * Servlet implementation class ProductListController
 */
@WebServlet("/productList")
public class ProductListController extends HttpServlet {
    private List<Product> products;
    ProductDao productDao;

    @Override
    public void init() throws ServletException {
        super.init();
        productDao = new ProductDao();

//        products = new ArrayList<Product>();
//        products.add(new Product("car", 400_000.0));
//        products.add(new Product("bread", 25.50));
//        products.add(new Product("book", 1000.0));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        products = productDao.getProducts();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/showProductList.jsp");
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
