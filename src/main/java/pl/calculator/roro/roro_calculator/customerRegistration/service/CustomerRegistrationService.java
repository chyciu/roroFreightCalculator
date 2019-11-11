package pl.calculator.roro.roro_calculator.customerRegistration.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.calculator.roro.roro_calculator.customerRegistration.dto.CustomerDTO;
import pl.calculator.roro.roro_calculator.customerRegistration.entity.Customer;
import pl.calculator.roro.roro_calculator.customerRegistration.repository.CustomerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerRegistrationService {

    public final CustomerRepository customerRepository;
    private CustomerDTO customerDTO;

    public void create (Customer customerDTO) {
        Customer entity = new Customer();
        entity.setCustomerName(customerDTO.getCustomerName());
        entity.setCustomerDisplayedName(customerDTO.getCustomerDisplayedName());
        entity.setCustomerCity(customerDTO.getCustomerCity());
        entity.setCustomerPostCode(customerDTO.getCustomerPostCode());
        entity.setCustomerStreet(customerDTO.getCustomerStreet());
        entity.setCustomerStrNumber(customerDTO.getCustomerStrNumber());
        entity.setCustomerRoomNumber(customerDTO.getCustomerRoomNumber());
        entity.setCustomerEmail(customerDTO.getCustomerEmail());
        entity.setCustomerRegistrationDate(customerDTO.getCustomerRegistrationDate());
    }

    public void saveCurrentCustomer (CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
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
