package com.address.rest.service;

import java.util.List;

import com.address.rest.DTO.AddressDTO;
import com.address.rest.error.AddressAppException;


/**
 * This interface declares the methods that provides CRUD operations for
 *address objects
 * 
 */
public interface IAddressService {

    /**
     * Creates a new address entry.
     * @param address  The information of the created address entry.
     * @return      The information of the created address entry.
     * @throws AddressAppException 
     */
    AddressDTO create(AddressDTO address) throws AddressAppException;

    /**
     * Deletes a address entry.
     * @param id    The id of the deleted address entry.
     * @return      THe information of the deleted address entry.
     * @throws AddressAppException 
     * @throws com.address.rest.error.AddressNotFoundException if no address entry is found.
     */
    AddressDTO delete(String id) throws AddressAppException;

    /**
     * Finds all address entries.
     * @return      The information of all address entries.
     * @throws AddressAppException 
     */
    List<AddressDTO> findAll() throws AddressAppException;

    /**
     * Finds a single address entry.
     * @param id    The id of the requested address entry.
     * @return      The information of the requested address entry.
     * @throws AddressAppException 
     * @throws com.address.rest.error.AddressNotFoundException if no address entry is found.
     */
    AddressDTO findById(String id) throws AddressAppException;

    /**
     * Updates the information of a address entry.
     * @param address  The information of the updated address entry.
     * @return      The information of the updated address entry.
     * @throws AddressAppException 
     * @throws com.address.rest.error.AddressNotFoundException if no address entry is found.
     */
    AddressDTO update(AddressDTO address) throws AddressAppException;
}
