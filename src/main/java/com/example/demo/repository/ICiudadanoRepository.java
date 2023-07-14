package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Ciudadano;

public interface ICiudadanoRepository {

	public List<Ciudadano> seleccionarInnerJoin();

	public List<Ciudadano> seleccionarOuterRightJoin();

	public List<Ciudadano> seleccionarOuterLeftJoin();

//public List<Habitacion> seleccionarHabitacionOuterLeftJoin();

	public List<Ciudadano> seleccionarOuterFullJoin();

	public List<Ciudadano> seleccionarWhereJoin();
}
