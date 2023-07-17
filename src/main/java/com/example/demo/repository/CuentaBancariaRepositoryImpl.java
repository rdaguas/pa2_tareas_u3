package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional

public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(bancaria);
	}

	@Override
	public CuentaBancaria encontrarPorNumero(String numero) {

TypedQuery<CuentaBancaria>query=this.entityManager.createQuery("SELECT e FROM CuentaBancaria e WHERE e.numero = :datoNumero",CuentaBancaria.class);
query.setParameter("datoNumero", numero);
return query.getSingleResult();
	}

	@Override
	public void actualizar(CuentaBancaria bancaria) {
		
		this.entityManager.merge(bancaria);
		
	}

}
