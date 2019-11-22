package pl.calculator.roro.roro_calculator.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="cargo")
public class CargoDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cargoID;

    private KindOfCargo kindOfCargo;

    @NotBlank
    @Size(max = 30)
    private String nameOfCommodity;

    @Digits(integer = 5, fraction = 2)
    @DecimalMax("50.0")
    private double lenght;

    @DecimalMax("6.0")
    private double width;

    @DecimalMax("4.5")
    private double height;

    @DecimalMax("150.0")
    private double weight;

}
