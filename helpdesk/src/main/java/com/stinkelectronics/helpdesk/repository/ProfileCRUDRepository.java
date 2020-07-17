package com.stinkelectronics.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stinkelectronics.helpdesk.model.Account;

public interface ProfileCRUDRepository extends JpaRepository<Account, Long>{
}
