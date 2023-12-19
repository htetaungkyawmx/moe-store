package com.example.shopcrud.service;

import com.example.shopcrud.dao.CustomerDao;
import com.example.shopcrud.entity.Customer;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerDao customerDao;

    public List<Customer> findAllCustomers(){
        return customerDao.findAll();
    }
    public void deleteCustomer(int id){

        if (customerDao.existsById(id)){
            customerDao.deleteById(id);
        }
        else
            throw new EntityNotFoundException(id + "Not Found!");
    }

    public Customer findCustomerById(int id){
        return customerDao.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public void createCustomer(Customer customer) {
        customerDao.save(customer);
    }

    public void updateCustomer(int id, Customer customer) {
        customer.setId(id);
        customerDao.save(customer);
    }

}
