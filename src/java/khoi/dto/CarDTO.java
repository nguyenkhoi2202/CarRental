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
public class CarDTO implements Serializable{
    private String carID;
    private String carName;
    private String imageSrc;
    private String color;
    private String year;
    private String categoryID;
    private float  price;
    private int quantity;
    private String description;

    public CarDTO() {
    }

    public CarDTO(String carID, String carName, String imageSrc, String color, String year, String categoryID, float price, int quantity, String description) {
        this.carID = carID;
        this.carName = carName;
        this.imageSrc = imageSrc;
        this.color = color;
        this.year = year;
        this.categoryID = categoryID;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
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

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
