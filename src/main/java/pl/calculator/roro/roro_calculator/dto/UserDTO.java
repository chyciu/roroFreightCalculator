package pl.calculator.roro.roro_calculator.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    private Long id;

    @NotBlank
    @Size(min = 2, max=20)
    private String firstName;

    @NotBlank
    @Size(min = 2, max=20)
    private String lastName;

    @NotBlank
    @Size(min = 2, max=20)
    @Column(unique = true)
    private String userLogin;

    @NotBlank
    @Size(min = 5, max = 10)
    private String password;

}
