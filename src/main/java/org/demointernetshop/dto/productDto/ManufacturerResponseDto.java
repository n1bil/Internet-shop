package org.demointernetshop.dto.productDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerResponseDto {

    private Integer id;
    private String manufacturer_name;
    private String country;

}
