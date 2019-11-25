package pl.calculator.roro.roro_calculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.calculator.roro.roro_calculator.dto.CargoDetailsDTO;
import pl.calculator.roro.roro_calculator.dto.CustomerDTO;
import pl.calculator.roro.roro_calculator.entity.Customer;
import pl.calculator.roro.roro_calculator.entity.KindOfCargo;
import pl.calculator.roro.roro_calculator.service.CargoService;
import pl.calculator.roro.roro_calculator.service.CustomerRegistrationService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cargo")
public class CargoController {

    private final CargoService cargoService;
    private final CustomerRegistrationService customerRegistrationService;


    @GetMapping
    public String registerCargo (Model model) {
        List<Customer> customers = customerRegistrationService.findAll("");
        model.addAttribute("customerList", customers);
        return "cargoDetailsForm";
    }


    @PostMapping
    public String handleCargoForm (@Valid @ModelAttribute(name="cargoForm") CargoDetailsDTO cargoDetailsDTO) {
        cargoService.saveCargoDetails(cargoDetailsDTO);
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

    @PostMapping("/calculate")
    public String calculate(@Valid @ModelAttribute(name="cargoForm") CargoDetailsDTO cargoDetailsDTO,
                            KindOfCargo kindOfCargo, CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {
        Double freightTon = cargoService.cargoVolumeCalculatorAndChooserOfBiggerValue(cargoDetailsDTO);
        String infoFromForm = cargoService.cargoInfoFromForm(cargoDetailsDTO, kindOfCargo, customerDTO);
        redirectAttributes.addFlashAttribute("freightTon", freightTon);
        redirectAttributes.addFlashAttribute("infoFromForm", infoFromForm);
        return "redirect:/cargo";
    }

//    @PostMapping("/info")
//     public String postInfoFromForm (@Valid @ModelAttribute(name="cargoForm") CargoDetailsDTO cargoDetailsDTO,
//                                     CustomerDTO customerDTO, KindOfCargo kindOfCargo, RedirectAttributes redirectAttributes) {
//        String infoFromForm = cargoService.cargoInfoFromForm(cargoDetailsDTO, kindOfCargo, customerDTO);
//        redirectAttributes.addFlashAttribute("infoFromForm", infoFromForm);
//        return "redirect:/cargo";
//    }


}
