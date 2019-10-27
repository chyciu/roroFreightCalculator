package pl.calculator.roro.roro_calculator.customerRegistration.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.calculator.roro.roro_calculator.customerRegistration.entity.Customer;
import pl.calculator.roro.roro_calculator.customerRegistration.repository.CustomerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerRegistrationService {

    public final CustomerRepository customerRepository;

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
        update.setCustomerAddress(customer.getCustomerAddress());
        update.setCustomerEmail(customer.getCustomerEmail());
        update.setCustomerRegistrationDate(customer.getCustomerRegistrationDate());
        return update;
    }

    public void deleteCustomer(Long customerIdToDelete) {
        Customer customer = customerRepository.findById(customerIdToDelete)
                .orElseThrow(EntityNotFoundException::new);
        customerRepository.delete(customer);
    }
}
