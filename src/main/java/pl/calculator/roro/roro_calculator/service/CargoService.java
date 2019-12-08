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
import pl.calculator.roro.roro_calculator.repository.CustomerRepository;

import java.math.RoundingMode;

@Slf4j
@RequiredArgsConstructor
@Service
public class CargoService {

    private final CargoMapper cargoMapper;
    private final CargoRepository cargoRepository;

//    private CargoDetails map(CargoDetailsDTO cargoDetailsDTO) {
//        CargoDetails entity = new CargoDetails();
//        entity.setKindOfCargo(cargoDetailsDTO.getKindOfCargo());
//        entity.setNameOfCommodity(cargoDetailsDTO.getNameOfCommodity());
//        entity.setWeight(cargoDetailsDTO.getWeight());
//        entity.setLenght(cargoDetailsDTO.getLenght());
//        entity.setWidth(cargoDetailsDTO.getWidth());
//        entity.setHeight(cargoDetailsDTO.getHeight());
//        entity.setCargoVolume(cargoDetailsDTO.getCargoVolume());
//        entity.setPortOfLoad(cargoDetailsDTO.getPortOfLoad());
//        entity.setPortOfDischarge(cargoDetailsDTO.getPortOfDischarge());
//        entity.setOceanRate(cargoDetailsDTO.getOceanRate());
//        entity.setBaf(cargoDetailsDTO.getBaf());
//        entity.setTotalOtherAdditional(cargoDetailsDTO.getTotalOtherAdditional());
//        entity.setHowManyUnits(cargoDetailsDTO.getHowManyUnits());
//        entity.setCurrency(cargoDetailsDTO.getCurrency());
//        return entity;
//    }
//
//    public void saveCargoDetails(CargoDetailsDTO cargoDetailsDTO) {
//        CargoDetails entity = map(cargoDetailsDTO);
//        cargoRepository.save(entity);
//    }

    //above two methods and below one are the same.

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
        String info = "Customer: " + customerDTO.getCustomerDisplayedName() +
        " Name of commodity: " + cargoDetailsDTO.getNameOfCommodity() +
        " Kind of Cargo: " + cargoDetailsDTO.getKindOfCargo() +
        " Port of load: " + cargoDetailsDTO.getPortOfLoad() +
        " Port of discharge: " + cargoDetailsDTO.getPortOfDischarge();

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

