import com.gs.collections.api.list.MutableList;
import com.gs.collections.api.partition.list.PartitionMutableList;
import com.gs.collections.impl.factory.Lists;
import com.gs.collections.impl.list.mutable.FastList;
import com.netaporter.booty.domain.Address;
import com.netaporter.booty.domain.Customer;
import org.junit.Test;

import java.util.List;

import static com.gs.collections.impl.test.Verify.assertContainsAll;
import static com.gs.collections.impl.test.Verify.assertSize;
import static com.netaporter.booty.domain.Customer.filterCustomers;
import static java.util.stream.Collectors.toList;

/**
 * Created by jameshoare on 30/03/2014.
 */
public class CustomerPredicateTest {

    private MutableList<Customer> customer = FastList.newListWith(new Customer("James", "Hoare"),
            new Customer("foo", "bar"),
            new Customer("duck", "fuzzy"));

    @Test
    public void customerFilterByName() {

        filterCustomers(customer, c -> c.getFirstName().equals("duck"));

        List<Customer> filteredCustomers =
                customer.parallelStream().filter((Customer c) -> c.getFirstName().equals("James")).collect(toList());


    }

    /**
     * gs collection and lambdas
     */
    @Test
    public void gsCollectionsTest() {

        MutableList<Integer> expectedNames = FastList.newListWith(50, 100, 40);

        assertContainsAll(expectedNames.select(each -> each > 50), 100);

        assertContainsAll(expectedNames.reject(each -> each > 50), 50, 40);


    }

    /**
     * Partition Customer
     */
    @Test
    public void partitionCustomer() {

        PartitionMutableList<Customer> partitionedFolks = customer.partition(customer ->
                customer.getFirstName().equals("James"));

        assertContainsAll(partitionedFolks.getSelected(), customer.get(0));
        assertSize(1, partitionedFolks.getSelected());
        assertSize(2, partitionedFolks.getRejected());

        MutableList<Address> flatCustomer = customer.flatCollect(c -> c.getShippingAddress());
        assertSize(3, flatCustomer);

        //System.out.println(customer.stream().map(Customer::getCustomerId).reduce(0, (x, y) -> x + y));




    }


}
