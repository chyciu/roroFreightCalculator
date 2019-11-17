package pl.calculator.roro.roro_calculator.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class EntityNotFoundException extends RuntimeException {

//    public Long customerIdNotFound;
//
//    public EntityNotFoundException(Long customerIdNotFound) {
//        super("Entity with Customer ID" + customerIdNotFound + "not found");
//        this.customerIdNotFound = customerIdNotFound;
//    }

}
