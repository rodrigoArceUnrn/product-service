package ar.edu.unrn.productservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "genders")
public class Gender extends BaseEntity {

    private String description;

    @OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
    private List<Product> productList;

    public Gender() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
