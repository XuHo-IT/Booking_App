package Controller;

import DAO.RoomDAO;
import DAO.UserDAO;
import DBConnect.DBConnect;
import Model.Bill;
import Model.Room;
import Model.User;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.temporal.ChronoUnit;


public class BillController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // This method can remain as is
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        
        if (user != null) {
            int roomId = Integer.parseInt(request.getParameter("roomId"));
            Date checkin = Date.valueOf(request.getParameter("checkin"));
            Date checkout = Date.valueOf(request.getParameter("checkout"));
            
            RoomDAO roomDao = new RoomDAO(DBConnect.getConn());
            Room room = roomDao.getRoomById(roomId);

            // Calculate number of days
            long days = ChronoUnit.DAYS.between(checkin.toLocalDate(), checkout.toLocalDate());

            // Calculate total price
            float totalPrice = room.getPrice() * days;

            // Create Bill object
            Bill bill = new Bill(user.getUserName(), 0, room.getCapacity(), "Resort Address", checkin, checkout, totalPrice, room.getRoomtype());
            
            request.setAttribute("bill", bill);
            request.setAttribute("user", user);
            request.setAttribute("room", room);
            request.getRequestDispatcher("bill.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp"); // Redirect to login if user is not logged in
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
