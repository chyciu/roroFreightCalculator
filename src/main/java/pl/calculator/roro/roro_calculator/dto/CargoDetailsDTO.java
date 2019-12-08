package pl.calculator.roro.roro_calculator.dto;

import lombok.Data;
import pl.calculator.roro.roro_calculator.entity.Currency;
import pl.calculator.roro.roro_calculator.entity.Customer;
import pl.calculator.roro.roro_calculator.entity.KindOfCargo;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
public class CargoDetailsDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cargoID;

    @Enumerated(EnumType.STRING)
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

    @NotNull
    private Customer customer;

    private Double cargoVolume;

    @NotBlank
    private String portOfLoad;

    @NotBlank
    private String portOfDischarge;

    @NotNull
    @DecimalMin("0")
    private Double oceanRate;

    @DecimalMin("0")
    private Double baf;

    @DecimalMin("0")
    private Double totalOtherAdditional;

    @NotNull
    @DecimalMin("1")
    private Double howManyUnits;

    @Enumerated(EnumType.STRING)
    private Currency currency;

}
