package com.stinkelectronics.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stinkelectronics.helpdesk.model.Profile;

public interface ProfileCRUDRepository extends JpaRepository<Profile, Long>{
}
