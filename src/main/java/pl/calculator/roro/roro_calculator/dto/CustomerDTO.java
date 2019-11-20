package pl.calculator.roro.roro_calculator.dto;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class CustomerDTO {

    private Long customerId;

    @NotBlank(message = "{form.validation.notBlank}")
    private String customerName;

    @NotBlank(message = "{form.validation.notBlank}")
    @Size(min=5, max=30, message = "form.validation.size}")
    @Column(unique=true)
    private String customerDisplayedName;

    @NotBlank(message = "{form.validation.notBlank}")
    private String customerCity;

    @NotBlank(message = "{form.validation.notBlank}")
    private String customerPostCode;

    @NotBlank(message = "{form.validation.notBlank}")
    private String customerStreet;

    @NotBlank(message = "{form.validation.notBlank}")
    private String customerStrNumber;

    @NotBlank(message = "{form.validation.notBlank}")
    private String customerRoomNumber;

    @NotBlank(message = "{form.validation.notBlank}")
    @Email
    @Column(unique=true)
    private String customerEmail;

    private LocalDateTime customerRegistrationDate;

}
