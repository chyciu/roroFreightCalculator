package pl.calculator.roro.roro_calculator.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.calculator.roro.roro_calculator.dto.CustomerDTO;
import pl.calculator.roro.roro_calculator.entity.Customer;
import pl.calculator.roro.roro_calculator.mapper.CustomerMapper;
import pl.calculator.roro.roro_calculator.repository.CustomerRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerRegistrationService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;


//    public Customer map (CustomerDTO customerDTO) {
//        Customer entity = new Customer();
//        entity.setCustomerName(customerDTO.getCustomerName());
//        entity.setCustomerDisplayedName(customerDTO.getCustomerDisplayedName());
//        entity.setCustomerCity(customerDTO.getCustomerCity());
//        entity.setCustomerPostCode(customerDTO.getCustomerPostCode());
//        entity.setCustomerStreet(customerDTO.getCustomerStreet());
//        entity.setCustomerStrNumber(customerDTO.getCustomerStrNumber());
//        entity.setCustomerRoomNumber(customerDTO.getCustomerRoomNumber());
//        entity.setCustomerEmail(customerDTO.getCustomerEmail());
//        entity.setCustomerRegistrationDate(LocalDateTime.now());
//        return entity;
//    }
//
//    public void saveCurrentCustomer (CustomerDTO customerDTO) {
//        Customer entity = map(customerDTO);
//        customerRepository.save(entity);
//    }

    //above two methods and below one are the same.

    public CustomerDTO saveCurrentCustomer (CustomerDTO customerDTO) {
        Customer entity = customerMapper.map(customerDTO);
        Customer savedCustomer = customerRepository.save(entity);
        return customerMapper.map(savedCustomer);
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


    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer update = customerRepository.findById(customerDTO.getCustomerId())
                .orElseThrow(EntityNotFoundException::new);
        update.setCustomerName(customerDTO.getCustomerName());
        update.setCustomerDisplayedName(customerDTO.getCustomerDisplayedName());
        update.setCustomerCity(customerDTO.getCustomerCity());
        update.setCustomerPostCode(customerDTO.getCustomerPostCode());
        update.setCustomerStreet(customerDTO.getCustomerStreet());
        update.setCustomerStrNumber(customerDTO.getCustomerStrNumber());
        update.setCustomerRoomNumber(customerDTO.getCustomerRoomNumber());
        update.setCustomerEmail(customerDTO.getCustomerEmail());
        update.setCustomerRegistrationDate(customerDTO.getCustomerRegistrationDate());
        customerRepository.save(update);
        return customerMapper.map(update);
    }

    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(EntityNotFoundException::new);
        customerRepository.delete(customer);
    }
}
