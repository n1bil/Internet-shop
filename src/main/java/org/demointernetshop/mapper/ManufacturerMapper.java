package org.demointernetshop.mapper;

import org.demointernetshop.dto.product.ManufacturerDto;
import org.demointernetshop.entity.Manufacturer;

public class ManufacturerMapper {

    public ManufacturerDto mapToManufacturerDto(Manufacturer manufacturer) {
        return ManufacturerDto.builder()
                .id(manufacturer.getId())
                .name(manufacturer.getName())
                .country(manufacturer.getCountry())
                .build();
    }

}
