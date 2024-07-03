package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity {

	@Id
	@Column(name = "correo", nullable = false)
	private String correo;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "nombres", nullable = false, columnDefinition = "VARCHAR(50)")
	private String nombres;

	@Column(name = "apellidos", nullable = false, columnDefinition = "VARCHAR(50)")
	private String apellidos;

	@Column(name = "fec_nacimiento", nullable = false)
	private LocalDate fecNacimiento;

	@Column(name = "url_imagen", nullable = false, columnDefinition = "VARCHAR(50)")
	private String urlImagen;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFecNacimiento() {
		return fecNacimiento;
	}

	public void setFecNacimiento(LocalDate fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	

	public UsuarioEntity() {
		super();
	}

	public UsuarioEntity(String correo, String password, String nombres, String apellidos, LocalDate fecNacimiento,
			String urlImagen) {
		super();
		this.correo = correo;
		this.password = password;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fecNacimiento = fecNacimiento;
		this.urlImagen = urlImagen;
	}
	
}
