package top.dimples;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.dimples.model.Customer;
import top.dimples.repository.CustomerRepository;

@SpringBootTest
class MyServerApplicationTests {

    @Autowired
    CustomerRepository customerRepository;


    @Test
    void contextLoads() {
        customerRepository.save(new Customer("颜", "杰"));
    }

}
