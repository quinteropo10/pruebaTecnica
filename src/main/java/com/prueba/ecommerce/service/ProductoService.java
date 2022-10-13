package com.prueba.ecommerce.service;

import com.prueba.ecommerce.dao.IProductoDao;
import com.prueba.ecommerce.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class ProductoService {

    @Autowired
    private IProductoDao productoDao;

    public Producto addProducto(Producto producto){

        return productoDao.save(producto);

    }

    public List<Producto> getAllProductos(){

        return (List<Producto>) productoDao.findAll();
    }

    public Producto getProductoDetallesById(Long id){
        return productoDao.findAllById(id);
    }
}
