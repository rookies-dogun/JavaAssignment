package mylab.customer.dao;

import mylab.customer.vo.CustomerVO;

import java.util.List;

public interface CustomerDAO {

    List<CustomerVO> selectAllCustomers();
    CustomerVO selectCustomerById(int id);
    void insertCustomer(CustomerVO customer);
}
