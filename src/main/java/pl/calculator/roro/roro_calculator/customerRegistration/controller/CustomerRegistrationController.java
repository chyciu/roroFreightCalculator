package pl.calculator.roro.roro_calculator.customerRegistration.controller;


import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.calculator.roro.roro_calculator.customerRegistration.entity.Customer;
import pl.calculator.roro.roro_calculator.customerRegistration.service.CustomerRegistrationService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerRegistrationController {

    private final CustomerRegistrationService customerRegistrationService;

    @GetMapping
    public List<Customer> findAllCustomers(@RequestParam(required = false) String filter) {
        return customerRegistrationService.findAll(filter);
    }

    @GetMapping("/{customerid}")
    public Customer findCustomer(@PathVariable Long cusomerId) {
        return customerRegistrationService.find(cusomerId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRegistrationService.createNewCustomer(customer);
    }


    @PutMapping("/(customerid}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long cusomerId) {
        customer.setCustomerId(cusomerId);
        return customerRegistrationService.updateCustomer(customer);
    }


    @DeleteMapping("/{customedid}")
    public void delateCustomer(@PathVariable Long customerIdToDelate) {
        customerRegistrationService.deleteCustomer(customerIdToDelate);
    }










}
