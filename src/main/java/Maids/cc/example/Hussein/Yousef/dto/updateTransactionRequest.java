package Maids.cc.example.Hussein.Yousef.dto;

import java.io.Serializable;

public class updateTransactionRequest implements Serializable {


    Long transaction_id;
    Integer quantity;
    Double price;

    public updateTransactionRequest() {
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
