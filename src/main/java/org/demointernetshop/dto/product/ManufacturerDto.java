package org.demointernetshop.dto.product;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManufacturerDto {

    private Integer id;
    private String name;
    private String country;
}