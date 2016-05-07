package edu.uom.enex.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Himashi Nethinika on 4/6/2016.
 */

@MappedSuperclass
@Table(name = "invoice")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice implements EntityInterface<String>{
    private String invoiceId;
    private String orderId;

    public Invoice(String invoiceId, String orderId) {
        this.setInvoiceId(invoiceId);
        this.setOrderId(orderId);
    }


    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    @Transient
    public String getId() {
        return getInvoiceId();
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
