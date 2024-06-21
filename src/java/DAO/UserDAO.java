/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBConnect.DBConnect;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class UserDAO {

   private PreparedStatement pstmt;
    private ResultSet rs;
    private final Connection conn;
     public UserDAO(Connection conn) {
        this.conn = conn;
    }
     public boolean userRegister(User user){
         boolean f = false;
         try{
            String query = "insert into [User](userName,email,password) values (?,?,?)";
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.executeUpdate();
            f = true;  
         }catch(Exception e){
             e.printStackTrace();
         }
         return f;
     }
       public User login(String email, String password) {
        User us = null;
        try {
            String sql = "select * from [User] where email=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                us = new User();
                us.setId(rs.getInt(4));
                us.setUserName(rs.getString(1));
               us.setEmail(rs.getString(2));
               us.setPassword(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return us;
    }
        public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        try {
            String query = "SELECT userId, userName, email, password FROM [Booking].[dbo].[User]";
            pstmt = this.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
