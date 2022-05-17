package Maids.cc.example.Hussein.Yousef.dto.requests;

import javax.persistence.Column;
import java.io.Serializable;

public class addProductRequest implements Serializable {


    String product_name;

    String category;


    String description;


    Double price;


    public addProductRequest() {
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
