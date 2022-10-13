package com.prueba.ecommerce.dao;

import com.prueba.ecommerce.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<Producto, Long> {


    Producto findAllById(Long id);
}
