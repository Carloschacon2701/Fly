package org.carlos.flycommerce.DTO.User;

import org.carlos.flycommerce.Models.Gender;
import org.carlos.flycommerce.Models.Role;

import java.util.Date;

public record UserDTO(
        Integer id,
        String name,
        String email,
        Date dateOfBirth,
        Role role,

        Gender gender

) {
}
