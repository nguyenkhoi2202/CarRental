/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoi.dto;

/**
 *
 * @author Nguyen Khoi
 */
public class CartDTO {
    private String cusname;
    private String carID;
    private String carName;
    private float price;
    private int quantity;

    public CartDTO() {
    }

    public CartDTO(String cusname, String carID, String carName, float price, int quantity) {
        this.cusname = cusname;
        this.carID = carID;
        this.carName = carName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   

   
    

   
}
