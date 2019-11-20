package pl.calculator.roro.roro_calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.calculator.roro.roro_calculator.dto.CargoDetailsDTO;
import pl.calculator.roro.roro_calculator.entity.CargoDetails;
import pl.calculator.roro.roro_calculator.repository.CargoRepository;


@RequiredArgsConstructor
@Service
public class CargoService {

    public final CargoRepository cargoRepository;

    public CargoDetails map (CargoDetailsDTO cargoDetailsDTO) {
        CargoDetails entity = new CargoDetails();
        entity.setKindOfCargo(cargoDetailsDTO.getKindOfCargo());
        entity.setNameOfCommodity(cargoDetailsDTO.getNameOfCommodity());
        entity.setWeight(cargoDetailsDTO.getWeight());
        entity.setLenght(cargoDetailsDTO.getLenght());
        entity.setWidth(cargoDetailsDTO.getWidth());
        entity.setHeight(cargoDetailsDTO.getHeight());
        return entity;
    }

    public void saveCargoDetails (CargoDetailsDTO cargoDetailsDTO) {
        CargoDetails entity = map(cargoDetailsDTO);
        cargoRepository.save(entity);
    }

    public double cargoVolumeCalculatorAndChooserOfBiggerValue (CargoDetailsDTO cargoDetailsDTO) {
       double cargoVolume = Math.round(cargoDetailsDTO.getLenght() * cargoDetailsDTO.getHeight() * cargoDetailsDTO.getWidth());

        if (cargoDetailsDTO.getWeight() > cargoVolume) {
            return cargoDetailsDTO.getWeight();
        } else if (cargoVolume > cargoDetailsDTO.getWeight()) {
            return cargoVolume;
        } else {
            return cargoVolume;
        }
    }
}
