package com.addressservice.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.sun.istack.Nullable;

@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotNull(message = "FirstName is required")
	@Size(min = 2, message = "FirstName must not be less than 2 characters")
	@Size(max = 256, message = "FirstName must not be more than 256 characters")
	private String firstName;

	@Column
	private String lastName;

	@Column
	@NotNull(message = "StreetName is required")
	private String streetName;

	@Column
	@Nullable
	private String houseNumber;

	@Column
	@NotNull(message = "Zipcode is required")
	@Size(min = 5, message = "Zipcode must have minimum 5 digit")
	@Size(max = 9, message = "Zipcode must have maximum 9 digit")
	private String zipCode;

	@Column
	@NotNull(message = "Location is required")
	private String location;

	/*
	 * Constructor with No Arguments
	 */

	public Address() {
		super();
	}

	/*
	 * get and set method
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	/*
	 * Parametrised constructor
	 */

	public Address(Long id,
			@NotNull(message = "FirstName is required") @Size(min = 2, message = "FirstName must not be less than 2 characters") String firstName,
			String lastName, @NotNull(message = "StreetName is required") String streetName, String houseNumber,
			@NotNull(message = "Zipcode is required") @Size(min = 5, message = "Zipcode must have minimum 5 digit") @Size(max = 9, message = "Zipcode must have maximum 9 digit") String zipCode,
			@NotNull(message = "Location is required") String location) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetName = streetName;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		this.location = location;
	}

}
