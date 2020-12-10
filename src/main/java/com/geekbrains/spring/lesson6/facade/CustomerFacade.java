package com.geekbrains.spring.lesson6.facade;

import com.geekbrains.spring.lesson6.data.CustomerData;
import com.geekbrains.spring.lesson6.data.ProductData;
import com.geekbrains.spring.lesson6.entities.Customer;
import com.geekbrains.spring.lesson6.populators.CustomerPopulator;
import com.geekbrains.spring.lesson6.repositories.CustomerRepository;
import com.geekbrains.spring.lesson6.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerFacade {

    private CustomerService customerService;
    private CustomerPopulator customerPopulator;
    private CustomerRepository customerRepository;


    public CustomerFacade(CustomerService customerService, CustomerPopulator customerPopulator, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerPopulator = customerPopulator;
        this.customerRepository = customerRepository;
    }


    public CustomerData getCustomerById(Long id) {
        Customer customer = customerService.findById(id).get();
        CustomerData customerData = new CustomerData();
        customerData.setId(customer.getId());
        customerData.setName(customer.getName());
        customerData.setBirthday(customer.getBirthday());
        customerData.setCreateDate(customer.getCreateDate());
//        customerData.setOrders(customer.getOrders());
        return customerData;
    }

    public List<CustomerData> getAllCustomerData(){
        return customerPopulator.convertAll(customerService.findAll());
    }
}
