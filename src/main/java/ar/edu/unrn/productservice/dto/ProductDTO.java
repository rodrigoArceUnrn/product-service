package ar.edu.unrn.productservice.dto;

import java.time.LocalDateTime;
import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public GenderDTO getGender() {
        return gender;
    }

    public void setGender(GenderDTO gender) {
        this.gender = gender;
    }

    public List<PersonDTO> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonDTO> personList) {
        this.personList = personList;
    }

    public List<DiscountDTO> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<DiscountDTO> discountList) {
        this.discountList = discountList;
    }
}
