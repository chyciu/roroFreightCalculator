package pl.calculator.roro.roro_calculator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;
import pl.calculator.roro.roro_calculator.dto.CargoDetailsDTO;
import pl.calculator.roro.roro_calculator.dto.CustomerDTO;
import pl.calculator.roro.roro_calculator.entity.CargoDetails;
import pl.calculator.roro.roro_calculator.mapper.CargoMapper;
import pl.calculator.roro.roro_calculator.repository.CargoRepository;


@Slf4j
@RequiredArgsConstructor
@Service
public class CargoService {

    private final CargoMapper cargoMapper;
    private final CargoRepository cargoRepository;


    public CargoDetailsDTO saveCargoDetails (CargoDetailsDTO cargoDetailsDTO) {
        CargoDetails entity = cargoMapper.map(cargoDetailsDTO);
        CargoDetails savedEntity = cargoRepository.save(entity);
        return cargoMapper.map(savedEntity);
    }

    public Double cargoVolumeCalculatorAndChooserOfBiggerValue(CargoDetailsDTO cargoDetailsDTO) {
        Double cargoVolume = Precision.round(cargoDetailsDTO.getLenght() * cargoDetailsDTO.getHeight() * cargoDetailsDTO.getWidth(), 2);
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

     public String cargoInfoFromForm (CargoDetailsDTO cargoDetailsDTO, CustomerDTO customerDTO) {
        String info = customerDTO.getCustomerDisplayedName() + " / "
        + cargoDetailsDTO.getNameOfCommodity() + " / "
        + cargoDetailsDTO.getKindOfCargo() + " / "
        + cargoDetailsDTO.getPortOfLoad() + " / "
        + cargoDetailsDTO.getPortOfDischarge();

        log.info("Customer: {} Name of commodity: {} Kind of Cargo: {} Port of load: {} Port of disccharge: {}",
                customerDTO.getCustomerDisplayedName(),
                cargoDetailsDTO.getNameOfCommodity(),
                cargoDetailsDTO.getKindOfCargo(),
                cargoDetailsDTO.getPortOfLoad(),
                cargoDetailsDTO.getPortOfDischarge()
                );

        return info;
     }


     public Double fullRateCalculator (CargoDetailsDTO cargoDetailsDTO) {
        Double freightRateTotal = (cargoDetailsDTO.getOceanRate() + cargoDetailsDTO.getBaf()
                + cargoDetailsDTO.getTotalOtherAdditional()) * cargoDetailsDTO.getHowManyUnits();
        return freightRateTotal;
     }

}

