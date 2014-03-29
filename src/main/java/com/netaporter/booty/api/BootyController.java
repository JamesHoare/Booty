package com.netaporter.booty.api;

import com.netaporter.booty.domain.Customer;
import com.netaporter.booty.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.*;

/**
 * Created by jameshoare on 28/03/2014.
 */
@RestController
public class BootyController {


    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/booty",produces = APPLICATION_JSON_VALUE)
    public String greetingBooty(){
        return "Hello Booty";
    }

    @RequestMapping(value = "/customer",method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public java.util.Collection<Customer> getCustomer() {
        return customerRepository.findAll();
    }





}
