package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICiudadanoRepository;
import com.example.demo.repository.modelo.Ciudadano;
@Service
public class CiudadanoServiceImpl implements ICiudadanoService{
	
	@Autowired
	private ICiudadanoRepository ciudadanoRepository;

	@Override
	public List<Ciudadano> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Ciudadano> buscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Ciudadano> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Ciudadano> buscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Ciudadano> buscarWhereJoin() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarWhereJoin();
	}

}
