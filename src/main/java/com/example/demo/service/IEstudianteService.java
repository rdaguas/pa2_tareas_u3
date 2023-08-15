package com.example.demo.service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {
        public CompletableFuture<LocalDate> agregar(Estudiante estudiante);
}
