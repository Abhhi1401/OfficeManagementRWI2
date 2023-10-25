package in.railworld.app.service;

import in.railworld.app.model.Address;

public interface AddressService {
	
	 Address getAddressById(int id);
	 Address saveAddress(Address address);
	 void deleteAddress(int id);
	 
}
