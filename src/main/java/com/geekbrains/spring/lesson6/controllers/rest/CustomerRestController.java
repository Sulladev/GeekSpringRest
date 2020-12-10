package com.geekbrains.spring.lesson6.controllers.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.geekbrains.spring.lesson6.data.CustomerData;
import com.geekbrains.spring.lesson6.data.ProductData;
import com.geekbrains.spring.lesson6.entities.Customer;
import com.geekbrains.spring.lesson6.entities.Order;
import com.geekbrains.spring.lesson6.entities.views.CustomerView;
import com.geekbrains.spring.lesson6.entities.views.OrderView;
import com.geekbrains.spring.lesson6.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.lesson6.facade.CustomerFacade;
import com.geekbrains.spring.lesson6.services.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers/api/v1")
public class CustomerRestController {

    private CustomerService customerService;
    private CustomerFacade customerFacade;

    public CustomerRestController(CustomerService customerService, CustomerFacade customerFacade) {
        this.customerService = customerService;
        this.customerFacade = customerFacade;
    }

    @PostMapping
    public Customer createCustomer(
            @RequestBody Customer customer
    ) {
        customer.setId(null);   // при Post запросе индентификатор не нужен. Специально указан null
        return customerService.saveOrUpdate(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(
            @PathVariable("id") Long id
    ) {
        System.out.println("id = " + id);
        customerService.deleteById(id);
    }


    @GetMapping(value = "/fullCustomers", produces= MediaType.APPLICATION_JSON_VALUE)
    @JsonView(CustomerView.FullCustomer.class)
    public List<Customer> customersIdNameToJson(){
        return customerService.findAll();
    }



    @GetMapping(value = "/fullCustomersOrder")
    @JsonView(CustomerView.FullCustomerOrder.class)
    public List<Customer> fullCustomersOrderToJson(){
        return customerService.findAll();
    }


    @GetMapping(value = "/fullCustomerOrder/{id}")
    @JsonView(CustomerView.FullCustomerOrder.class)
    public Optional<Customer> fullCustomerOrderToJson(@PathVariable("id") Long id){
        return customerService.findById(id);
    }



    @GetMapping(value = "/jsonData/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CustomerData customerDataToJson(
            @PathVariable Long id
    ){
        return customerFacade.getCustomerById(id);
    }




    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerById(
            @PathVariable("id") Long id
    ) {
        return customerService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer id=" + id + " not found"));
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Customer> customersToXml() {
        return customerService.findAll();
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> customersToJson() {
        return customerService.findAll();
    }
}
