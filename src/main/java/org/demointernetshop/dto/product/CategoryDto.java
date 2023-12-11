package org.demointernetshop.dto.product;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    private Integer id;
    private String categoryName;
}
