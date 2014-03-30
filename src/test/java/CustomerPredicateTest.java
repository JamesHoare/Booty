import com.netaporter.booty.domain.Customer;
import org.junit.Test;

import java.util.stream.*;
import java.util.*;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import static com.netaporter.booty.domain.Customer.*;

/**
 * Created by jameshoare on 30/03/2014.
 */
public class CustomerPredicateTest {

    @Test
    public void customerFilterByName() {

        List<Customer> customer = Arrays.asList(new Customer("James", "Hoare"),
                new Customer("foo", "bar"),
                new Customer("duck", "fuzzy"));


        filterCustomers(customer, c -> c.getFirstName().equals("duck"));

        List<Customer> filteredCustomers =
                customer.parallelStream().filter((Customer c) -> c.getFirstName().equals("James")).collect(toList());

        //List<Customer> filteredCustomers = filterCustomers(customer, Customer::isJames);
        System.out.println(filteredCustomers);



    }



}
