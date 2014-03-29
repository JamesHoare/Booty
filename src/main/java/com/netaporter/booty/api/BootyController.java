package com.netaporter.booty.api;

import com.netaporter.booty.domain.Customer;
import com.netaporter.booty.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

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
    public Collection<Customer> getCustomer() {
        return customerRepository.findAll();
    }


    @RequestMapping
    public Optional<Customer> getCustomerById(@RequestParam(value = "id", required = true) Integer id) {
          return customerRepository.findByCustomerId(id);
          //todo learn optional


    }





}
