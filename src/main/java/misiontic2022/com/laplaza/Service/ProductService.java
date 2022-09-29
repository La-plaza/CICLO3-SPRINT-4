package misiontic2022.com.laplaza.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import misiontic2022.com.laplaza.Entity.Product;
import misiontic2022.com.laplaza.Repository.IProductRepository;

@Service
public class ProductService  implements IProductService{

    private IProductRepository productRepository;

    public ProductService(IProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByName(String product_name) {
        return productRepository.findByNameContaining(product_name);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
    @Override
    public Product actualizar(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
        
    }

    public void save(String product) {
    }
    
}
