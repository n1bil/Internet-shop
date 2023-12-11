package org.demointernetshop.services;

import lombok.AllArgsConstructor;
import org.demointernetshop.dto.product.ManufacturerDto;
import org.demointernetshop.mapper.ManufacturerMapper;
import org.demointernetshop.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ManufacturerService {

    private ManufacturerRepository manufacturerRepository;
    private ManufacturerMapper manufacturerMapper;

    public List<ManufacturerDto> getAllManufacturer() {
        return manufacturerRepository.findAll().stream()
                .map(manufacturerMapper::mapToManufacturerDto)
                .collect(Collectors.toList());
    }

}
