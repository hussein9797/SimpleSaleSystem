package Maids.cc.example.Hussein.Yousef.services;

import Maids.cc.example.Hussein.Yousef.Excptions.NotFoundException;
import Maids.cc.example.Hussein.Yousef.dto.requests.addProductRequest;
import Maids.cc.example.Hussein.Yousef.dto.requests.updateProductRequest;
import Maids.cc.example.Hussein.Yousef.models.Product;

import java.util.List;

public interface ProductService {


    void addProduct(addProductRequest addProductRequest);
    void updateProductById(updateProductRequest updateProductRequest)throws NotFoundException;
    void deleteProductById(Long productId)throws NotFoundException;
    List<Product> getAllProduct();
    List<Product> getListOfProducts(List<Long> products_id);
    boolean CheckProductExistence (Long productId);
    Product getProductById(Long productId) throws NotFoundException;

}
