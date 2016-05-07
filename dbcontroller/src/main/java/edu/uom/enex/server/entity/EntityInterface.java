package edu.uom.enex.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by Himashi Nethinika on 4/5/16.
 */
public interface EntityInterface <E> extends Serializable{


    @JsonIgnore
    public E getId();
}
