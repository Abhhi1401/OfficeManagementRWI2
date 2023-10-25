package in.railworld.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.railworld.app.model.Address;


public interface AddressRepository extends JpaRepository<Address, Integer>{

}

