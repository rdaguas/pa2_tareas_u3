package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.repository.modelo.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class AlumnoRepositoryImpl implements IAlumnoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Alumno> seleccionarInnerJoin() {
		TypedQuery<Alumno> myQuery = this.entityManager
				.createQuery("SELECT h FROM Alumno h INNER JOIN h.matriculas ha", Alumno.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Alumno> seleccionarOuterRightJoin() {
		TypedQuery<Alumno> myQuery = this.entityManager
				.createQuery("SELECT h FROM Alumno h RIGHT JOIN h.matriculas ha", Alumno.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Alumno> seleccionarOuterLeftJoin() {
		TypedQuery<Alumno> myQuery = this.entityManager
				.createQuery("SELECT h FROM Alumno h LEFT JOIN h.matriculas ha", Alumno.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Alumno> seleccionarOuterFullJoin() {
		TypedQuery<Alumno> myQuery = this.entityManager
				.createQuery("SELECT h FROM Alumno h FULL JOIN h.matriculas ha", Alumno.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Alumno> seleccionarWhereJoin() {
		TypedQuery<Alumno> myQuery = this.entityManager
				.createQuery("SELECT h FROM Alumno h, Matricula ha WHERE h=ha.alumno", Alumno.class);
		return myQuery.getResultList();
	}
}