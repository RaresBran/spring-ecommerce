package com.training.ecommerce.service;

import com.training.ecommerce.dto.ProductDto;
import com.training.ecommerce.model.Product;
import com.training.ecommerce.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(ProductDto productDto) {
        Product newProduct = modelMapper.map(productDto, Product.class);
        return productRepository.save(newProduct);
    }

    public List<Product> saveAll(List<ProductDto> productDtoList) {
        List<Product> newProducts = productDtoList
                .stream()
                .map(p -> modelMapper.map(p, Product.class))
                .toList();
        return productRepository.saveAll(newProducts);
    }
}
