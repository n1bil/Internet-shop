package org.demointernetshop.repository;

import org.demointernetshop.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
}
