package pl.calculator.roro.roro_calculator.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.calculator.roro.roro_calculator.dto.CustomerDTO;
import pl.calculator.roro.roro_calculator.entity.Customer;
import pl.calculator.roro.roro_calculator.mapper.CustomerMapper;
import pl.calculator.roro.roro_calculator.repository.CustomerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerRegistrationService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;


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
