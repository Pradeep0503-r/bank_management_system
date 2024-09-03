package com.bankapp.BankManagementSystem.controller;

import com.bankapp.BankManagementSystem.entity.Account;
import com.bankapp.BankManagementSystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService service;
    @PostMapping("/create")
    public ResponseEntity<Account>  createAccount(@RequestBody Account account){

        Account createAccount = service.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount) ;
    }

    @GetMapping("/{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable Long accountNumber){
        Account account = service.getAccountDetailsByAccountNumber(accountNumber);
        return account;
    }
    @GetMapping("/getallaccounts")
    public List<Account> getAllAccounts(){
        List<Account> allAccountDetails = service.getAllAccountDetails();
        return allAccountDetails;
    }
    @PutMapping("/deposite/{accountNumber}/{amount}")
    public Account depositeAccount(@PathVariable Long accountNumber,@PathVariable Double amount){
        Account account = service.depositeMoney(accountNumber, amount);
        return account;


    }
    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawAccount(@PathVariable Long accountNumber,@PathVariable Double amount) {
        Account account = service.withdraAmount(accountNumber, amount);
            return account;
            }


    @DeleteMapping("/delete/{accountNumber}")
    public   ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber){

        service.closeAccount(accountNumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account closed");
    }
}
