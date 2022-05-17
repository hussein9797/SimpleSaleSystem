package Maids.cc.example.Hussein.Yousef.controllers.SalesManagementController;

import Maids.cc.example.Hussein.Yousef.models.Sales;
import Maids.cc.example.Hussein.Yousef.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    SalesService salesService;

    @GetMapping(value = "/get_allSales")
    public ResponseEntity<Object> getALLSales() {

        try {
            List<Sales> salesList =salesService.getALlSales();

            return new ResponseEntity<>(salesList, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }

    }


}
