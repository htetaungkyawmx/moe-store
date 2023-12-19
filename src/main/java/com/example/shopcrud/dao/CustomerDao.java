package com.example.shopcrud.dao;

import com.example.shopcrud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

}
