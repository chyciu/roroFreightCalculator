package pl.calculator.roro.roro_calculator.customerRegistration.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long customerId;

    @NotNull
    @NotBlank
    private String customerName;

    @NotNull
    @Size(min=5, max=10)
    @Column(unique = true)
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
    @Column(unique = true)
    private String customerEmail;

    @NotNull
    @DateTimeFormat
    private LocalDateTime customerRegistrationDate;

}
