package org.carlos.flycommerce.DTO.User;

import org.carlos.flycommerce.Models.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getDateOfBirth(),
                user.getRole(),
                user.getGender()
        );
    }
}
