package Maids.cc.example.Hussein.Yousef.controllers.TransctionManagementController;

import Maids.cc.example.Hussein.Yousef.dto.requests.createTransactionRequest;
import Maids.cc.example.Hussein.Yousef.dto.updateTransactionRequest;
import Maids.cc.example.Hussein.Yousef.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {


    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/create_transaction")
    public ResponseEntity<Object> create(@RequestBody createTransactionRequest createTransactionRequest) {

        try {

            transactionService.createTransaction(createTransactionRequest);
            return new ResponseEntity<>("{ \"message\": \"transaction  created successfully \" }", HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }


    }
    @PutMapping(value = "/update_transaction")
    public ResponseEntity<Object> update(@RequestBody updateTransactionRequest updateTransactionRequest) {

        try {

            transactionService. updateTransaction(updateTransactionRequest);
            return new ResponseEntity<>("{ \"message\": \"transaction updated successfully \" }", HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }


    }

}
