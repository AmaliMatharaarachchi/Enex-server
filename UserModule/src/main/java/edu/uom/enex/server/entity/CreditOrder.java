package edu.uom.enex.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */

@Entity
@Table(name = "creditOrder")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditOrder extends Order implements EntityInterface<String>{

    private String customerName;
    private String dueDate;
    private double balnce;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public double getBalnce() {
        return balnce;
    }

    public void setBalnce(double balnce) {
        this.balnce = balnce;
    }
}
