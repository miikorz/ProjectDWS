/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserServiceLocal;

/**
 *
 * @author fabio
 */
@WebServlet(name = "ControllerUser",
        loadOnStartup = 1,
        urlPatterns = {"/ListUsers",
            "/AddUser",
            "/DeleteUser",
            "/UpdateUser"})
public class ControllerUser extends HttpServlet {

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
        String userPath = request.getServletPath();

        if (userPath.equals("/ListUsers")) {
            listUsers(request, response);
        } else if (userPath.equals("/AddUser")) {
            addUser(request, response);
        } else if (userPath.equals("/DeleteUser")) {
            deleteUser(request, response);
        } else if (userPath.equals("/UpdateUser")) {
            updateUser(request, response);
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

    private void listUsers(HttpServletRequest request, HttpServletResponse response) {
        try {
            List list = userService.listUsers();
            ArrayList<User> listUsers = new ArrayList<>(list);
            
            request.getSession().setAttribute("users", listUsers);
            RequestDispatcher rd = request.getRequestDispatcher("/listUsers.jsp");

            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String firstLastname = request.getParameter("firstLastname");
            String secondLastname = request.getParameter("secondLastname");
            int age = Integer.parseInt(request.getParameter("age"));
            String addres = request.getParameter("addres");
            String email = request.getParameter("email");
            int phone = Integer.parseInt(request.getParameter("phone"));
        
            User u = new User(user, password, name, firstLastname, secondLastname, age, addres, email, phone);
            
            userService.addUser(u);
            
            listUsers(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            String action = request.getParameter("action");
            
            User u = new User();
            
            if(action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                
                u.setId(id);
                
                u = userService.findUserById(u);
                
                request.setAttribute("u", u);
                request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
            } else if (action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String user = request.getParameter("user");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String firstLastname = request.getParameter("firstLastname");
                String secondLastname = request.getParameter("secondLastname");
                int age = Integer.parseInt(request.getParameter("age"));
                String addres = request.getParameter("addres");
                String email = request.getParameter("email");
                int phone = Integer.parseInt(request.getParameter("phone"));
                
                u.setId(id);
                u = userService.findUserById(u);
                
                u.setUser(user);
                u.setPassword(password);
                u.setName(name);
                u.setFirstLastname(firstLastname);
                u.setSecondLastname(secondLastname);
                u.setAge(age);
                u.setAddres(addres);
                u.setEmail(email);
                u.setPhone(phone);
                
                userService.updateUser(u);
                
                listUsers(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            
            User u = new User();
            u.setId(id);
            
            userService.deleteUser(u);
            
            listUsers(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
