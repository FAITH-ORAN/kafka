package com.example.base_domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String accountId;
    private String accountCustomerName;
    private String accountCustomerEmail;
    private String accountCustomerPhone;
    private Date accountCreatedAt;
    private double accountBalance;
}
