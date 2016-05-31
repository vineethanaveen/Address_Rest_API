package com.address.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.address.rest.DTO.AddressDTO;
import com.address.rest.error.AddressAppError;
import com.address.rest.error.AddressAppException;
import com.address.rest.service.IAddressService;
import com.address.rest.validate.AddressValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Rest API methods for CRUD operations of address object
 * 
 */
@RestController
@RequestMapping("/address")
public class    AddressRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressRestController.class);

	private final IAddressService service;
	
	@Autowired
	AddressValidator validator;
	
	@Autowired
	public AddressRestController(IAddressService service) {
		this.service = service;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST )
	@ResponseStatus(HttpStatus.CREATED)
	AddressDTO create(@RequestBody @Valid AddressDTO address,BindingResult result, SessionStatus status) throws AddressAppException {
				LOGGER.info("Creating a new address {}", address);
		     validator.checkFields(address.getZip(),address.getState(),address.getCountry(),address.getCity(),address.getAddressLine1());
	   	AddressDTO dto = service.create(address);
		LOGGER.info("Created a new address: {}", dto);

		return dto;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	AddressDTO delete(@PathVariable("id")String id) throws AddressAppException {
		LOGGER.info("Deleting address with id: {}", id);
		 

		AddressDTO dto = service.delete(id);
		LOGGER.info("Deleted todo address: {}", dto);

		return dto;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	List<AddressDTO> findAll() throws AddressAppException {
		LOGGER.info("get all addresses from database");

		List<AddressDTO> addresses = service.findAll();
		LOGGER.info("Number of Address entries in database", addresses.size());

		return addresses;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	AddressDTO findById(@PathVariable("id") String id) throws AddressAppException {
		LOGGER.info("find address corresponding to id: {}", id);

		AddressDTO dto = service.findById(id);
		LOGGER.info("Found address : {}", dto);

		return dto;
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
	AddressDTO update(@RequestBody @Valid AddressDTO newAddressDTO) throws AddressAppException {
		LOGGER.info("Updating address: {}", newAddressDTO);

		AddressDTO dto = service.update(newAddressDTO);
		LOGGER.info("Updated address: {}", dto);

		return dto;
	}

	
	@ExceptionHandler(AddressAppException.class)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public AddressAppError myError(HttpServletRequest request, AddressAppException exception) {
		LOGGER.error("Error Message: {}",exception.getLocalizedMessage());
		LOGGER.error("Error Code: {}",exception.geterrorCode());
		LOGGER.error("URL: {}",request.getRequestURL().toString());
	   AddressAppError error = new AddressAppError();
	    error.setErrorCode(Integer.valueOf(exception.geterrorCode()));
	    error.setErrorMessage(exception.getLocalizedMessage());
	    error.setUrl(request.getRequestURL().toString());
	    return error;
	}
	
}
