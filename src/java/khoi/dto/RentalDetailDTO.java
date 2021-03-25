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
public class RentalDetailDTO implements Serializable {

    private int rentalID;
    private String carID;
    private String carName;
    private int quantity;
    private float price;

    public RentalDetailDTO() {
    }

    public RentalDetailDTO(int rentalID, String carID, String carName, int quantity, float price) {
        this.rentalID = rentalID;
        this.carID = carID;
        this.carName = carName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
