<%@page import="Model.Bill"%>
<%@page import="Model.User"%>
<%@page import="Model.Room"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bill</title>
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
</head>
<body>
    <%
        Bill bill = (Bill) request.getAttribute("bill");
        User user = (User) request.getAttribute("user");
        Room room = (Room) request.getAttribute("room");
    %>
    <div class="bill-container">
        <div class="bill-header">
            <h1>Hotel Bill</h1>
        </div>
        <div class="bill-details">
            <h2>User Information</h2>
            <p>Id: <%= user.getUserName() %></p>
            <p>Name: <%= user.getPassword() %></p>
            <p>Email: <%= user.getEmail() %></p>
            <h2>Room Information</h2>
            <p>Room Type: <%= room.getRoomtype() %></p>
            <p>Capacity: <%= room.getCapacity() %></p>
            <p>Status: <%= room.getStatus() %></p>
            <p>Messages: <%= room.getMessages() %></p>
            <!-- Add button to confirm bill -->
            <h2>Stay Details</h2>
            <table>
                <tr>
                    <th>Check-In Date</th>
                    <th>Check-Out Date</th>
                    <th>Room Type</th>
                    <th>Price per Night</th>
                    <th>Number of Nights</th>
                    <th>Total Amount</th>
                    <th>Request</th>
                </tr>
                <tr>
                    <td><%= bill.getDateIn() %></td>
                    <td><%= bill.getDateOut() %></td>
                    <td><%= bill.getRoomType() %></td>
                    <td>$<%= room.getPrice() %></td>
                    <td><%= (bill.getDateOut().getTime() - bill.getDateIn().getTime()) / (1000 * 60 * 60 * 24) %></td>
                    <td>$<%= bill.getPrice() %></td>
                    <td><%=bill.getRequest()%></td>
                </tr>
            </table>
        </div>   
    </div>
<button class="confirm-button" onclick="confirmBill()">Confirm Bill</button>

<style>
        .confirm-button {
            float: right; /* Align button to the right */
            font-size: 18px; /* Adjust font size */
            padding: 10px 20px; /* Adjust padding */
            margin-top: 20px; /* Optional margin top for spacing */
        }
    </style>
    <!-- JavaScript function to handle confirmation -->
    
    <script>
        function confirmBill() {
            if (confirm("Are you sure you want to confirm this bill?")) {
                window.location.href = "thanks.jsp"; // Redirect to thanks.jsp
            } else {
                // Optionally handle what happens when "No" is clicked
                // For example, you could display a message or do nothing
            }
        }
    </script>
</body>

</html>
