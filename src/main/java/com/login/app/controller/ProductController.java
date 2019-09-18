package com.login.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.login.app.model.Product;
import com.login.app.repository.ProductRepository;


@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method=RequestMethod.GET, value="/api/products")
    public Iterable<Product> product() {
        return productRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/api/products")
    public String save(@RequestBody Product product) {
        productRepository.save(product);

        return product.getId();
    }

    @RequestMapping(method=RequestMethod.GET, value="/api/products/{id}")
    public Optional<Product> show(@PathVariable String id) {
        return productRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/api/products/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        Optional<Product> prod = productRepository.findById(id);
        if(product.getName()!= null)
            prod.get().setName(product.getName());
        if(product.getDescription() != null)
            prod.get().setDescription(product.getDescription());
        if(product.getPrice() != null)
            prod.get().setPrice(product.getPrice());
        if(product.getImage() != null)
            prod.get().setImage(product.getImage());
        productRepository.save(prod.get());
        return prod.get();
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/api/products/{id}")
    public String delete(@PathVariable String id) {
        Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.get());

        return "product deleted";
    }
}