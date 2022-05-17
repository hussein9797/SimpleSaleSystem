package Maids.cc.example.Hussein.Yousef.controllers.ProductManagementController;


import Maids.cc.example.Hussein.Yousef.dto.requests.addProductRequest;
import Maids.cc.example.Hussein.Yousef.dto.requests.updateProductRequest;
import Maids.cc.example.Hussein.Yousef.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;



    @PostMapping(value = "/add_product")
    public ResponseEntity<Object> addProduct(@RequestBody addProductRequest addProductRequest) {

        try {
            productService.addProduct(addProductRequest);

            return new ResponseEntity<>("{ \"message\": \"product  added successfully \" }", HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }


    }


    @PutMapping(value = "/update_product")
    public ResponseEntity<Object> updateClientById(@RequestBody updateProductRequest updateProductRequest)  {

        try {
            productService.updateProductById(updateProductRequest);
            return new ResponseEntity<>("{ \"message\": \"product updated successfully \" }", HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping(value = "/delete_product/{product_id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable ("product_id") Long id)  {

        try {

            productService.deleteProductById(id);
            return new ResponseEntity<>("{ \"message\": \"product deleted  successfully \" }", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping(value = "/get_allProducts")
    public   ResponseEntity<Object> getAllProducts() {

        try {

            return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }

    }

    @GetMapping(value = "/get_product/{product_id}")
    public ResponseEntity<Object> getClientById(@PathVariable("product_id") Long id) {

        try {
            return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


}
