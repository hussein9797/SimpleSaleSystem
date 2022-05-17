package Maids.cc.example.Hussein.Yousef.dto.requests;

import java.io.Serializable;

public class createSaleRequest implements Serializable {

    Long product_id;

    Integer quantity;


    public createSaleRequest() {
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
