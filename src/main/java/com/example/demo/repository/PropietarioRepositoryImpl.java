package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Transactional
@Repository
public class PropietarioRepositoryImpl implements IPropietarioRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(propietario);
	}

	@Override
	public Propietario encontraCedula(String cedula) {
		
		TypedQuery<Propietario>query=this.entityManager.createQuery("SELECT e FROM Propietario e WHERE e.cedula = :datoCedula",Propietario.class);
		query.setParameter("datoCedula", cedula);
		return query.getSingleResult();
	}

}
