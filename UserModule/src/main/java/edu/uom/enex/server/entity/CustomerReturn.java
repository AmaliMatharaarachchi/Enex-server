package edu.uom.enex.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
@Entity
@Table(name = "customerReturn")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerReturn implements EntityInterface<String>{

    private String orderReturnId;
    private String orderDetailId;
    private String orderId;
    private String productId;
    private int returnQty;
    private String date;
    private String reason;

    @Id
    @Column(name = "orderReturnId", nullable = false, insertable = true, updatable = true)
    public String getOrderReturnId() {
        return orderReturnId;
    }

    public void setOrderReturnId(String orderReturnId) {
        this.orderReturnId = orderReturnId;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(int returnQty) {
        this.returnQty = returnQty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    @Override
    @Transient
    public String getId() {
        return getOrderReturnId();
    }

    @Override
    public String toString() {
        return "CustomerReturn{" +
                "orderDetailId='" + orderDetailId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", returnQty=" + returnQty +
                ", date='" + date + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
