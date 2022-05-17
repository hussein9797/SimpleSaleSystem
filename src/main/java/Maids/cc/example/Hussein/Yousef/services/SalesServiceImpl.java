package Maids.cc.example.Hussein.Yousef.services;

import Maids.cc.example.Hussein.Yousef.models.Sales;
import Maids.cc.example.Hussein.Yousef.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    SaleRepository saleRepository;
    @Override
    public List<Sales> getALlSales() {
        try {
            return    saleRepository.findAll();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
