package com.example.shopcrud.controller;

import com.example.shopcrud.entity.Customer;
import com.example.shopcrud.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @RequestMapping({"/","/home"})
    public String home(Model model){
        model.addAttribute("customers",customerService.findAllCustomers());
        return "home";
    }
    @GetMapping("/save-customer")
    public String customerForm(Model model){
        model.addAttribute("customer",new Customer());
        return "customerForm";
    }
    @PostMapping("/save-customer")
    public String processCustomer(@Valid Customer customer, BindingResult result){
        if(result.hasErrors()){
            return  "customerForm";
        }
        customerService.createCustomer(customer);
        return "redirect:/home";
    }
    //http://localhost:8080/customer/delete?id=1
    @GetMapping("/customer/delete")
    public String deleteCustomer(@RequestParam("id")int id){
        customerService.deleteCustomer(id);
        return "redirect:/";
    }
    private int id;
    @GetMapping("/customer/update/{id}")
    public String updateCustomer(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findCustomerById(id));
        this.id=id;
        return "updateCustomer";
    }
    @PostMapping("/update/customer")
    public String updateSaveCustomer(@Valid Customer customer,BindingResult result){
        if(result.hasErrors()){
            return "updateCustomer";
        }
        customerService.updateCustomer(id,customer);
        return "redirect:/";
    }

}
