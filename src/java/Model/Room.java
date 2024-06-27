package Model;

public class Room {
    private int roomId;
    private String roomtype;
    private int capacity;
    private float price;
    private String status;
    private String messages;
    private String userId;
    private String photoName;

    public Room(int roomId, String roomtype, int capacity, float price, String status, String messages, String userId, String photoName) {
        this.roomId = roomId;
        this.roomtype = roomtype;
        this.capacity = capacity;
        this.price = price;
        this.status = status;
        this.messages = messages;
        this.userId = userId;
        this.photoName = photoName;
    }

    public Room() {
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
