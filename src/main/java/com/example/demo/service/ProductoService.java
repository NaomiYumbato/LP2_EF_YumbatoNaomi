package com.example.demo.service;

import java.util.List;

import org.springframework.ui.Model;

import com.example.demo.entity.ProductoEntity;

public interface ProductoService {
	
	List<ProductoEntity> findAllProductos();
	void registrarProducto(ProductoEntity productoEntity, Model model);
	void editarProducto(ProductoEntity productoEntity, Model model);
	void eliminarProducto(Integer id);
	ProductoEntity buscarProductoPorId(Integer id);

}
