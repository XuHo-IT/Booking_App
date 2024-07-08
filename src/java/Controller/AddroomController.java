package Controller;

import DAO.RoomDAO;
import DBConnect.DBConnect;
import Model.Admin;
import Model.Room;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
public class AddroomController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddroomController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddroomController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String messages = request.getParameter("messages");
            String capacityStr = request.getParameter("capacity");
            String priceStr = request.getParameter("price");
            String roomType = request.getParameter("type");
            String status = request.getParameter("status");

            Part part = request.getPart("image");
            HttpSession session = request.getSession();

            String fileName = "";
            if (part != null && part.getSize() > 0) {
                fileName = part.getSubmittedFileName();
                // Save the file to a directory
                String uploadPath = getServletContext().getRealPath("") + File.separator + "img";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                part.write(uploadPath + File.separator + fileName);
            }

            int capacity = 0;
            if (capacityStr != null && !capacityStr.isEmpty()) {
                capacity = Integer.parseInt(capacityStr);
            }

            float price = 0.0f;
            if (priceStr != null && !priceStr.isEmpty()) {
                price = Float.parseFloat(priceStr);
            }

            Room b = new Room();
            b.setMessages(messages);
            b.setCapacity(capacity);
            b.setPrice(price);
            b.setRoomtype(roomType);
            b.setPhotoName(fileName);
            b.setStatus(status);

            Admin admin = (Admin) session.getAttribute("currentUser");
            int adminId = admin.getId();

            RoomDAO dao = new RoomDAO(DBConnect.getConn());
            boolean f = dao.addRooms(b, adminId);

            if (f) {
                session.setAttribute("succMsg", "Room added successfully");
                response.sendRedirect("roomadmin.jsp");
            } else {
                session.setAttribute("failedMsg", "Failed to add room");
                response.sendRedirect("addroom.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
