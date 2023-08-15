package com.example.demo.service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    private static final Logger LOG = LoggerFactory.getLogger(EstudianteServiceImpl.class);

    @Autowired
    private IEstudianteRepository personaRepo;

    @Override
    @Async
    public CompletableFuture<LocalDate> agregar(Estudiante estudiante) {
        LOG.info("Hilo service (asincrono CompletableFuture): " + Thread.currentThread().getName());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.personaRepo.insertar(estudiante);
        return CompletableFuture.completedFuture(estudiante.getFechaNacimiento());
    }

}
