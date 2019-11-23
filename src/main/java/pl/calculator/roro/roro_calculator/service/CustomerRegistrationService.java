package pl.calculator.roro.roro_calculator.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.calculator.roro.roro_calculator.dto.CustomerDTO;
import pl.calculator.roro.roro_calculator.entity.Customer;
import pl.calculator.roro.roro_calculator.repository.CustomerRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerRegistrationService {

    public final CustomerRepository customerRepository;


    public Customer map (CustomerDTO customerDTO) {
        Customer entity = new Customer();
        entity.setCustomerName(customerDTO.getCustomerName());
        entity.setCustomerDisplayedName(customerDTO.getCustomerDisplayedName());
        entity.setCustomerCity(customerDTO.getCustomerCity());
        entity.setCustomerPostCode(customerDTO.getCustomerPostCode());
        entity.setCustomerStreet(customerDTO.getCustomerStreet());
        entity.setCustomerStrNumber(customerDTO.getCustomerStrNumber());
        entity.setCustomerRoomNumber(customerDTO.getCustomerRoomNumber());
        entity.setCustomerEmail(customerDTO.getCustomerEmail());
        entity.setCustomerRegistrationDate(LocalDateTime.now());
        return entity;
    }

    public void saveCurrentCustomer (CustomerDTO customerDTO) {
        Customer entity = map(customerDTO);
        customerRepository.save(entity);
    }

    public List<Customer> findAll(String filter) {
        if (StringUtils.isEmpty(filter)) {
            return customerRepository.findAll();
        }
        return customerRepository.findCustomerByCustomerDisplayedName("%" + filter + "%");
    }

    public Customer find(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Customer createNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        Customer update = customerRepository.findById(customer.getCustomerId())
                .orElseThrow(EntityNotFoundException::new);
        update.setCustomerName(customer.getCustomerName());
        update.setCustomerDisplayedName(customer.getCustomerDisplayedName());
        update.setCustomerCity(customer.getCustomerCity());
        update.setCustomerPostCode(customer.getCustomerPostCode());
        update.setCustomerStreet(customer.getCustomerStreet());
        update.setCustomerStrNumber(customer.getCustomerStrNumber());
        update.setCustomerRoomNumber(customer.getCustomerRoomNumber());
        update.setCustomerEmail(customer.getCustomerEmail());
        update.setCustomerRegistrationDate(customer.getCustomerRegistrationDate());
        return update;
    }

    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(EntityNotFoundException::new);
        customerRepository.delete(customer);
    }
}
