package org.carlos.flycommerce.Controllers.App;

import lombok.RequiredArgsConstructor;
import org.carlos.flycommerce.DTO.User.UserDTO;
import org.carlos.flycommerce.Services.App.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
