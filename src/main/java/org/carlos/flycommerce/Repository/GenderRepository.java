package org.carlos.flycommerce.Repository;

import org.carlos.flycommerce.Models.MySql.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender,Integer> {

}
