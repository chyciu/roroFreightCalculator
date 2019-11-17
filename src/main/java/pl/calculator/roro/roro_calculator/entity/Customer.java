package pl.calculator.roro.roro_calculator.entity;


import lombok.Data;
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
