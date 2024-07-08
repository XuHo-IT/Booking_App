<%@ page import="Model.User" %>
<%@ page import="Model.Bill" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.BillDAO" %>
<%@ page import="DBConnect.DBConnect" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hotel Bill</title>
    <!-- Your CSS styles here -->
</head>
 <style>
        .bill-container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #f9f9f9;
        }
        .bill-header {
            text-align: center;
            margin-bottom: 20px;
        }
        .bill-details h2 {
            border-bottom: 1px solid #ddd;
            padding-bottom: 10px;
            margin-bottom: 10px;
        }
        .bill-details p {
            margin: 0;
            padding: 5px 0;
        }
        .bill-details table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .bill-details th, .bill-details td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        .bill-details th {
            background-color: #f2f2f2;
        }
    </style>
<body>
    <%-- Check if user is logged in --%>
    <%
        User user = (User) session.getAttribute("currentUser");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }
    %>

    <%-- Retrieve bills for the logged-in user --%>
    <%
        BillDAO dao = new BillDAO(DBConnect.getConn());
        List<Bill> list = dao.getBillsByUserId(Integer.parseInt(user.getUserName()));
//       (List<Bill>) request.getAttribute("bills");
    %>

    <!-- Display user and bill details -->
    <div class="bill-container">
        <div class="bill-header">
            <h1>Hotel Bill</h1>
        </div>
        <div class="bill-details">
            <h2>User Information</h2>
            <p>Username: <%= user.getPassword() %></p>
            <p>Email: <%= user.getEmail() %></p>
        </div>
        <div class="bill-details">
            <h2>Bills Information</h2>
            <table>
                <thead>
                    <tr>
                        <th>Check-In Date</th>
                        <th>Check-Out Date</th>
                        <th>Room Type</th>
                        <th>Price per Night</th>
                        <th>Number of Nights</th>
                        <th>Total Amount</th>
                        <th>Request</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Iterate over each bill and display details --%>
                    <% for (Bill bill : list) { %>
                        <tr>
                            <td><%= bill.getDateIn() %></td>
                            <td><%= bill.getDateOut() %></td>
                            <td><%= bill.getRoomType() %></td>
                            <td>$<%= bill.getPrice() %></td>
                            <td><%= ((bill.getDateOut().getTime() - bill.getDateIn().getTime()) / (1000 * 60 * 60 * 24)) %></td>
                            <td>$<%= bill.getPrice() %></td>
                            <td><%= bill.getRequest() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Your HTML and JavaScript for button handling -->
    <button class="confirm-button" onclick="confirmBill()">Return</button>

    <script>
        function confirmBill() {
            if (confirm("Do you want to go back?")) {
                window.location.href = "room.jsp";
            } else {
                // Optionally handle what happens when "No" is clicked
            }
        }
    </script>
</body>
</html>
