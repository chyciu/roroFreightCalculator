package pl.calculator.roro.roro_calculator.mapper;

import org.mapstruct.Mapper;
import pl.calculator.roro.roro_calculator.dto.UserDTO;
import pl.calculator.roro.roro_calculator.entity.User;

@Mapper(componentModel= "spring")
public interface UserMapper {

    User map (UserDTO userDTO);
    UserDTO map (User entity);
}
