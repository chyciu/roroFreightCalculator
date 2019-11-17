package pl.calculator.roro.roro_calculator.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class CustomerDTO {

    private Long customerId;

    @NotNull
    private String customerName;

    @NotNull
    @Size(min=5, max=30)
    @Column(unique = true)
    private String customerDisplayedName;

    @NotNull
    private String customerCity;

    @NotNull
    private String customerPostCode;

    @NotNull
    private String customerStreet;

    @NotNull
    private String customerStrNumber;

    @NotNull
    private String customerRoomNumber;

    @NotNull
    @Email
    @Column(unique = true)
    private String customerEmail;

    private LocalDateTime customerRegistrationDate;

}
