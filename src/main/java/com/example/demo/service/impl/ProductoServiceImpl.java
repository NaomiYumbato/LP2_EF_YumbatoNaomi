package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.entity.ProductoEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;
import com.example.demo.utils.Utils;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<ProductoEntity> findAllProductos() {
		return productoRepository.findAll();
	}
	
	@Override
	public ProductoEntity buscarProductoPorId(Integer id) {
		
		return productoRepository.findById(id.intValue()).get();
	}

	@Override
	public void registrarProducto(ProductoEntity productoEntity, Model model) {

		productoRepository.save(productoEntity);

		model.addAttribute("registroCorrecto", "Producto registrado correctamente");
		model.addAttribute("prod", new ProductoEntity());

		
	}

	@Override
	public void editarProducto(ProductoEntity productoEntity, Model model) {
		
		productoRepository.save(productoEntity);
		
	}

	@Override
	public void eliminarProducto(Integer id) {
		
		productoRepository.deleteById(id);
		
	}

}
