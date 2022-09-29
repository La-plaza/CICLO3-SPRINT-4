package misiontic2022.com.laplaza.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="product_name", nullable = false )
    private String product_name;

    @Column(name="description")
    private String description;

    @Column(name = "price")
    private int price;
    @Column(name = "cantidad")
    private String cantidad;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "products_producers", joinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false, updatable = false)
}, inverseJoinColumns = {
            @JoinColumn(name = "producer_id", referencedColumnName = "id", nullable = false, updatable = false)
})
private Set<Producer> producers = new HashSet<>();

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }
    public String getCantidad() {
        return cantidad;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Set<Producer> getProducers() {
        return producers;
    }

    public void setProducers(Set<Producer> producers) {
        this.producers = producers;
    }

    @Override
    public String toString() {
        return "Product [description=" + description + ", price=" + price +", cantidad=" + cantidad + ", product_name=" + product_name + "]";
    }

}
