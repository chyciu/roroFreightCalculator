package pl.calculator.roro.roro_calculator.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="cargo")
public class CargoDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cargoID;

    @NotBlank
    private KindOfCargo kindOfCargo;

    @NotBlank
    @Size(max = 30)
    private String nameOfCommodity;

    @NotBlank
    private double lenght;

    @NotBlank
    private double width;

    @NotBlank
    private double height;

    @NotBlank
    private double weight;

}
