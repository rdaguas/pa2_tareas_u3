package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IAlumnoRepository;
import com.example.demo.repository.modelo.Alumno;
@Service
public class AlumnoServiceImpl implements IAlumnoService{

	@Autowired
	private IAlumnoRepository alumnoRepository;
	
	@Override
	public List<Alumno> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.alumnoRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Alumno> buscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.alumnoRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Alumno> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.alumnoRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Alumno> buscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.alumnoRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Alumno> buscarWhereJoin() {
		// TODO Auto-generated method stub
		return this.alumnoRepository.seleccionarWhereJoin();
	}

}
