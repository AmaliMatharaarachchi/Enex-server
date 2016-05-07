package edu.uom.enex.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Himashi Nethinika on 4/6/2016.
 */
@Entity
@Table(name = "GatePass")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GatePass implements EntityInterface<String>{

    private String invoiceId;
    private String driverId;
    private String confirmedUser;


    @Id
    @Column(name = "invoiceId", nullable = false, insertable = true, updatable = true)
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getConfirmedUser() {
        return confirmedUser;
    }

    public void setConfirmedUser(String confirmedUser) {
        this.confirmedUser = confirmedUser;
    }

    @Override
    @Transient
    public String getId() {
        return getInvoiceId();
    }

    @Override
    public String toString() {
        return "GatePass{" +
                "invoiceId='" + invoiceId + '\'' +
                ", driverId='" + driverId + '\'' +
                ", confirmedUser='" + confirmedUser + '\'' +
                '}';
    }
}

