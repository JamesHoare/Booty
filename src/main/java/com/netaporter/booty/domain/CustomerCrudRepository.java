package com.netaporter.booty.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by jameshoare on 29/03/2014.
 */

public interface CustomerCrudRepository extends JpaRepository<Customer,Integer> {

    Customer findByCustomerId(Integer customerId);
}







