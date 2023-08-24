package ar.edu.unrn.productservice.model;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person extends BaseEntity {

    private String name;
    private String lastname;

    @Enumerated(EnumType.STRING)
    @Column(name = "person_type")
    private PersonType personType;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
