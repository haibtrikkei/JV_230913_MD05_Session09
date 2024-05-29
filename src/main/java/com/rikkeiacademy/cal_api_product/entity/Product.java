package com.rikkeiacademy.cal_api_product.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    private Integer proId;
    private String proName;
    private String producer;
    private Integer yearMaking;
    private Double price;
}
