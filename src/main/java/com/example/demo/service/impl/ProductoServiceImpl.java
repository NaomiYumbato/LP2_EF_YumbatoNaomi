package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductoEntity;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;

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

}