package ar.edu.unrn.productservice.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductDTO {

    private Long id;
    private String title;
    private LocalDateTime exitDate;
    private Float amount;
    private String image;
    private String format;
    private String status;
    private String summary;
    private GenderDTO gender;
    private List<PersonDTO> personList;
    private List<DiscountDTO> discountList;
}