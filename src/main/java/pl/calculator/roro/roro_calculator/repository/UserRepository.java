package pl.calculator.roro.roro_calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.calculator.roro.roro_calculator.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserLogin(String userLogin);
}
