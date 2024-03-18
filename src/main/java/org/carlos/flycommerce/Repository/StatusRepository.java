package org.carlos.flycommerce.Repository;

import org.carlos.flycommerce.Models.MySql.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
