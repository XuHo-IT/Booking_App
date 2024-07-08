/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Admin;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author OS
 */
public class AdminDAO {
     private PreparedStatement pstmt;
    private ResultSet rs;
    private final Connection conn;
     public AdminDAO(Connection conn) {
        this.conn = conn;
    }
     public boolean adminRegister(Admin admin){
         boolean f = false;
         try{
            String query = "insert into [Admin](Name,email,password) values (?,?,?)";
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            pstmt.setString(1, admin.getName());
            pstmt.setString(2, admin.getEmail());
            pstmt.setString(3, admin.getPassword());
            pstmt.executeUpdate();
            f = true;  
         }catch(Exception e){
             e.printStackTrace();
         }
         return f;
     }
       public Admin login(String email, String password) {
        Admin admin = null;
        try {
            String sql = "select * from [Admin] where email=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt(1));
                admin.setName(rs.getString(2));
                admin.setEmail(rs.getString(3));
                admin.setPassword(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }
}
