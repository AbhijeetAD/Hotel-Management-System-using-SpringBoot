package com.example.demo.service.Impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Customer;
import com.example.demo.entity.Room;
import com.example.demo.exceptionhandling.CustomerNotFoundException;
import com.example.demo.exceptionhandling.RoomNotFoundException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(int customerId, Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(customerId).orElse(null);

        if (existingCustomer != null) {
            existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
            existingCustomer.setAadharNumber(updatedCustomer.getAadharNumber());
            existingCustomer.setMobileNumber(updatedCustomer.getMobileNumber());

            return customerRepository.save(existingCustomer);
        } else {
            throw new CustomerNotFoundException(customerId);
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    @Override
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

	@Override
	public Customer addRoomToCustomer(int customerId, int roomId) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException(customerId));
		
		Room room=roomRepository.findById(roomId)
				.orElseThrow(() -> new RoomNotFoundException(roomId));
		
		customer.getRooms().add(room);
		room.getCustomers().add(customer);
		
		customerRepository.save(customer);
		roomRepository.save(room);
		return customer;
	}
}