package pl.calculator.roro.roro_calculator.mapper;

import org.mapstruct.Mapper;
import pl.calculator.roro.roro_calculator.dto.CargoDetailsDTO;
import pl.calculator.roro.roro_calculator.entity.CargoDetails;

@Mapper(componentModel = "spring")
public interface CargoMapper {

    CargoDetails map(CargoDetailsDTO cargoDetailsDTO);

    CargoDetailsDTO map(CargoDetails entity);
}
