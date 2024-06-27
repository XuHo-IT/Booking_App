package DAO;

import Model.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BillDAO {

    private final Connection conn;

    public BillDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean billOrder(Bill bill, int userId) {
        boolean f = false;
        try {
            // SQL query to insert into the Bill table
            String query = "INSERT INTO Bill (dateIn, dateOut, price, userid) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set parameters for the PreparedStatement
            pstmt.setDate(1, new java.sql.Date(bill.getDateIn().getTime())); // Assuming getDateIn() returns java.util.Date
            pstmt.setDate(2, new java.sql.Date(bill.getDateOut().getTime())); // Assuming getDateOut() returns java.util.Date
            pstmt.setFloat(3, bill.getPrice());
            pstmt.setInt(4, userId); // Set the userId parameter

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
}
