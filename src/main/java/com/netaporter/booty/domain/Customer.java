package com.netaporter.booty.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

/**
 * Created by jameshoare on 29/03/2014.
 */
@Entity
public class Customer {

    @Override
    public String toString() {
        return super.toString();
    }

    @Id
    @GeneratedValue
    private Long customerId;
    private String name;


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
