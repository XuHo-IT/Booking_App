/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author HELLO
 */
import java.util.Date;
public class Bill {
    User user;
    private int billNo;
    private int peopleNumber;
    private Date dateIn;
    private Date dateOut;
    private float price;
    private String roomType;
    private String request;

    public Bill( int billNo, int peopleNumber, Date dateIn, Date dateOut, float price, String roomType, String request) {
       
        this.billNo = billNo;
        this.peopleNumber = peopleNumber;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.price = price;
        this.roomType = roomType;
        this.request = request;
    }

   

    

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    
    
    public Bill() {
        
    }
    //getter setter

  

   public int getBillNo() {
      return billNo;
   }

   public void setBillNo(int billNo) {
      this.billNo = billNo;
   }

   public int getPeopleNumber() {
      return peopleNumber;
   }

   public void setPeopleNumber(int peopleNumber) {
      this.peopleNumber = peopleNumber;
   }

   public Date getDateIn() {
      return dateIn;
   }

   public void setDateIn(Date dateIn) {
      this.dateIn = dateIn;
   }

   public Date getDateOut() {
      return dateOut;
   }

   public void setDateOut(Date dateOut) {
      this.dateOut = dateOut;
   }

   public float getPrice() {
      return price;
   }

   public void setPrice(float price) {
      this.price = price;
   }

   public String getRoomType() {
      return roomType;
   }

   public void setRoomType(String roomType) {
      this.roomType = roomType;
   }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
   

}
