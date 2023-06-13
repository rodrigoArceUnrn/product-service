package ar.edu.unrn.productservice.dto;

import ar.edu.unrn.productservice.model.PersonType;
import lombok.Data;

@Data
public class PersonDTO {

    private Long id;
    private String name;
    private String lastname;
    private PersonType personType;
}
