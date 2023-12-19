package com.example.shopcrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Past(message = "Date of Birth must be past.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotEmpty(message = "CashierName cannot be empty!")
    @NotBlank(message = "CashierName cannot be blank.")
    private String CashierName;
    @NotEmpty(message = "OrderNo cannot be empty!")
    @NotBlank(message = "OrderNo cannot be blank.")
    private String OrderNo;
    @NotEmpty(message = "QTy cannot be empty!")
    @NotBlank(message = "QTy cannot be blank.")
    private String QTy;
    @NotEmpty(message = "ItemName cannot be empty!")
    @NotBlank(message = "ItemName cannot be blank.")
    private String ItemName;
    @NotEmpty(message = "Rate cannot be empty!")
    @NotBlank(message = "Rate cannot be blank.")
    private String Rate;
    @NotEmpty(message = "Amount cannot be empty!")
    @NotBlank(message = "Amount cannot be blank.")
    private String Amount;

    public Customer(LocalDate dateOfBirth, String cashierName, String orderNo, String QTy, String itemName, String rate, String amount) {
        this.dateOfBirth = dateOfBirth;
        CashierName = cashierName;
        OrderNo = orderNo;
        this.QTy = QTy;
        ItemName = itemName;
        Rate = rate;
        Amount = amount;
    }

}
