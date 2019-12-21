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

    @GetMapping("/user-register")
    public String register (Model model) {
        model.addAttribute("userForm", new UserDTO());
        return "user-register";
    }


    @PostMapping("/user-register")
    public String registerUser (@Valid @ModelAttribute(name= "user-register") UserDTO userDTO, BindingResult errors) {
        if (errors.hasErrors()) {
            return "user-register";
        }

        userService.createUser(userDTO);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login () {
        return "login";
    }




}
