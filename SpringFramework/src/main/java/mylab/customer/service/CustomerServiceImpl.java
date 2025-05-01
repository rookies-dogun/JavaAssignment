package mylab.customer.service;

import mylab.customer.dao.CustomerDAO;
import mylab.customer.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;



    @Override
    public List<CustomerVO> getAllCustomers() {
        return customerDAO.selectAllCustomers();
    }

    @Override
    public CustomerVO getCustomerInfo(int id) {
        return customerDAO.selectCustomerById(id);
    }

    @Override
    public void insertCustomer(CustomerVO customer) {
        customerDAO.insertCustomer(customer);
    }
}
