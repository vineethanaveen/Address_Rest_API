package com.address.rest.repository;

import org.springframework.data.repository.Repository;

import com.address.rest.vo.AddressVO;


import java.util.List;
import java.util.Optional;

/**
 * This repository provides CRUD operations for addressVO}
 * 
 * 
 */
public interface AddressRepository extends Repository<AddressVO, String> {

    /**
     * Deletes a AddressVO entry from the database.
     * 
     */
    void delete(AddressVO deleted);

    /**
     * Finds all AddressVO entries from the database.
     *
     */
    List<AddressVO> findAll();

    /**
     * Finds AddressVO entry. corrsponding to an id
     *
     */
    AddressVO findOne(String id);

    /**
     * Saves a new AddressVO entry to the database.
     *
     */
    AddressVO save(AddressVO saved);
}
