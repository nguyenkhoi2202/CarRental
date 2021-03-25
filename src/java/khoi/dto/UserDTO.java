/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoi.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class UserDTO implements Serializable{
    private String userName;
    private String password;
    private String email;
    private String name;
    private String phone;
    private String address;
    private int status;
    private String roleID;
    private Date createDate;

    public UserDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public UserDTO(String userName, String password, String email, String name, String phone, String address, int status, String roleID, Date createDate) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.roleID = roleID;
        this.createDate = createDate;
    }

  

   
}
