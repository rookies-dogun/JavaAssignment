package mylab.customer.dao.mapper;

import mylab.customer.vo.CustomerVO;

import java.util.List;

public interface CustomerMapper {


    List<CustomerVO> selectAllCustomer();
    CustomerVO selectCustomerById(int id);
    void insertCustomer(CustomerVO customer);
}
