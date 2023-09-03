package com.product.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.ProductRepository;
import com.product.model.Product;
import com.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return productRepo.findById(id).get();
	}

	@Override
	public String deleteProduct(int id) {
		Product product= productRepo.findById(id).get();
		if(product !=null) {
			productRepo.delete(product);
			return "Product Deleted Successfully";
		}
		return "Product Not Found";
	}

	@Override
	public Product editProduct(Product product, int id) {
		Product p=productRepo.findById(id).get();
		p.setProductname(product.getProductname());
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		p.setStatus(product.getStatus());
		productRepo.save(p);
		return p;		
	}
}
