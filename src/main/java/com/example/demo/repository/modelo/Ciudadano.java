package com.example.demo.repository.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudadano")
public class Ciudadano {
	@Id
	@GeneratedValue(generator = "seq_ciu", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_ciu", sequenceName = "seq_ciu", allocationSize = 1)
	
	@Column(name = "ciu_id")
	private Integer id;
	@Column(name = "ciu_nombre")
	private String nombre;
	@Column(name = "ciu_apellido")
	private String apellido;
	@Column(name = "ciu_cedula")
	private String cedula;

	@OneToOne(mappedBy = "ciudadano",cascade = CascadeType.ALL)
	private Empleado empleado;
	


	@Override
	public String toString() {
		return "Ciudadano [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Integer getId() {
		return id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}



	
	
}
