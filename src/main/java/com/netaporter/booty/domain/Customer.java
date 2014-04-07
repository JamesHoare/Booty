package com.netaporter.booty.domain;

import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.list.mutable.FastList;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by jameshoare on 29/03/2014.
 */
@Entity
public class Customer implements Serializable, CustomerOperations {

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName=%s, lastName=%s]", customerId, firstName, lastName);
    }

    protected Customer() {

    }

    @Transient
    public MutableList<Address> getShippingAddress() {
        return shippingAddress;
    }

    public enum Type { EIP, NORMAL}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @Transient
    private MutableList<Address> shippingAddress = FastList.newListWith(new Address("grant road","rg45 7jg"));


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    @NotEmpty(message = "First name is required")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    private String lastName;



    public static boolean isJames(Customer customer) {
        return "James".equals(customer.getFirstName());
    }


    /**
     *
     * @param customers
     * @param p
     * @retur filtered List of customer by predicates
     */
    public static List<Customer> filterCustomers(List<Customer> customers, Predicate<Customer> p){
        List<Customer> result = new ArrayList<>();
        for(Customer customer : customers){
            if(p.test(customer)){
                result.add(customer);
            }
        }
        return result;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}


