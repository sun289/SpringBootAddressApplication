package com.addressservice.demo.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.addressservice.demo.dao.AddressRepository;
import com.addressservice.demo.model.Address;

@RestController
@Validated
@EnableAutoConfiguration
public class AddressController {

	@Autowired
	private AddressRepository repository;

	/**
	 * Method to create Address
	 * @param address
	 * @return
	 */
	@PostMapping(value = "/createAddress")
	@ResponseStatus(HttpStatus.OK)
	public Address saveAddress(@Valid @RequestBody Address address) {
		return repository.save(address);

	}
	
	/*
	 * Method to create Multiple Address lines
	 */

	@PostMapping("/createMulptiplAddress")
	public String saveAddress(@Valid @RequestBody List<Address> address) {
		repository.saveAll(address);
		return address.size() + " record saved..";
	}

	/**
	 * Method to get All the Address
	 * @return
	 */
	@GetMapping(value = "/getAllAddresses")
	@ResponseStatus(HttpStatus.OK)
	public List<Address> getallAddress() {
		return (List<Address>) repository.findAll();
	}

	/**
	 * Method to get Address By firstName
	 * @param firstname
	 * @return
	 */

	@GetMapping(value = "/getAddressByName/{firstname}")
	@ResponseStatus(HttpStatus.OK)
	public Address findAddressByName(@PathVariable String firstname) {
		return repository.findByFirstName(firstname);
	}

	/**
	 * Method to delete the address based on ID
	 * @param id
	 * @return
	 */

	@DeleteMapping(value = "/deleteAddress/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Address> delete(@PathVariable("id") long id) {
		repository.deleteById(id);
		return (List<Address>) repository.findAll();
	}
}
