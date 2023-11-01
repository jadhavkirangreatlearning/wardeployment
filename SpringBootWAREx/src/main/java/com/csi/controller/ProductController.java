package com.csi.controller;

import com.csi.entity.Product;
import com.csi.exception.RecordNotFoundException;
import com.csi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@Valid @RequestBody Product product){
        return new ResponseEntity<>(productServiceImpl.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/findbyid/{productId}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable int productId){
        return ResponseEntity.ok(productServiceImpl.findById(productId));
    }

    @GetMapping("/findByProductName/{productName}")
    public ResponseEntity<List<Product>> findByProductName(@RequestParam String productName){
        return ResponseEntity.ok(productServiceImpl.findByProductName(productName));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productServiceImpl.findAll());
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> update(@PathVariable int productId, @Valid @RequestBody Product product){
        Product product1 = productServiceImpl.findById(productId).orElseThrow(()-> new RecordNotFoundException("Product ID Does Not Exist"));

        product1.setProductPrice(product.getProductPrice());
        product1.setProductName(product.getProductName());
        product1.setProductLaunchDate(product.getProductLaunchDate());

        return new ResponseEntity<>(productServiceImpl.update(product1), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid/{productId}")
    public ResponseEntity<String> deleteById(@PathVariable int productId){
        productServiceImpl.deleteById(productId);
        return ResponseEntity.ok("Product Data Deleted Successfully");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll(){
        productServiceImpl.deleteAll();
        return ResponseEntity.ok("All Data Deleted Successfully");
    }


}
