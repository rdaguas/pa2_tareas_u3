package com.example.demo.repository;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {

	public void insertar(CuentaBancaria bancaria);
	public CuentaBancaria encontrarPorNumero(String numero);
	public void actualizar(CuentaBancaria bancaria);
	
}
