package com.bankapp.BankManagementSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name="account")
public class Account {
    @Override
    public String toString() {
        return "Account{" +
                "accountNamber=" + accountNamber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNamber;

    @Column
    private String accountHolderName;

    @Column
    private Double accountBalance;

    public Account(){

    }

    public Account(String accountHolderName, Double accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }

    public Long getAccountNamber() {
        return accountNamber;
    }

    public void setAccountNamber(Long accountNamber) {
        this.accountNamber = accountNamber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
