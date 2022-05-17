package Maids.cc.example.Hussein.Yousef.services;

import Maids.cc.example.Hussein.Yousef.dto.requests.createTransactionRequest;
import Maids.cc.example.Hussein.Yousef.dto.updateTransactionRequest;

public interface TransactionService {

    void createTransaction(createTransactionRequest createTransactionRequest);
    void updateTransaction(updateTransactionRequest updateTransactionRequest);


}
