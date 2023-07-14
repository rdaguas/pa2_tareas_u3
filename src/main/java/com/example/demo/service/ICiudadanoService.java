package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Ciudadano;

public interface ICiudadanoService {
	
	public List<Ciudadano> buscarInnerJoin();

	public List<Ciudadano> buscarOuterRightJoin();

	public List<Ciudadano> buscarOuterLeftJoin();

//public List<Habitacion> seleccionarHabitacionOuterLeftJoin();

	public List<Ciudadano> buscarOuterFullJoin();

	public List<Ciudadano> buscarWhereJoin();

}
