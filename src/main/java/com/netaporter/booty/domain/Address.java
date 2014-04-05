package com.netaporter.booty.domain;

public class Address {

    public Address(String street, String postCode) {
        this.street = street;
        this.postCode = postCode;
    }


    @Override
    public String toString() {
        return String.format("Address[street=%s, postCode=%s]",  street, postCode);
    }

    private String street;
    private String postCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
