/* 
    Document   : index
    Created on : Mar 20, 2016, 2:03:43 PM
    Author     : cavaji
    
    follow     :    https://twitter.com/Cavaji
                    https://plus.google.com/u/0/109777059100477708540
                    http://cavaji.blogspot.com/
                    https://www.facebook.com/Cavaji-Soft-292268400944940/
*/
package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author cavaji
 */
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private UserManager usermgr;

    public Servlet() {
        super();
        usermgr = new UserManager();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        Object value = ft.format(dNow);

        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            String id = request.getParameter("id");
            Integer intId = Integer.parseInt(id);
            usermgr.delete(intId);
            String strTest = null;
            strTest = "Delete Success..";
            request.setAttribute("m1", "1");
            request.setAttribute("message", strTest);
            request.setAttribute("ftDate", value);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("update")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Integer intId = Integer.parseInt(id);
            User user = new User();
            user.setId(intId);
            user.setName(name);
            user.setUsername(username);
            user.setPassword(password);
            usermgr.update(user);
            String strTest = null;
            strTest = "Update Success..";
            request.setAttribute("m1", "2");
            request.setAttribute("message", strTest);
            request.setAttribute("ftDate", value);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new User();
            user.setName(name);
            user.setUsername(username);
            user.setPassword(password);
            usermgr.insert(user);
            String strTest = null;
            strTest = "insert Success..";
            request.setAttribute("m1", "3");
            request.setAttribute("message", strTest);
            request.setAttribute("ftDate", value);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
