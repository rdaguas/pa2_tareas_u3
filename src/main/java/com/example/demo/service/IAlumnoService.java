package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Alumno;

public interface IAlumnoService {
	
	
	public List<Alumno> buscarInnerJoin();

	public List<Alumno> buscarOuterRightJoin();

	public List<Alumno> buscarOuterLeftJoin();

	public List<Alumno> buscarOuterFullJoin();

	public List<Alumno> buscarWhereJoin();

}
