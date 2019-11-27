package pl.calculator.roro.roro_calculator.mapper;

import org.mapstruct.Mapper;
import pl.calculator.roro.roro_calculator.dto.CustomerDTO;
import pl.calculator.roro.roro_calculator.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer map (CustomerDTO customerDTO);

    CustomerDTO map (Customer entity);
}
