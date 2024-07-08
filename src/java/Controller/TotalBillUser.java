/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BillDAO;
import DAO.RoomDAO;
import DBConnect.DBConnect;
import Model.Bill;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author OS
 */
public class TotalBillUser extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TotalBillUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TotalBillUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("currentUser");

    if (user != null) {
        String userName = user.getUserName(); // Assuming user.getId() retrieves the userId from User object
        int userId = Integer.parseInt(userName);
        BillDAO dao = new BillDAO(DBConnect.getConn());
        List<Bill> bills = dao.getBillsByUserId(userId); // Retrieve bills for the user
        if (!bills.isEmpty()) {
            // Set bills in request attribute to be accessed by JSP
            request.setAttribute("bills", bills);
            // Forward to the JSP page for displaying bills
            RequestDispatcher dispatcher = request.getRequestDispatcher("totalbilluser.jsp");
            dispatcher.forward(request, response);
        } else {
        
            System.out.println("No bills found for user with id: " + userId);
            session.setAttribute("failedMsg", "No bills found for user with id: " + userId);
            response.sendRedirect("room.jsp"); // Redirect to error page
        }
    } else {
       
        response.sendRedirect("login.jsp");
    }
}

}



   
    
