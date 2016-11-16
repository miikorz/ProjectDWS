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
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
public class ProductServlet extends HttpServlet {

    @EJB
    private service.ProductServiceLocal productService;

    public void sendAndGoToList() {

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String functionType = request.getParameter("function");
        Product productToUpdate = new Product();
        ArrayList productList;
        RequestDispatcher rd;
        int productID;

        switch (functionType) {
            case "list":
                try {
                    productList = productService.listProducts();
                    request.getSession().setAttribute("productList", productList);
                    rd = request.getRequestDispatcher("/listProducts.jsp");
                    rd.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "add":
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

                request.getSession().setAttribute("productList", productList);
                rd = request.getRequestDispatcher("/listProducts.jsp");
                rd.forward(request, response);

                break;
            case "update":
                productID = Integer.parseInt(request.getParameter("id"));
                productToUpdate.setProductID(productID);
                productToUpdate = productService.findProductById(productToUpdate);

                request.setAttribute("productToUpdate", productToUpdate);
                request.getRequestDispatcher("/updateProduct.jsp").forward(request, response);

                break;
            case "edit":
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

                request.getSession().setAttribute("productList", productList);
                rd = request.getRequestDispatcher("/listProducts.jsp");
                rd.forward(request, response);

                break;
            case "delete":
                productID = parseInt(request.getParameter("id"));
                Product productToDelete = new Product();
                productToDelete.setProductID(productID);

                productService.deleteProduct(productToDelete);
                productList = productService.listProducts();

                request.getSession().setAttribute("productList", productList);
                rd = request.getRequestDispatcher("/listProducts.jsp");
                rd.forward(request, response);                
                
                break;
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

}
