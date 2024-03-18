package org.carlos.flycommerce.Repository;

import org.carlos.flycommerce.Models.MySql.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail (String email);
}
