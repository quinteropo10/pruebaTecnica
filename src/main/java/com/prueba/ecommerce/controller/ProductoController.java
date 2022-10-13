package com.prueba.ecommerce.controller;

import com.prueba.ecommerce.entity.ImageModel;
import com.prueba.ecommerce.entity.Producto;
import com.prueba.ecommerce.service.ProductoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ProductoController {

    private ProductoService productoService;

    @PostMapping(value = {"/producto/add"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Producto addProducto(@RequestPart("producto") Producto producto,
                                @RequestPart("imageFile") MultipartFile[] file) {

        //return productoService.addProducto(producto);

        try {
            Set<ImageModel> images = uploadImage(file);
            producto.setProductoImage(images);
            return productoService.addProducto(producto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }


    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();

        for (MultipartFile file : multipartFiles) {
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }

    @GetMapping("/getAllProducts")
    public List<Producto> getAllProductos() {
       return productoService.getAllProductos();
    }

    @GetMapping("/getProductoDetallesById/{id}")
    public Producto getProductoDetallesById(@PathVariable("id") Long id){
      return productoService.getProductoDetallesById(id);
    }


}
