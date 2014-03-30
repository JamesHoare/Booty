package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netaporter.booty.api.BootyController;
import com.netaporter.booty.domain.Customer;
import com.netaporter.booty.domain.CustomerCrudRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by jameshoare on 30/03/2014.
 */
public class BootyControllerTest {


    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testBootyController() throws Exception {


        final CustomerCrudRepository repository = mock(CustomerCrudRepository.class);

        final Customer customer = new Customer("James", "Hoare");
        stub(repository.findByCustomerId(1)).toReturn(customer);


        final BootyController controller = new BootyController(repository);
        final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();


        // Valid request
        mockMvc
                .perform(
                        get("http://localhost:9000/customer/1")

                )

                .andExpect(status().isOk())
                .andExpect(content().string(
                                objectMapper.writeValueAsString(new Customer("James", "Hoare")))
                );

        verify(repository, times(1)).findByCustomerId(1);


    }


}