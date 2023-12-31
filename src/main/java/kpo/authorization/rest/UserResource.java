package kpo.authorization.rest;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

import java.util.List;

import kpo.authorization.model.ChangeRoleForm;
import kpo.authorization.model.UserDTO;
import kpo.authorization.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserResource {
    private final UserService userService;

    public UserResource(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{token}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "token") final String token) {
        return ResponseEntity.ok(userService.get(token));
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody @Valid final ChangeRoleForm changeRoleForm) {
        userService.update(changeRoleForm);
        return ResponseEntity.ok().build();
    }
}
