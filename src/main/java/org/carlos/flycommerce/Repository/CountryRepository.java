package org.carlos.flycommerce.Repository;

import org.carlos.flycommerce.Models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
