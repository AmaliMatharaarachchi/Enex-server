package edu.uom.enex.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */

//@Entity
//@Table(name = "companyCustomer")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyCustomer extends Customer implements EntityInterface<String> {
    private String VAT;
    private String NBT;


    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getNBT() {
        return NBT;
    }

    public void setNBT(String NBT) {
        this.NBT = NBT;
    }
}
