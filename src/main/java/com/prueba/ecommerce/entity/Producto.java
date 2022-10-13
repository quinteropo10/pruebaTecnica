package com.prueba.ecommerce.entity;




import javax.persistence.*;
import java.util.Set;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreProducto;
    private String descripcionProducto;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "producto_images",
            joinColumns = {
            @JoinColumn(name = "producto_id")
            },
            inverseJoinColumns = {
            @JoinColumn(name = "image_id")
            }
    )
    private Set<ImageModel> productoImage;

    public Set<ImageModel> getProductoImage() {
        return productoImage;
    }

    public void setProductoImage(Set<ImageModel> productoImage) {
        this.productoImage = productoImage;
    }

    public Producto(String nombreProducto, String descripcionProducto, Set<ImageModel> productoImage) {
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.productoImage = productoImage;
    }

    public Producto(Set<ImageModel> productoImage) {

        this.productoImage = productoImage;
    }

    public Producto() {

    }


    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
}
