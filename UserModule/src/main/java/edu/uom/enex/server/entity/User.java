package edu.uom.enex.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
@Entity
@Table(name = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements EntityInterface<String>{
    private String userId;
    private String userName;
    private String password;
    private int privilege;
    private String name;
    private String address;
    private String contactNo;

    @Id
    @Column(name = "userId", nullable = false, insertable = true, updatable = true)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    @Transient
    public String getId() {
        return getUserId();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", privilege='" + privilege + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNo=" + contactNo +
                '}';
    }
}
