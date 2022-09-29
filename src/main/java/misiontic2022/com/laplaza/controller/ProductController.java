package misiontic2022.com.laplaza.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import misiontic2022.com.laplaza.Entity.Producer;
import misiontic2022.com.laplaza.Entity.Product;
import misiontic2022.com.laplaza.Repository.IProducerRepository;
import misiontic2022.com.laplaza.Service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private IProducerRepository producerRepository;

    private List<Producer> producersList = new ArrayList<>();
    
    public ProductController(ProductService productService, IProducerRepository producerRepository) {
        this.productService = productService;
        this.producerRepository = producerRepository;

        this.producersList = this.producerRepository.findAllSortByName();
    }


    @GetMapping("/productos")
    public String crudp(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "productos";
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "ListarProducto";
    }
        
    @GetMapping("/products/new")
    public String createProductForm(Model model) {

        Product product = new Product();

        model.addAttribute("product", product);
        model.addAttribute("producersList", producersList);

        return "CrearProducto";
    }

    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }
  
    @GetMapping("/actualizar/{id}")
    public String irActualizar(@PathVariable Long id, Model model) {
        Product pr = productService.getProductById(id);
        model.addAttribute("producersList", producersList);
        if(pr.getId() !=0){model.addAttribute("product", pr);
        return "ActualizarProducto";
    } else {
        return "redirect:/products";}      
        

        
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id,
            @ModelAttribute("product") Product product,
            Model model) {
        // sacar el estudiante de la b.d. por el id
        Product existentProduct = productService.getProductById(id);
        // cargarlo
        existentProduct.setId(id);
        existentProduct.setProduct_name(product.getProduct_name());
        existentProduct.setDescription(product.getDescription());
        existentProduct.setPrice(product.getPrice());
        existentProduct.setCantidad(product.getCantidad());


        existentProduct.setProducers(product.getProducers());

        // guardar el estudiante actualizado
        productService.actualizar(existentProduct);

        return "redirect:/products";
            }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id,
            @ModelAttribute("product") Product product,
            Model model) {
        // sacar el estudiante de la b.d. por el id
        Product existentProduct = productService.getProductById(id);
        // cargarlo
        existentProduct.setId(id);
        existentProduct.setProduct_name(product.getProduct_name());
        existentProduct.setDescription(product.getDescription());
        existentProduct.setPrice(product.getPrice());
        existentProduct.setCantidad(product.getCantidad());


        existentProduct.setProducers(product.getProducers());

        // guardar el estudiante actualizado
        productService.updateProduct(existentProduct);

        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }

  
}

