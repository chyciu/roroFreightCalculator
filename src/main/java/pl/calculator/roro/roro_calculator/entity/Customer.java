package pl.calculator.roro.roro_calculator.entity;


import lombok.Data;
import org.hibernate.annotations.Columns;
import org.hibernate.validator.constraints.UniqueElements;

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

    @NotBlank
    private String customerName;

    @NotBlank
    @Size(min=5, max=30)
    @Column(unique=true)
    private String customerDisplayedName;

    @NotBlank
    private String customerCity;

    @NotBlank
    private String customerPostCode;

    @NotBlank
    private String customerStreet;

    @NotBlank
    private String customerStrNumber;

    @NotBlank
    private String customerRoomNumber;

    @NotBlank
    @Email
    @Column(unique=true)
    private String customerEmail;

    private LocalDateTime customerRegistrationDate;

}
