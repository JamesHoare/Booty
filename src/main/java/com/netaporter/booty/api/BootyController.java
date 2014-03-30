package com.netaporter.booty.api;

import com.netaporter.booty.domain.Customer;
import com.netaporter.booty.domain.CustomerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by jameshoare on 28/03/2014.
 */
@RestController
public class BootyController {

    private CustomerCrudRepository customerRepository;

    @Autowired
    public BootyController(final CustomerCrudRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/booty")
    public @ResponseBody String greetingBooty(){
        return "Hello Booty";
    }

    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public @ResponseBody
    List<Customer> getCustomer() {
        return customerRepository.findAll();
    }


    @RequestMapping(value="/customer/{customerId}", method = RequestMethod.GET)
    public @ResponseBody Customer getCustomerById(@PathVariable("customerId")  Integer customerId) {
          Optional<Customer> c =  Optional.of(customerRepository.findByCustomerId(customerId));
          return c.orElseThrow(IllegalStateException::new);


    }





}
