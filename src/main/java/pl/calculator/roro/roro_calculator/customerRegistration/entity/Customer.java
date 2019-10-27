package pl.calculator.roro.roro_calculator.customerRegistration.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long customerId;
    private String customerName;
    private String customerDisplayedName;
    private String customerCity;
    private String customerPostCode;
    private String cusomerStreet;
    private int customerStrNumber;
    private int customerRoomNumber;
    private String customerEmail;
    private LocalDateTime customerRegistrationDate;

}
