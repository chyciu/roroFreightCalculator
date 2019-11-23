package pl.calculator.roro.roro_calculator.dto;

import lombok.Data;
import pl.calculator.roro.roro_calculator.entity.Customer;
import pl.calculator.roro.roro_calculator.entity.KindOfCargo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class CargoDetailsDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cargoID;

    private KindOfCargo kindOfCargo;

    @NotBlank
    @Size(max = 30)
    private String nameOfCommodity;

    @NotNull
    @DecimalMax("50.0")
    private Double lenght;

    @NotNull
    @DecimalMax("6.0")
    private Double width;

    @NotNull
    @DecimalMax("4.5")
    private Double height;

    @NotNull
    @DecimalMax("150.0")
    private Double weight;

    private Customer customer;

    private Double cargoVolume;

}
