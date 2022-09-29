package misiontic2022.com.laplaza.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import misiontic2022.com.laplaza.Entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("FROM Product p WHERE p.product_name LIKE :name")
    public List<Product> findByNameContaining(@Param("name") String name);
    
}
