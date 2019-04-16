package com.adwait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adwait.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
