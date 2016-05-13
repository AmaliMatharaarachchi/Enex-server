package edu.uom.enex.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
@MappedSuperclass
@Table(name = "order")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Order implements EntityInterface<String>{

    private String orderId;
    private String customerId;
    private String issueDate;
    private int validity;
    private double amount;
//    private List<OrderDetail> orderDetaliList;

    @Id
    @Column(name = "orderId", nullable = false, insertable = true, updatable = true)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    @Transient
    public String getId() {
        return getOrderId();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", validity=" + validity +
                ", amount=" + amount +
                '}';
    }

    //    public List<OrderDetail> getOrderDetaliList() {
//        return orderDetaliList;
//    }
//
//    public void setOrderDetaliList(List<OrderDetail> orderDetaliList) {
//        this.orderDetaliList = orderDetaliList;
//    }
}
