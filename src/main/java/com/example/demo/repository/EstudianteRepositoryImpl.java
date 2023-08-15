package com.example.demo.repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.example.demo.repository.modelo.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{

    private static final Logger LOG = LoggerFactory.getLogger(EstudianteRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Estudiante estudiante) {
        LOG.info("Hilo repo: " + Thread.currentThread().getName());
        this.entityManager.persist(estudiante);
    }
    
}
