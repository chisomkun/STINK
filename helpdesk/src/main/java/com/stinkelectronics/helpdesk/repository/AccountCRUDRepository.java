package com.stinkelectronics.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stinkelectronics.helpdesk.model.Account;

public interface AccountCRUDRepository extends JpaRepository<Account, Integer>{
}
