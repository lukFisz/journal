package luk.fisz.journal.controller;

import luk.fisz.journal.dto.UserRegistrationDTO;
import luk.fisz.journal.service.user.UserService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@PropertySource("classpath:route.properties")
@RequestMapping("/${user.route}")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/${user.route.register}")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        userService.create(userRegistrationDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
