import com.gs.collections.api.list.ImmutableList;
import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.list.mutable.FastList;
import com.gs.collections.impl.test.Verify;
import com.netaporter.booty.domain.Customer;
import org.junit.Test;
import org.junit.Assert;

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
        //System.out.println(filteredCustomers);


    }

    @Test
    public void gsCollectionsTest() {
        /**
         * gs collection and lambdas
         */
        MutableList<Integer> expectedNames = FastList.newListWith(50,100,40);

        Verify.assertContainsAll(expectedNames.select(each -> each > 50),100);

        Verify.assertContainsAll(expectedNames.reject(each -> each > 50),50,40);


    }



}
