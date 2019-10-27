package pl.calculator.roro.roro_calculator.customerRegistration.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class CustomerDTO {

    private Long customerId;

    @NotNull
    @NotBlank
    private String customerName;

    @NotNull
    @Size(min=5, max=10)
    private String customerDisplayedName;

    @NotNull
    @NotBlank
    private String customerCity;

    @NotNull
    private String customerPostCode;

    @NotNull
    private String customerStreet;

    @NotNull
    private int customerStrNumber;

    @NotNull
    private int customerRoomNumber;

    @NotNull
    @Email
    private String customerEmail;

    @NotNull
    @DateTimeFormat
    private LocalDateTime customerRegistrationDate;

}
