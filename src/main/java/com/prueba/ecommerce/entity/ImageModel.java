package com.prueba.ecommerce.entity;

import javax.persistence.*;

@Entity
@Table(name = "image_model")
public class ImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String tipo;

    @Column(length = 60000000)
    private Byte[] imaByte;

    public ImageModel(String originalFilename, String contentType, byte[] bytes) {

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Byte[] getImaByte() {
        return imaByte;
    }

    public void setImaByte(Byte[] imaByte) {
        this.imaByte = imaByte;
    }
}
