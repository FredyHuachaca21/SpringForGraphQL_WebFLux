package com.fredgar.pe.service;

import com.fredgar.pe.input.ProductoRecord;
import com.fredgar.pe.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
  Optional<Product> getProductById(String id);
  List<Product> getAllProducts();
  Boolean deleteProductById(String id);
  Product crearProducto(ProductoRecord productoRecord);
  Product actualizarProducto(String id, ProductoRecord productoRecord);

}
