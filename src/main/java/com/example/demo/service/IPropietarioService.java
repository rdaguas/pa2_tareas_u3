package com.example.demo.service;

import com.example.demo.repository.modelo.Propietario;

public interface IPropietarioService {

	public void agregar(Propietario propietario);
	
	public Propietario buscarCedula(String cedula);
}
