package com.bankapp.BankManagementSystem.service;

import com.bankapp.BankManagementSystem.entity.Account;
import com.bankapp.BankManagementSystem.repositary.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository repo;
    @Override
    public Account createAccount(Account account) {

        Account save = repo.save(account);
        return save;
    }

    @Override
    public Account getAccountDetailsByAccountNumber(Long accontNumber) {
        Optional<Account> account = repo.findById(accontNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account is not present");
        }

            Account accountFound=account.get();


        return accountFound;
    }

    @Override
    public List<Account> getAllAccountDetails() {

        List<Account> all = repo.findAll();
        return all;
    }

    @Override
    public Account depositeMoney(Long accountNumber, Double amount) {

        Optional<Account> account = repo.findById(accountNumber);

        if(account.isEmpty()){
            throw  new RuntimeException("Account is not present");
        }
        Account accountPresent=account.get();
       Double totalBalance= accountPresent.getAccountBalance()+amount;
       accountPresent.setAccountBalance(totalBalance);
       repo.save(accountPresent);
        return accountPresent;
    }

    @Override
    public Account withdraAmount(Long accountNumber, Double amount) {
        Optional<Account> account = repo.findById(accountNumber);

        if(account.isEmpty()){
            throw  new RuntimeException("Account is not present");
        }
        Account accountPresent=account.get();

            Double oldBalance=accountPresent.getAccountBalance();
            Double accountBalance= accountPresent.getAccountBalance();
        if(amount >= oldBalance){
             ResponseEntity.status(HttpStatus.ACCEPTED).body("Account closed");
        } else {
            accountBalance= accountPresent.getAccountBalance()-amount;
            accountPresent.setAccountBalance(accountBalance);
            repo.save(accountPresent);

        }
        return accountPresent;
    }

    @Override
    public void closeAccount(Long accountNumber) {

        getAccountDetailsByAccountNumber(accountNumber);

        repo.deleteById(accountNumber);

    }
}
