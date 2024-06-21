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
    private String user;
    private int billNo;
    private int peopleNumber;
    private String resortAddress;
    private Date dateIn;
    private Date dateOut;
    private float price;
    private String roomType;

    
    public Bill(String user, int billNo, int peopleNumber, String resortAddress, Date dateIn, Date dateOut, float price, String roomType) {
      this.user = user;
      this.billNo = billNo;
      this.peopleNumber = peopleNumber;
      this.resortAddress = resortAddress;
      this.dateIn = dateIn;
      this.dateOut = dateOut;
      this.price = price;
      this.roomType = roomType;
   }
    public Bill() {
        
    }
    //getter setter

   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }

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

   public String getResortAddress() {
      return resortAddress;
   }

   public void setResortAddress(String resortAddress) {
      this.resortAddress = resortAddress;
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

   public void setPrice(int price) {
      this.price = price;
   }

   public String getRoomType() {
      return roomType;
   }

   public void setRoomType(String roomType) {
      this.roomType = roomType;
   }
   
   //toString
   
   @Override
   public String toString() {
      return "Human{" +
              "user='" + user + '\'' +
              ", billNo=" + billNo +
              ", peopleNumber=" + peopleNumber +
              ", resortAddress='" + resortAddress + '\'' +
              ", dateIn=" + dateIn +
              ", dateOut=" + dateOut +
              ", price=" + price +
              ", roomType='" + roomType + '\'' +
              '}';
   }
}
