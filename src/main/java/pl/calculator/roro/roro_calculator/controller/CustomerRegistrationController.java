package pl.calculator.roro.roro_calculator.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.calculator.roro.roro_calculator.dto.CustomerDTO;
import pl.calculator.roro.roro_calculator.service.CustomerRegistrationService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/customers")
public class CustomerRegistrationController {

    private final CustomerRegistrationService customerRegistrationService;

//    @GetMapping
//    public List<Customer> findAllCustomers(@RequestParam(required = false) String filter) {
//        return customerRegistrationService.findAll(filter);
//    }

//    @GetMapping("/{customerid}")
//    public Customer findCustomer(@PathVariable Long customerId) {
//        return customerRegistrationService.find(customerId);
//    }


//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping
//    public Customer addCustomer(@RequestBody Customer customer) {
//        return customerRegistrationService.createNewCustomer(customer);
//    }

    @GetMapping
    public String register () {

        return "customerRegistrationForm";
    }

    @PostMapping
    public String handleCustomerForm(@Valid @ModelAttribute(name = "customersForm") CustomerDTO customerDTO, BindingResult errors) {
        if (errors.hasErrors()) {
            return "customers";
        }
        customerRegistrationService.saveCurrentCustomer(customerDTO);
        return "redirect:/customers";
    }

    @ModelAttribute(name = "customersForm")
    public CustomerDTO produceCustomer () {
        return new CustomerDTO();
    }

//    @PutMapping("/(customerid}")
//    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
//        customer.setCustomerId(customerId);
//        return customerRegistrationService.updateCustomer(customer);
//    }


//    @DeleteMapping("/{customerid}")
//    public void delateCustomer(@PathVariable Long customerId) {
//        customerRegistrationService.deleteCustomer(customerId);
//    }

}
