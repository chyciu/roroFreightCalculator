package pl.calculator.roro.roro_calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.calculator.roro.roro_calculator.entity.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Long> {

    List<Customer> findCustomerByCustomerDisplayedName(String filter);

}
