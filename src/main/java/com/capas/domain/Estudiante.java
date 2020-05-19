package com.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_usuario;
	
	@Column(name="nombre")
	@Size(message = "El nombre no debe de tener mas de 30 caracteres",max=30)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String Nombre;
	
	@Column(name="apellido")
	@Size(message = "El apellido no debe de tener mas de 30 caracteres",max=30)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String Apellido;
	
	@Column(name="carne")
	@Size(message = "El carnét no debe de tener mas de 8 caracteres",max=8)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String carne;
	
	@Column(name="carrera")
	@Size(message = "El nombre de la carrera no debe de tener mas de 30 caracteres",max=30)
	@NotEmpty(message="Este campo no puede estar vacio")
	private String carrera;
	
	public Estudiante() {
	
	}

	public Integer getC_usuario() {
		return c_usuario;
	}

	public void setC_usuario(Integer c_usuario) {
		this.c_usuario = c_usuario;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
}
