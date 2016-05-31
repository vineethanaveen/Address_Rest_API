package com.address.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.address.rest.DTO.AddressDTO;
import com.address.rest.error.AddressAppException;
import com.address.rest.repository.AddressRepository;
import com.address.rest.vo.AddressVO;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Address Service class has several methods for CRUD operations of address
 * object . It has additional methods as compared to AddressRepository
 */
@Service
@PropertySource(value = "messages.properties")
public class AddressService implements IAddressService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);

	private final AddressRepository repository;
	
	 @Autowired
	   private MessageSource messageSource;

	@Autowired
	private Environment env;
	
	private Locale locale = LocaleContextHolder.getLocale();
	
	
	@Autowired
	public AddressService(AddressRepository repository) {
		this.repository = repository;
	}

	@Override
	public AddressDTO create(AddressDTO dto) throws AddressAppException {

		LOGGER.info("Creating a new Address entry with information: {}", dto);

		AddressVO persisted = convertToVO(dto);
		try {
			persisted = repository.save(persisted);
		} catch (Exception e) {

			throw new AddressAppException(env.getProperty("address.save.errormessage"),
					env.getProperty("address.save.errorcode"));
		}
		LOGGER.info("Created a new AddressVO entry with information: {}", persisted);

		return convertToDTO(persisted);
	}

	@Override
	public AddressDTO delete(String id) throws AddressAppException {
		LOGGER.info("Deleting a AddressVO entry with id: {}", id);
		AddressVO deleted = null;
		try {
			deleted = findAddressVOById(id);

			repository.delete(deleted);
			
			
		} catch (Exception e) {

//			throw new AddressAppException(env.getProperty("address.delete.errormessage"),
//					env.getProperty("address.delete.errorcode"));
		
			
			// localization example - default locale
			throw new AddressAppException(messageSource.getMessage("address.delete.errormessage",null,locale),
					messageSource.getMessage("address.delete.errorcode",null,locale));
			

			//test error messages for a different locale
//			 locale = Locale.GERMANY;
//			throw new AddressAppException(messageSource.getMessage("address.delete.errormessage",null,locale),
//					messageSource.getMessage("address.delete.errorcode",null,locale));
			
		}

		LOGGER.info("Deleted AddressVO entry with informtation: {}", deleted);

		return convertToDTO(deleted);
	}

	@Override
	public List<AddressDTO> findAll() throws AddressAppException {
		LOGGER.info("Finding all AddressVO entries.");
		List<AddressVO> addressVOEntries = null;
		try {

			addressVOEntries = repository.findAll();
		} catch (Exception e) {

			throw new AddressAppException(env.getProperty("address.find.errormessage"),
					env.getProperty("address.find.errorcode"));
			
		
			// localization example - default locale
//			throw new AddressAppException(messageSource.getMessage("address.find.errormessage",null,locale),
//					messageSource.getMessage("address.find.errorcode",null,locale));
			

			//test error messages for a different locale
//			 locale = Locale.GERMANY;
//			throw new AddressAppException(messageSource.getMessage("address.find.errormessage",null,locale),
//					messageSource.getMessage("address.find.errorcode",null,locale));
		}

		LOGGER.info("Found {} AddressVO entries", addressVOEntries.size());

		return convertToDTOs(addressVOEntries);
	}

	private List<AddressDTO> convertToDTOs(List<AddressVO> models) {
		return models.stream().map(this::convertToDTO).collect(toList());
	}

	@Override
	public AddressDTO findById(String id) throws AddressAppException {
		AddressVO found = null;
		LOGGER.info("Finding AddressVO entry with id: {}", id);
		try {
			found = findAddressVOById(id);
		} catch (Exception e) {

			throw new AddressAppException(env.getProperty("address.find.errormessage"),
					env.getProperty("address.find.errorcode"));
		}

		LOGGER.info("Found AddressVO entry: {}", found);

		return convertToDTO(found);
	}

	@Override
	public AddressDTO update(AddressDTO addressVO) throws AddressAppException {
		LOGGER.info("Updating AddressVO entry with information: {}", addressVO);
		AddressVO updated = null;
		try {
			updated = findAddressVOById(addressVO.getId());
			updated.update(addressVO.getZip(), addressVO.getState(), addressVO.getAddressLine1(),
					addressVO.getAddressLine2(), addressVO.getCountry(), addressVO.getId());
			updated = repository.save(updated);
		} catch (Exception e) {

			throw new AddressAppException(env.getProperty("address.update.errormessage"),
					env.getProperty("address.update.errorcode"));
		}

		LOGGER.info("Updated AddressVO entry with information: {}", updated);

		return convertToDTO(updated);
	}

	private AddressVO findAddressVOById(String long1) throws AddressAppException {

		AddressVO result = repository.findOne(long1);
		return result;

	}

	private AddressDTO convertToDTO(AddressVO vo) {
		AddressDTO dto = new AddressDTO();

		dto.setId(vo.getIdx());
		dto.setZip(vo.getZip());
		dto.setState(vo.getState());
		dto.setAddressLine1(vo.getAddressLine1());
		dto.setAddressLine2(vo.getAddressLine2());
		dto.setCountry(vo.getCountry());

		return dto;
	}

	private AddressVO convertToVO(AddressDTO dto) {
		return new AddressVO(dto.getAddressLine1(), dto.getAddressLine2(), dto.getCity(), dto.getState(), dto.getZip(),
				dto.getCountry(), dto.getId());

	}
}
