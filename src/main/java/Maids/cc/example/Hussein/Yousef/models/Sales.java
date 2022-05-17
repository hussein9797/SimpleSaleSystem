package Maids.cc.example.Hussein.Yousef.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import Maids.cc.example.Hussein.Yousef.helpers.enums.SaleStatus;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sales")
public class  Sales  extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    Long sale_id;

    @Column(name = "sale_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private SaleStatus saleStatus;


    @OneToMany(mappedBy = "sale")
    private List<Transaction> transactionList = new ArrayList<>();

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="client_id")
    Client client;

    @Transient
    public Double getTotalSalePrice() {
        double Total = 0;
        List<Transaction> transactions = getTransactionList();
        for (Transaction tr : transactions) {
            Total += tr.getTotalPrice();
        }
        return Total;
    }

    public Sales() {
    }

    public SaleStatus getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public Long getSale_id() {
        return sale_id;
    }

    public void setSale_id(Long sale_id) {
        this.sale_id = sale_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
