package org.carlos.flycommerce.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "status")
@AllArgsConstructor
@NoArgsConstructor
public class Status {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

}
