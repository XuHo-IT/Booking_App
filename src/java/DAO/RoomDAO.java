/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBConnect.DBConnect;
import Model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class RoomDAO {
     private final Connection con;
     private PreparedStatement pstmt;
     private ResultSet rs;
     public RoomDAO(Connection con) {
        this.con = con;
    }
     
 public boolean addRooms(Room b, int adminid) {
        boolean f = false;
        try {
            String sql = "INSERT INTO Room (roomtype, capacity, price, status, messages, userid, photo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, b.getRoomtype());
            ps.setInt(2, b.getCapacity());
            ps.setFloat(3, b.getPrice());
            ps.setString(4, b.getStatus());
            ps.setString(5, b.getMessages());
            ps.setInt(6, adminid);
            ps.setString(7, b.getPhotoName());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
                System.out.println("Room added successfully.");
            } else {
                System.out.println("Failed to add room.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }



     public List<Room> Rooms() {
        List<Room> list = new ArrayList<>();
        try {
            String query = "select * from Room";
            pstmt = this.con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("roomid"));
                room.setRoomtype(rs.getString("roomtype"));
                room.setCapacity(rs.getInt("capacity"));
                room.setPrice(rs.getFloat("price"));
                room.setStatus(rs.getString("status"));
                room.setMessages(rs.getString("messages"));
                room.setUserId(rs.getString("userId"));
                room.setPhotoName(rs.getString("photo"));
                list.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }
      public void bookRoom(int roomId, int userId) {
        try {
            String query = "UPDATE Room SET userId = ? WHERE roomId = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, roomId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       public Room getRoomById(int roomId) {
        Room room = null;
        try {
            String query = "SELECT * FROM Room WHERE roomid = ?";
            pstmt = this.con.prepareStatement(query);
            pstmt.setInt(1, roomId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                room = new Room();
                room.setRoomId(rs.getInt("roomid"));
                room.setRoomtype(rs.getString("roomtype"));
                room.setCapacity(rs.getInt("capacity"));
                room.setPrice(rs.getFloat("price"));
                room.setStatus(rs.getString("status"));
                room.setMessages(rs.getString("messages"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }
        public boolean updatedRooms(Room b) {
        boolean f = false;
        try {
            String sql = "Update Room set roomtype=?,capacity=?,price=?,status=?,messages=? where roomId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, b.getRoomtype());
            ps.setInt(2, b.getCapacity());
            ps.setFloat(3, b.getPrice());
            ps.setString(4, b.getStatus());
            ps.setString(5, b.getMessages());
            ps.setInt(6, b.getRoomId()); // Set the roomId here

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
        public boolean deleRoom(int id) {
        boolean f = false;
        try {
            String sql = "delete from room where Id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

}

