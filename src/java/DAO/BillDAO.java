package DAO;

import Model.Bill;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {

    private final Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public BillDAO(Connection conn) {
        this.conn = conn;
    }
   public boolean billOrder(Bill bill, int userId,String userName, String email) {
        boolean f = false;
        try {
            // SQL query to insert into the Bill table
            String query = "INSERT INTO Bill (dateIn, dateOut, price, userid,number,roomtype,request,userName,userEmail) VALUES (?, ?, ?, ?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set parameters for the PreparedStatement
            pstmt.setDate(1, new java.sql.Date(bill.getDateIn().getTime())); // Assuming getDateIn() returns java.util.Date
            pstmt.setDate(2, new java.sql.Date(bill.getDateOut().getTime())); // Assuming getDateOut() returns java.util.Date
            pstmt.setFloat(3, bill.getPrice());
            pstmt.setInt(4, userId); // Set the userId parameter
            pstmt.setInt(5, bill.getPeopleNumber());
            pstmt.setString(6, bill.getRoomType());
            pstmt.setString(7, bill.getRequest());
            pstmt.setString(8, userName);
            pstmt.setString(9, email);


            // Execute the query
            int rowsAffected = pstmt.executeUpdate();

            // If rowsAffected > 0, insertion was successful
            if (rowsAffected > 0) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    public List<Bill> Bills() {
        List<Bill> list = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            String query = "SELECT * from Bill";
                          

            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setBillNo(rs.getInt("billNo"));
                bill.setDateIn(rs.getDate("dateIn"));
                bill.setDateOut(rs.getDate("dateOut"));
                bill.setPrice(rs.getFloat("price"));
                bill.setPeopleNumber(rs.getInt("number"));
                bill.setRoomType(rs.getString("roomType"));
                bill.setRequest(rs.getString("request"));
               
                // Create User object and set user information
                User user = new User();
                user.setUserName(rs.getString("username")); // Corrected column name
                user.setEmail(rs.getString("useremail"));

                // Set User object in Bill
                bill.setUser(user);
                list.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

  public List<Bill> getBillsByUserId(int userId) {
    List<Bill> bills = new ArrayList<>();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        String query = "SELECT billNo, dateIn, dateOut, price, number, roomType, request, userid, username, useremail " +
                       "FROM Bill b " +
                       "WHERE b.userid = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, userId);
        rs = pstmt.executeQuery();
        
        while (rs.next()) {
            Bill bill = new Bill();
            bill.setBillNo(rs.getInt("billNo"));
            bill.setDateIn(rs.getDate("dateIn"));
            bill.setDateOut(rs.getDate("dateOut"));
            bill.setPrice(rs.getFloat("price"));
            bill.setPeopleNumber(rs.getInt("number"));
            bill.setRoomType(rs.getString("roomType"));
            bill.setRequest(rs.getString("request"));

            // Create User object and set user information
            User user = new User();
            user.setId(rs.getInt("userid"));
            user.setUserName(rs.getString("username"));
            user.setEmail(rs.getString("useremail"));

            // Set User object in Bill
            bill.setUser(user);
            bills.add(bill);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Consider logging or handling the exception appropriately
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Consider logging or handling the exception appropriately
        }
    }
    return bills;
}

}
