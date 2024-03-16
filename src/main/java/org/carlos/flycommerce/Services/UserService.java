package org.carlos.flycommerce.Services;

import lombok.RequiredArgsConstructor;
import org.carlos.flycommerce.DTO.User.UserDTO;
import org.carlos.flycommerce.DTO.User.UserDTOMapper;
import org.carlos.flycommerce.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;

    public UserDTO getUser(Integer id) {
        return userDTOMapper.apply(userRepository.findById(id).orElseThrow());
    }
}
