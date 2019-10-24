package pl.calculator.roro.roro_calculator.customerRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.calculator.roro.roro_calculator.customerRegistration.entity.Customer;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Long> {

    List<Customer> findCustomerByCustomerDisplayedName(String filter);

    List<Customer> findCustomerByCustomerRegistrationDate (LocalDateTime dateOfRegistration);


}
