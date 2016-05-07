package edu.uom.enex.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
@Entity
@Table(name = "region")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Region implements EntityInterface<String>{
    private String regId;
    private String name;

    @Id
    @Column(name = "regId", nullable = false, insertable = true, updatable = true)
    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    @Transient
    public String getId() {
        return getRegId();
    }

    @Override
    public String toString() {
        return "Region{" +
                "regId='" + regId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
