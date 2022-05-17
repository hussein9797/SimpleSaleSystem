package Maids.cc.example.Hussein.Yousef.dto.requests;

import Maids.cc.example.Hussein.Yousef.dto.requests.createSaleRequest;

import java.io.Serializable;
import java.util.List;

public class createTransactionRequest implements Serializable {


    List<createSaleRequest> sale;
    Long client_id;

    public createTransactionRequest() {
    }

    public List<createSaleRequest> getSale() {
        return sale;
    }

    public void setSale(List<createSaleRequest> sale) {
        this.sale = sale;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
}
