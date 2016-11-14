/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import entity.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserServiceLocal;

/**
 *
 * @author fabio
 */
public class UpdateUser extends HttpServlet {

    @EJB
    private UserServiceLocal userService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        User u = new User();

        switch (action) {
            case "edit":
                u.setId(id);
                u = this.userService.findUserById(u);

                request.setAttribute("u", u);
                request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
                break;

            case "update":
                String user = request.getParameter("user");
                String name = request.getParameter("name");
                String firstLastname = request.getParameter("firstLastname");
                String secondLastname = request.getParameter("secondLastname");
                int age = Integer.parseInt(request.getParameter("age"));
                String addres = request.getParameter("addres");
                String email = request.getParameter("email");
                int phone = Integer.parseInt(request.getParameter("phone"));

                u.setId(id);
                u.setUser(user);
                u.setName(name);
                u.setFirstLastname(firstLastname);
                u.setSecondLastname(secondLastname);
                u.setAge(age);
                u.setAddres(addres);
                u.setEmail(email);
                u.setPhone(phone);

                this.userService.updateUser(u);

                ArrayList _list = userService.listUsers();

                request.getSession().setAttribute("users", _list);
                RequestDispatcher rd = request.getRequestDispatcher("/listUsers.jsp");
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
