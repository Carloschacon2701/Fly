package org.carlos.flycommerce.Repository;

import org.carlos.flycommerce.Models.MySql.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
