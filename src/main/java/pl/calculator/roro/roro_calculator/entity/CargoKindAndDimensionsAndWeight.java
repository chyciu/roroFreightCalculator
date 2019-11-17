package pl.calculator.roro.roro_calculator.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="cargo")
public class CargoKindAndDimensionsAndWeight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long cargoID;

    @NotNull
    private KindOfCargo kindOfCargo;

    @NotNull
    @Size(max = 30)
    private String nameOfCommodity;

    @NotNull
    private double lenght;

    @NotNull
    private double width;

    @NotNull
    private double height;

    @NotNull
    private double weight;








}
