package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Alumno;

public interface IAlumnoRepository {
	
	public List<Alumno> seleccionarInnerJoin();

	public List<Alumno> seleccionarOuterRightJoin();

	public List<Alumno> seleccionarOuterLeftJoin();

	public List<Alumno> seleccionarOuterFullJoin();

	public List<Alumno> seleccionarWhereJoin();

}
