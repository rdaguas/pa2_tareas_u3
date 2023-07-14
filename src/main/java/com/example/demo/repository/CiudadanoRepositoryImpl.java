package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.repository.modelo.Ciudadano;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Ciudadano> seleccionarInnerJoin() {
		// SELECT * FROM ciudadano ci inner join empleado em on ci.ciu_id=
		// em.empl_id_ciu
		// SELECT ci FROM Ciudadano ci INNER JOIN ci.empleado em
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT ci from Ciudadano ci INNER JOIN ci.empleado em", Ciudadano.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Ciudadano> seleccionarOuterRightJoin() {
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT ci from Ciudadano ci RIGHT JOIN ci.empleado em", Ciudadano.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Ciudadano> seleccionarOuterLeftJoin() {
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT ci from Ciudadano ci LEFT JOIN ci.empleado em", Ciudadano.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Ciudadano> seleccionarOuterFullJoin() {
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT ci from Ciudadano ci FULL JOIN ci.empleado em", Ciudadano.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Ciudadano> seleccionarWhereJoin() {
		TypedQuery<Ciudadano> myQuery = this.entityManager
				.createQuery("SELECT ci FROM Ciudadano ci, Empleado em WHERE ci=em.ciudadano", Ciudadano.class);
		return myQuery.getResultList();
	}

}
