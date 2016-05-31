package com.address.rest.validate;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.address.rest.DTO.AddressDTO;
import com.address.rest.util.AddressValidationUtil;
import com.address.rest.vo.AddressVO;

@Component
public class AddressValidator {
	
	// TO DO .. REPLACE WITH ENUM

		private static final int MAX_LENGTH_ADDRESSLINE1 = 500;
		private static final int MAX_LENGTH_ADDRESSLINE2 = 300;
		private static final int MAX_LENGTH_CITY = 100;

		private static final int MAX_LENGTH_STATE = 30;
		private static final int MAX_LENGTH_ZIP = 10;
		private static final int MAX_LENGTH_COUNTRY = 20;
	
	public boolean supports(Class clazz) {
        return AddressDTO.class.isAssignableFrom(clazz);
    }
 
//    public void validate(Object target, Errors errors) 
//    {
//    	checkFields((AddressDTO)target.g, state, country, city, addressLine1, addressLine2);
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "error.zip", "zip code is required.");
////       
////        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");
//    }

  public void checkFields(String zip, String state,String country, String city,String addressLine1) {
  AddressValidationUtil.notNull(zip, "Zip cannot be null");
  AddressValidationUtil.notEmpty(zip, "Zip cannot be empty");
    AddressValidationUtil.checkStringLength(zip,  MAX_LENGTH_ZIP,String.format( "zip code cannot be longer than %d characters",
            MAX_LENGTH_ZIP));

    AddressValidationUtil.notNull(country, "State cannot be null");
    AddressValidationUtil.notNull(state, "State cannot be null");
    AddressValidationUtil.notEmpty(state, "State cannot be empty");
    AddressValidationUtil.checkStringLength(state, MAX_LENGTH_STATE,String.format( "state code cannot be longer than %d characters",
    		MAX_LENGTH_STATE));
    
    AddressValidationUtil.notNull(country, "Country cannot be null");
    AddressValidationUtil.notNull(country, "Country cannot be null");
    AddressValidationUtil.notEmpty(country, "Country cannot be empty");
    AddressValidationUtil.checkStringLength(country, MAX_LENGTH_COUNTRY,String.format( "country name cannot be longer than %d characters",
    		MAX_LENGTH_COUNTRY));
    
    AddressValidationUtil.notNull(country, "City cannot be null");
    AddressValidationUtil.notNull(city, "City cannot be null");
    AddressValidationUtil.notEmpty(city, "City cannot be empty");
    AddressValidationUtil.checkStringLength(city, MAX_LENGTH_CITY,String.format( "city cannot be longer than %d characters",
    		MAX_LENGTH_STATE));
    
    AddressValidationUtil.notNull(country, "AddressLine1 cannot be null");
    AddressValidationUtil.notNull(addressLine1, "AddressLine1 cannot be null");
    AddressValidationUtil.notEmpty(addressLine1, "AddressLine1 cannot be empty");
    AddressValidationUtil.checkStringLength(addressLine1, MAX_LENGTH_ADDRESSLINE1,String.format( "addressLine1 cannot be longer than %d characters",
    		MAX_LENGTH_ADDRESSLINE1));
    

  
  
  }
    
    
}
