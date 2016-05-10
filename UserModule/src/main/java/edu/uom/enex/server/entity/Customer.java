package edu.uom.enex.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */


public class Customer implements EntityInterface<String> {

    private String customerId;
    private Date registeredDate;
    private String address;
    private String name;
    private int creditPeriod;
    private String region;
    private String contactNo;
    private String salesRepresentative;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditPeriod() {
        return creditPeriod;
    }

    public void setCreditPeriod(int creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getSalesRepresentative() {
        return salesRepresentative;
    }

    public void setSalesRepresentative(String salesRepresentative) {
        this.salesRepresentative = salesRepresentative;
    }

    @Override
    @Transient
    public String getId() {
        return getCustomerId();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", registeredDate='" + registeredDate + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", creditPeriod=" + creditPeriod +
                ", region='" + region + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", salesRepresentative='" + salesRepresentative + '\'' +
                '}';
    }
}
