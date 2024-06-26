package com.bankingAppsSpringboot.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankingAppsSpringboot.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}
