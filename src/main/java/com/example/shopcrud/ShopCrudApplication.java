package com.example.shopcrud;

import com.example.shopcrud.dao.CustomerDao;
import com.example.shopcrud.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ShopCrudApplication {
    private final CustomerDao customerDao;
    @Bean @Profile("dev")
    public ApplicationRunner runner(){
        return r->{
            List.of(
                    new Customer(LocalDate.now(),"MyoGyi","pos-19-12-2023","2","STING ENERGY DRINK","1300","2600"),
                    new Customer(LocalDate.now(),"MyoGyi","pos-19-12-2023","5","Pillow Bread","1100","5500"),
                    new Customer(LocalDate.now(),"MyoGyi","pos-19-12-2023","10","Yum Yum","500","5000"),
                    new Customer(LocalDate.now(),"MyoGyi","pos-19-12-2023","3","Lipo","1000","3000"),
                    new Customer(LocalDate.now(),"MyoGyi","pos-19-12-2023","1","Shark ENERGY DRINK","1600","1600")
            );
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopCrudApplication.class, args);
    }

}
