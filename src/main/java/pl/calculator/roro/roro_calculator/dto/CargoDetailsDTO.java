package pl.calculator.roro.roro_calculator.dto;

import lombok.Data;
import pl.calculator.roro.roro_calculator.entity.KindOfCargo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CargoDetailsDTO {

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
