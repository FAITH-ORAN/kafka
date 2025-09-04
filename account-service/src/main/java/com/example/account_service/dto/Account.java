package com.example.account_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String accountId;
    private String accountCustomerName;
    private String accountCustomerEmail;
    private String accountCustomerPhone;
    private LocalDateTime accountCreatedAt;
    private double accountBalance;
}
