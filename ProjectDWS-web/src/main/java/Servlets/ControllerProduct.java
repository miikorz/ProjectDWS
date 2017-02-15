/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ProductServiceLocal;

/**
 *
 * @author alumno
 */
@WebServlet(name = "ControllerProduct",
        loadOnStartup = 1,
        urlPatterns = {"/ListProducts",
            "/AddProduct",
            "/DeleteProduct",
            "/UpdateProduct",
            "/FillUpdateForm"})

public class ControllerProduct extends HttpServlet {

    @EJB
    private ProductServiceLocal productService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Product productToUpdate = new Product();
    List productList;
    ArrayList<Product> productListArray;
    RequestDispatcher rd;
    int productID;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();

        // Si la operacion es listar
        if (userPath.equals("/ListProducts")) {
            listProducts(request, response);
            // Si la operacion es Alta
        } else if (userPath.equals("/AddProduct")) {
            addProduct(request, response);
            // Si la operacion es Eliminar
        } else if (userPath.equals("/DeleteProduct")) {
            deleteProduct(request, response);
            // Si la operacion es Modificar
        } else if (userPath.equals("/UpdateProduct")) {
            updateProduct(request, response);
        } else if (userPath.equals("/FillUpdateForm")) {
            fillUpdateForm(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productList = productService.listProducts();
        productListArray = new ArrayList<>(productList);
        request.getSession().setAttribute("productList", productListArray);
        rd = request.getRequestDispatcher("/listProducts.jsp");
        rd.forward(request, response);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        int stock = parseInt(request.getParameter("stock"));
        double price = parseDouble(request.getParameter("price"));

        Product product = new Product();
        product.setProductID(id);
        product.setName(name);
        product.setDescription(desc);
        product.setStock(stock);
        product.setPrice(price);

        productService.addProduct(product);

        productList = productService.listProducts();
        productListArray = new ArrayList<>(productList);

        request.getSession().setAttribute("productList", productListArray);
        rd = request.getRequestDispatcher("/listProducts.jsp");
        rd.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productID = parseInt(request.getParameter("id"));
        Product productToDelete = new Product();
        productToDelete.setProductID(productID);

        productService.deleteProduct(productToDelete);
        productList = productService.listProducts();
        productListArray = new ArrayList<>(productList);

        request.getSession().setAttribute("productList", productListArray);
        rd = request.getRequestDispatcher("/listProducts.jsp");
        rd.forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productID = parseInt(request.getParameter("id"));
        String productName = request.getParameter("name");
        String productDesc = request.getParameter("description");
        int productStock = parseInt(request.getParameter("stock"));
        double productPrice = parseDouble(request.getParameter("price"));

        productToUpdate.setProductID(productID);
        productToUpdate.setName(productName);
        productToUpdate.setDescription(productDesc);
        productToUpdate.setStock(productStock);
        productToUpdate.setPrice(productPrice);

        productService.updateProduct(productToUpdate);
        productList = productService.listProducts();
        productListArray = new ArrayList<>(productList);

        request.getSession().setAttribute("productList", productListArray);
        rd = request.getRequestDispatcher("/listProducts.jsp");
        rd.forward(request, response);
    }

    private void fillUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productID = Integer.parseInt(request.getParameter("id"));
        productToUpdate.setProductID(productID);
        productToUpdate = productService.findProductById(productToUpdate);

        request.setAttribute("productToUpdate", productToUpdate);
        request.getRequestDispatcher("/updateProduct.jsp").forward(request, response);
    }

}
