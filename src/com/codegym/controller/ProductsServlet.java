package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProduct;
import com.codegym.service.ProductsImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductsServlet",urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {
    private final IProduct iProduct = (IProduct) new ProductsImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        switch (action != null ? action : "") {
            case "createProduct":
                createProduct(request, response);
                break;
            case "editClothing":
                editProduct(request, response);
                break;
            case "findByPrice":
                findByPrice(request,response);
                break;
            default:
                break;

        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String number = request.getParameter("number");
        String color = request.getParameter("color");
        String discerption = request.getParameter("discerption");


        Product product = new Product(id, name,price,number,color,discerption);
        this.iProduct.update(product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listProduct/edit_product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String number = request.getParameter("number");
        String color = request.getParameter("color");
        String discerption = request.getParameter("discerption");


        Product product = new Product(name, price,number, color,discerption);
        this.iProduct.insert(product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listProduct/create_products.jsp");
        request.setAttribute("message", "Tao moi thanh cong");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String price = request.getParameter("price");
        if(price != null){
            findByPrice(request, response);
        }

        switch (action != null ? action : "") {
            case "createClothing":
                showCreateClothing(request, response);
                break;
            case "editClothing":
                showEditClothing(request, response);
                break;
            case "listProduct":
                showProduct(request, response);
                break;
            case "deleteProduct":
                deleteProduct(request, response);
                break;
        }
    }

    private void findByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String price = request.getParameter("price");
        List<Product> list = this.iProduct.findByPrice(price);
        RequestDispatcher requestDispatcher;
        if (list == null){
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("product", list);
            requestDispatcher = request.getRequestDispatcher("listProduct/list_product.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.iProduct.remove(id);
        List<Product> clothing = this.iProduct.findAll();
        request.setAttribute("clothing", clothing);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listProduct/list_product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = this.iProduct.findAll();
        request.setAttribute("product", products);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listClothing/list_clothing.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditClothing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        // trả về 1 clothing\
        Product product = this.iProduct.findById(id);
        //gán lại cho view
//        List<Clothing> clothing = this.clothingService.findAll();
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listProduct/edit_product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreateClothing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listClothing/create_clothing.jsp");
        requestDispatcher.forward(request, response);
    }
}
