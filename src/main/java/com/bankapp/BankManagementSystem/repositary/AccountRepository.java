package com.bankapp.BankManagementSystem.repositary;

import com.bankapp.BankManagementSystem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AccountRepository extends JpaRepository<Account,Long> {
}
