package pl.calculator.roro.roro_calculator.entity;

import com.sun.org.glassfish.gmbal.ParameterNames;
import lombok.Data;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.security.Principal;

@Data
@Entity
@Table(name="cargo")
public class CargoDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cargoID;

    @Enumerated(EnumType.STRING)
    private KindOfCargo kindOfCargo;

    @NotBlank
    @Size(max = 30)
    private String nameOfCommodity;

    @Digits(integer = 5, fraction = 2)
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "customerid")
    private Customer customer;




}
