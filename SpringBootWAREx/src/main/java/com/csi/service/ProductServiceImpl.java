package com.csi.service;

import com.csi.entity.Product;
import com.csi.repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepoImpl;


    @Override
    public Product save(Product product) {
        return productRepoImpl.save(product);
    }

    @Override
    @Cacheable(value = "productId")
    public Optional<Product> findById(int productId) {

        log.info("#############Trying to fetch data from DATABASE ############");
        return productRepoImpl.findById(productId);
    }

    @Override
    public List<Product> findByProductName(String productName) {
        return productRepoImpl.findByProductName(productName);
    }

    @Override
    public List<Product> findAll() {
        return productRepoImpl.findAll();
    }

    @Override
    public Product update(Product product) {
        return productRepoImpl.save(product);
    }

    @Override
    public void deleteById(int productId) {
        productRepoImpl.deleteById(productId);
    }

    @Override
    public void deleteAll() {
        productRepoImpl.deleteAll();
    }
}
