package org.demointernetshop.controllers.product;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.dto.product.CategoryDto;
import org.demointernetshop.dto.product.CategoryWithPricesDto;
import org.demointernetshop.dto.product.ManufacturerDto;
import org.demointernetshop.services.ManufacturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products/manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @GetMapping
    public ResponseEntity<List<ManufacturerDto>> getAllManufacturer(){
        List<ManufacturerDto> allManufacturer = manufacturerService.getAllManufacturer();

        return ResponseEntity.ok(allManufacturer);
    }


}
