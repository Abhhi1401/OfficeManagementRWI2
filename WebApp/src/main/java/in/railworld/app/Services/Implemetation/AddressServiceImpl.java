package in.railworld.app.Services.Implemetation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.railworld.app.model.Address;
import in.railworld.app.repository.AddressRepository;
import in.railworld.app.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	private final AddressRepository addressRepository;
	
	

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
	
	
	


	
	@Override
    public void deleteAddress(int id) {
        addressRepository.deleteById(id);
    }




	@Override
	public Address getAddressById(int id) {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public Address saveAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	
}
