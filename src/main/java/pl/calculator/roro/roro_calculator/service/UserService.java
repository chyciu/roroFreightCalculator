package pl.calculator.roro.roro_calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.calculator.roro.roro_calculator.dto.UserDTO;
import pl.calculator.roro.roro_calculator.entity.User;
import pl.calculator.roro.roro_calculator.mapper.UserMapper;
import pl.calculator.roro.roro_calculator.repository.UserRepository;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDTO createUser (UserDTO userDTO) {
        User entity = userMapper.map(userDTO);
        User savedEntity = userRepository.save(entity);

        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        entity.setPassword(encodedPassword);
        return userMapper.map(savedEntity);

    }

    public UserDTO findByUserLogin (String userLogin) {
        User user = userRepository.findByUserLogin(userLogin)
                .orElseThrow(()-> new EntityNotFoundException("User not found"));
        return userMapper.map(user);
    }


    public void updateUser (String userLogin, UserDTO userDTO) {
        User user = userRepository.findByUserLogin(userLogin)
                .orElseThrow(()->new EntityNotFoundException("User not found"));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());

        if (!StringUtils.isEmpty(userDTO.getPassword())) {
            String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
            user.setPassword(encodedPassword);
        }
    }
}
