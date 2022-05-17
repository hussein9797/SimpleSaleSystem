package Maids.cc.example.Hussein.Yousef.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    Long transaction_id;

    @Column(name = "quantity")
    private Integer quantity;


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id")
    @JsonIgnore
    private Sales sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    public Transaction() {
    }

    public Transaction(Sales sale, Product product, Integer quantity) {
        this.setSale(sale);
        this.setProduct(product);
        this.setQuantity(quantity);
    }

    @Transient
    public Product getProduct() {
        return product;
    }

    @Transient
    public Double getTotalPrice() {

        return getProduct().getPrice() * getQuantity();
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

    public Sales getSale() {
        return sale;
    }

    public void setSale(Sales sale) {
        this.sale = sale;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
