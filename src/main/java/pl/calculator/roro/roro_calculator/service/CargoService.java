package pl.calculator.roro.roro_calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import pl.calculator.roro.roro_calculator.dto.CargoDetailsDTO;
import pl.calculator.roro.roro_calculator.dto.CustomerDTO;
import pl.calculator.roro.roro_calculator.entity.CargoDetails;
import pl.calculator.roro.roro_calculator.entity.KindOfCargo;
import pl.calculator.roro.roro_calculator.repository.CargoRepository;


@RequiredArgsConstructor
@Service
public class CargoService {

    public final CargoRepository cargoRepository;

    private CargoDetails map(CargoDetailsDTO cargoDetailsDTO) {
        CargoDetails entity = new CargoDetails();
        entity.setKindOfCargo(cargoDetailsDTO.getKindOfCargo());
        entity.setNameOfCommodity(cargoDetailsDTO.getNameOfCommodity());
        entity.setWeight(cargoDetailsDTO.getWeight());
        entity.setLenght(cargoDetailsDTO.getLenght());
        entity.setWidth(cargoDetailsDTO.getWidth());
        entity.setHeight(cargoDetailsDTO.getHeight());
        return entity;
    }

    public void saveCargoDetails(CargoDetailsDTO cargoDetailsDTO) {
        CargoDetails entity = map(cargoDetailsDTO);
        cargoRepository.save(entity);
    }

    public Double cargoVolumeCalculatorAndChooserOfBiggerValue(CargoDetailsDTO cargoDetailsDTO) {
        Double cargoVolume = cargoDetailsDTO.getLenght() * cargoDetailsDTO.getHeight() * cargoDetailsDTO.getWidth();
        cargoDetailsDTO.setCargoVolume(cargoVolume);
        cargoDetailsDTO.setWeight(cargoDetailsDTO.getWeight());

            if (cargoVolume > 0 && cargoDetailsDTO.getWeight() > cargoVolume) {
                return cargoDetailsDTO.getWeight();
            } else if (cargoVolume > 0 && cargoVolume > cargoDetailsDTO.getWeight()) {
                return cargoVolume;
            } else {
                return cargoVolume;
            }
        }

     public String cargoInfoFromForm (CargoDetailsDTO cargoDetailsDTO, KindOfCargo kindOfCargo, CustomerDTO customerDTO) {
        String customer = customerDTO.getCustomerDisplayedName();
        String nameOfCargo = cargoDetailsDTO.getNameOfCommodity();
        String kindOfCargoFmForm = kindOfCargo.name();
        return customer + " / " + nameOfCargo + " / " + kindOfCargoFmForm;
     }


}

