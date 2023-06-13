package ar.edu.unrn.productservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class GenderDTO {

    private Long id;
    private String description;
    private List<ProductDTO> productList;
}
