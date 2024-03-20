package ar.edu.unrn.productservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DiscountDTO {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private float amount;
}