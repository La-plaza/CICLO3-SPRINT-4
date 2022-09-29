package misiontic2022.com.laplaza.Service;

import java.util.List;

import misiontic2022.com.laplaza.Entity.Product;

public interface IProductService {

    List<Product> getAllProduct();

    List<Product> getProductByName(String product_name);

    Product saveProduct(Product product);

    Product getProductById(Long id);

    Product updateProduct(Product product);
    Product actualizar(Product product);

    void deleteProductById(Long id);
    
}
