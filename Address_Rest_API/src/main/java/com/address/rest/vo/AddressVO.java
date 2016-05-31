package com.address.rest.vo;

import org.springframework.data.annotation.Id;


// Address VO Object
public class AddressVO 
 {
	 private static final int MAX_LENGTH_DESCRIPTION = 500;
	  private  static final int MAX_LENGTH_TITLE = 100;
	  
	  @Id
	private String idx;
	  
	  private String addressLine1;
		
		private String addressLine2;
		
		private String city;
		
		private String state;
		
		private String zip;
		
		private String country;
	
	
	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}
	
	
	

	public AddressVO() {
	}

	public AddressVO( String addressLine1,String addressLine2, String city,
			String state, String zip, String country,String id) {
		
		this.addressLine1 = addressLine1;
		this.addressLine2=addressLine2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.idx=id;
			}


	    public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCity() {
			return city;
		}
		
		  public void update(String zip, String State,String addressLIne1,String addressLine2,String country,String id) {
		      //  checkFields(zip, state,city,addressLine1,addressLine2,country,id);

		        this.zip = zip;
		        this.state= state;
		        this.addressLine1 = addressLIne1;
		        this.addressLine2= addressLine2;
		        this.country = country;
		        this.idx= id;
		        
		    }

		public void setCity(String city) {
			this.city = city;
		}

		public String getAddressLine2() {
			return addressLine2;
		}

		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}

		public String getAddressLine1() {
			return addressLine1;
		}

		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}


}
