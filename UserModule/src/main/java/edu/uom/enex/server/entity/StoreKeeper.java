package edu.uom.enex.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
@Entity
@Table(name = "storeKeeper")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreKeeper extends User implements EntityInterface<String>{

}
