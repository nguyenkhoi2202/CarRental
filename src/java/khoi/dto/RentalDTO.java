/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoi.dto;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class RentalDTO implements Serializable{
    private String rentalID;
    private String cusName;
    private float totalPrice;
    private String checkIn;
    private String checkOut;
    private int bookDate;

    public RentalDTO() {
    }

    public RentalDTO(String rentalID, String cusName, float totalPrice, String checkIn, String checkOut, int bookDate) {
        this.rentalID = rentalID;
        this.cusName = cusName;
        this.totalPrice = totalPrice;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookDate = bookDate;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getRentalID() {
        return rentalID;
    }

    public void setRentalID(String rentalID) {
        this.rentalID = rentalID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getBookDate() {
        return bookDate;
    }

    public void setBookDate(int bookDate) {
        this.bookDate = bookDate;
    }

    
    
}
