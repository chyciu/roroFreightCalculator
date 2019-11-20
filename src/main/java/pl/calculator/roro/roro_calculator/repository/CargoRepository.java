package pl.calculator.roro.roro_calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.calculator.roro.roro_calculator.dto.CargoDetailsDTO;
import pl.calculator.roro.roro_calculator.entity.CargoDetails;

import java.util.List;


public interface CargoRepository extends JpaRepository <CargoDetails, Long> {

    List<CargoDetails> findCargoDetailsByKindOfCargoEquals (String filter);


}
