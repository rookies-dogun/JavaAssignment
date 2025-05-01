package mylab.customer;


import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:customer/customer.xml")
public class CustomerSpringTest {
    protected static final Logger logger = LogManager.getLogger();



    @Autowired
    CustomerService customerService;

    @Test
    public void insertCustomer() {
        customerService.insertCustomer(new CustomerVO("test@gmail.com", "test", LocalDate.now(), 20));
        customerService.insertCustomer(new CustomerVO("rookies@gmail.com", "rookies", LocalDate.now(), 22));
        customerService.insertCustomer(new CustomerVO("boot@gmail.com", "boot", LocalDate.now(), 24));
        customerService.insertCustomer(new CustomerVO("spring@gmail.com", "spring", LocalDate.now(), 26));
    }

    @Test
    public void getCustomers(){
        customerService.getAllCustomers().forEach(logger::debug);
    }

    @Test
    public void getCustomerById() {
        customerService.getCustomerInfo(1);
    }
}
