package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_producto")
public class ProductoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto", nullable = false)
	private Integer idProducto;

	@Column(name = "nombre", nullable = false, columnDefinition = "VARCHAR(50)")
	private String nombre;

	@Column(name = "precio", nullable = false)
	private Double precio;

	@Column(name = "stock", nullable = false)
	private Integer stock;

	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false)
	private CategoriaEntity categoriaEntity;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public CategoriaEntity getCategoriaEntity() {
		return categoriaEntity;
	}

	public void setCategoriaEntity(CategoriaEntity categoriaEntity) {
		this.categoriaEntity = categoriaEntity;
	}

	public ProductoEntity(Integer idProducto, String nombre, Double precio, Integer stock,
			CategoriaEntity categoriaEntity) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoriaEntity = categoriaEntity;
	}

	public ProductoEntity() {
	}

}
