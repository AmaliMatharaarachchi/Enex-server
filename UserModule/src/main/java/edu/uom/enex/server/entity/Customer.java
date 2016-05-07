package edu.uom.enex.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */

@MappedSuperclass
@Table(name = "customer")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer implements EntityInterface<String> {

    private String customerId;
    private String registeredDate;
    private String address;
    private String name;
    private int creditPeriod;
    private Region region;
    private int contactNo;
    private SalesRepresentative salesRepresentative;

    @Id
    @Column(name = "customerId", nullable = false, insertable = true, updatable = true)
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public SalesRepresentative getSalesRepresentative() {
        return salesRepresentative;
    }

    public void setSalesRepresentative(SalesRepresentative salesRepresentative) {
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
                ", region=" + region +
                ", contactNo=" + contactNo +
                ", salesRepresentative=" + salesRepresentative +
                '}';
    }
}
