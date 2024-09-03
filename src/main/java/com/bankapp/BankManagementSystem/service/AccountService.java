package com.bankapp.BankManagementSystem.service;

import com.bankapp.BankManagementSystem.entity.Account;

import java.awt.*;
import java.util.List;

public interface AccountService {

    public Account createAccount(Account account);
    public Account getAccountDetailsByAccountNumber(Long accontNumber);
    public List<Account> getAllAccountDetails();
    public Account depositeMoney(Long accountNumber,Double amount);
    public Account withdraAmount(Long accountNumber,Double amount);
    public void closeAccount(Long accontNumber);
}
