package Maids.cc.example.Hussein.Yousef.services;

import Maids.cc.example.Hussein.Yousef.Excptions.NotFoundException;
import Maids.cc.example.Hussein.Yousef.dto.requests.createSaleRequest;
import Maids.cc.example.Hussein.Yousef.dto.requests.createTransactionRequest;
import Maids.cc.example.Hussein.Yousef.dto.updateTransactionRequest;
import Maids.cc.example.Hussein.Yousef.helpers.enums.SaleStatus;
import Maids.cc.example.Hussein.Yousef.models.Product;
import Maids.cc.example.Hussein.Yousef.models.Sales;
import Maids.cc.example.Hussein.Yousef.models.Transaction;
import Maids.cc.example.Hussein.Yousef.repositories.SaleRepository;
import Maids.cc.example.Hussein.Yousef.repositories.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    SaleRepository saleRepository;
    @Autowired
    ClientService clientService;
    @Autowired
    ProductService productService;


    @Override
    public void createTransaction(createTransactionRequest createTransactionRequest) {

         List<createSaleRequest>  productsToSaleList  =  createTransactionRequest.getSale();
         Sales sales =new Sales();
         List<Transaction> transactionList=new ArrayList<>();
        for (createSaleRequest p:productsToSaleList) {
          if(productService.CheckProductExistence(p.getProduct_id())) {
              sales.setClient(clientService.getClientById(createTransactionRequest.getClient_id()));
              sales.setTransactionList(transactionList);
              sales.setSaleStatus(SaleStatus.SOLD);
              saleRepository.save(sales);
              Product product=productService.getProductById(p.getProduct_id());
              Transaction newTransaction=new Transaction(sales,product,p.getQuantity());
              transactionRepository.save(newTransaction);
              transactionList.add(newTransaction);
          }
        }

    }


    @Override
    public void updateTransaction(updateTransactionRequest updateTransactionRequest) {
        try {
            Optional<Transaction> transaction =transactionRepository.findById(updateTransactionRequest.getTransaction_id());
            if (transaction.isPresent()){
                logger.info("Transaction Id"+transaction+ "is updated");
                Transaction transactionToUpdate =transaction.get();
                transactionToUpdate.setQuantity(updateTransactionRequest.getQuantity());
                logger.info("  updating   Transaction quantity to "+updateTransactionRequest.getQuantity());
                transactionToUpdate.getProduct().setPrice(updateTransactionRequest.getPrice());
                logger.info("  updating   Transaction product price "+updateTransactionRequest.getQuantity());
                transactionRepository.save(transactionToUpdate);

        }
         else{
             throw new NotFoundException("no transaction was found !");
         }

    }catch (Exception e){
        e.printStackTrace();
        throw e;
        }
    }


}

