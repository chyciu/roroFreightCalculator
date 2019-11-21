package pl.calculator.roro.roro_calculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.calculator.roro.roro_calculator.dto.CargoDetailsDTO;
import pl.calculator.roro.roro_calculator.entity.KindOfCargo;
import pl.calculator.roro.roro_calculator.service.CargoService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cargo")
public class CargoController {

    private final CargoService cargoService;

    @GetMapping
    public String registerCargo () {
        return "cargoDetailsForm";
    }

    public String handleCargoForm (@Valid @ModelAttribute(name="cargoForm") CargoDetailsDTO cargoDetailsDTO, BindingResult errors) {
        if (errors.hasErrors()) {
            return "/cargo";
        }

        cargoService.saveCargoDetails(cargoDetailsDTO);
        cargoService.cargoVolumeCalculatorAndChooserOfBiggerValue(cargoDetailsDTO);
        return "redirect:/cargo";
    }

    @ModelAttribute(name = "cargoForm")
    public CargoDetailsDTO produceCargo (){
        return new CargoDetailsDTO();
    }


    @ModelAttribute("allKindOfCargo")
    public List<KindOfCargo> selectKinds() {
        return Arrays.asList
                (KindOfCargo.RO_RO_SELF_PROPELLED, KindOfCargo.RO_RO_TOWABLE,
                KindOfCargo.STATIC_ON_RT, KindOfCargo.STATIC_FORKLIFTABLE);
    }

}
