package pl.calculator.roro.roro_calculator.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.calculator.roro.roro_calculator.dto.CustomerDTO;
import pl.calculator.roro.roro_calculator.service.CustomerRegistrationService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/customers")
public class CustomerRegistrationController {

    private final CustomerRegistrationService customerRegistrationService;


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


}
