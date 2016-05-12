package edu.uom.enex.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
@Entity
@Table(name = "product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements EntityInterface<String>{
    private String productId;
    private String pId;
    private String description;
    private double cost;
    private double sellingPrice;
    private int qtyOnHand;
    private int reOrderLevel;


    @Id
    @Column(name = "productId", nullable = false, insertable = true, updatable = true)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getpId() { return pId; }

    public void setpId(String pId) {this.pId = pId;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public int getReOrderLevel() {
        return reOrderLevel;
    }

    public void setReOrderLevel(int reOrderLevel) {
        this.reOrderLevel = reOrderLevel;
    }

    @Override
    @Transient
    public String getId() {
        return getProductId();
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", pId='" + pId + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", sellingPrice=" + sellingPrice +
                ", qtyOnHand=" + qtyOnHand +
                ", reOrderLevel=" + reOrderLevel +
                '}';
    }
}
