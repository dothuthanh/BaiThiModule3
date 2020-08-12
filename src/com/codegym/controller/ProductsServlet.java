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
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "findByPrice":
                findByPrice(request,response);
                break;
            case "search":
                searchProduct(request,response);
                break;
            default:
                break;

        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> product = this.iProduct.searchByName(name);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("listProduct/search_product.jsp");
        dispatcher.forward(request, response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String number = request.getParameter("number");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");


        Product product = new Product(id, name,price,number,color,description,category);
        this.iProduct.update(product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listProduct/edit_product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String number = request.getParameter("number");
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");

        Product product = new Product(name, price,number, color,description,category);
        this.iProduct.insert(product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listProduct/create_product.jsp");
        request.setAttribute("message", "Tao moi thanh cong");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");


        switch (action != null ? action : "") {
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "listProduct":
                showProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                showSearchForm(request, response);
                break;
            default:
                actionList(request,response);
                break;
        }
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        List<Product> product = this.iProduct.searchByName(name);
        iProduct.searchByName(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listProduct/search_product.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listProduct/create_product.jsp");
        requestDispatcher.forward(request,response);
    }

    private void actionList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/products?action=listProduct");
    }

    private void findByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String price = request.getParameter("price");
//        List<Product> list = this.iProduct.findByPrice(price);
//        RequestDispatcher requestDispatcher;
//        if (list == null){
//            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
//        }else {
//            request.setAttribute("product", list);
//            requestDispatcher = request.getRequestDispatcher("listProduct/list_product.jsp");
//            requestDispatcher.forward(request, response);
//        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.iProduct.remove(id);
        List<Product> product = this.iProduct.findAll();
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listProduct/list_product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = this.iProduct.findAll();
        request.setAttribute("product", products);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listProduct/list_product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        // trả về 1 clothing\
        Product product = this.iProduct.findById(id);
        //gán lại cho view
//        List<Clothing> clothing = this.clothingService.findAll();
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listProduct/edit_product.jsp");
        requestDispatcher.forward(request, response);
    }

}
