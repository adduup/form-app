package com.adwait.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.adwait.model.Address;
import com.adwait.repository.AddressRepository;

@Service
@Transactional
public class AddressService {

	private final AddressRepository addressRepository;

	public AddressService(AddressRepository addressRepository) {
		super();
		this.addressRepository = addressRepository;
	}

	public void saveAddress(Address address) {
		addressRepository.save(address);
	}

	public List<Address> showAllAddresses() {
		List<Address> addresses = new ArrayList<>();
		for (Address address : addressRepository.findAll()) {
			addresses.add(address);
		}
		return addresses;
	}

	public void deleteAddress(int id) {
		addressRepository.deleteById(id);
	}

	public Address findAddressById(int id) {
		Optional<Address> result = addressRepository.findById(id);
		Address address = null;
		if (result.isPresent()) {
			address = result.get();
		} else {
			throw new RuntimeException("Did not find address id -" + id);
		}
		return address;
	}

}
