package pl.calculator.roro.roro_calculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.calculator.roro.roro_calculator.dto.UserDTO;
import pl.calculator.roro.roro_calculator.service.UserService;

import javax.validation.Valid;
import java.nio.file.attribute.UserDefinedFileAttributeView;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String register (Model model) {
        model.addAttribute("userForm", new UserDTO());
        return "users";
    }


    @PostMapping("/users")
    public String registerUser (@Valid @ModelAttribute(name= "users") UserDTO userDTO, BindingResult errors) {
        if (errors.hasErrors()) {
            return "users";
        }

        userService.createUser(userDTO);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login () {
        return "login";
    }

}
