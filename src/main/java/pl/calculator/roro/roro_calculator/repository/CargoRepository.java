package pl.calculator.roro.roro_calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.calculator.roro.roro_calculator.entity.CargoKindAndDimensionsAndWeight;


public interface CargoRepository extends JpaRepository <CargoKindAndDimensionsAndWeight, Long> {


}
