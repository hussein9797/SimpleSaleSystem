package Maids.cc.example.Hussein.Yousef.services;


import Maids.cc.example.Hussein.Yousef.Excptions.NotFoundException;
import Maids.cc.example.Hussein.Yousef.dto.requests.addProductRequest;
import Maids.cc.example.Hussein.Yousef.dto.requests.updateProductRequest;
import Maids.cc.example.Hussein.Yousef.models.Product;
import Maids.cc.example.Hussein.Yousef.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void addProduct(addProductRequest addProductRequest) {
         try {
             Product newProduct =new Product();
             newProduct.setName(addProductRequest.getProduct_name());
             newProduct.setCategory(addProductRequest.getCategory());
             newProduct.setDescription(addProductRequest.getDescription());
             newProduct.setPrice(addProductRequest.getPrice());

             productRepository.save(newProduct);


         }catch (Exception e ){
             e.printStackTrace();
             throw  e;
         }


    }

    @Override
    public void updateProductById(updateProductRequest updateProductRequest) {


        try {
            Optional<Product> product =productRepository.findById(updateProductRequest.getId());
            if (product.isPresent()){
                Product productToUpdate =product.get();
                productToUpdate.setName(updateProductRequest.getProduct_name());
                productToUpdate.setDescription(updateProductRequest.getDescription());
                productToUpdate.setCategory(updateProductRequest.getCategory());
                productToUpdate.setPrice(updateProductRequest.getPrice());
                productRepository.save(productToUpdate);
            }
            else {
                throw new NotFoundException("product does not exist !");
            }

        }catch (Exception e){
            e.printStackTrace();
            throw  e;
        }

    }

    @Override
    public void deleteProductById(Long productId) {
        try {
            Optional<Product> product =productRepository.findById(productId);
            if (product.isPresent()){
                productRepository.deleteById(productId);
            }
            else {
                throw new NotFoundException("product does not exist !");
            }

        }catch (Exception e){
            e.printStackTrace();
            throw  e;
        }

    }

    @Override

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getListOfProducts(List<Long> products_id) {
        List<Product> result =new ArrayList<>();
        for ( Long p: products_id) {
            if (this.CheckProductExistence(p)){
                result.add(this.getProductById(p));
            }
        }
        return result;
    }

    @Override
    public Product getProductById(Long productId) {
        try {

            Optional<Product> product = productRepository.findById(productId);
            if (product.isPresent()){

                return product.get();
            }
            else{

                throw new NotFoundException("product with this Specific Id not found !");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw  e;
        }


    }


    @Override
    public boolean CheckProductExistence (Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.isPresent();
    }
}
