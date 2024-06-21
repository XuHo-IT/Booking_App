/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
}

