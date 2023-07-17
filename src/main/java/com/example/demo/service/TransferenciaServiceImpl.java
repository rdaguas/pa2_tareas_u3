package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.ITransferenciaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;


@Service
public class TransferenciaServiceImpl implements ITransferenciaService{

	@Autowired
	private ITransferenciaRepository iTransferenciaRepo;
	@Autowired
	private ICuentaBancariaRepository bancariaRepo;
	
	@Override
	public void realizarTransferencia(String numeroOrigen, String numeroDestino, BigDecimal montoT) {
		// TODO Auto-generated method stub
		CuentaBancaria bancariaO=this.bancariaRepo.encontrarPorNumero(numeroOrigen);
		CuentaBancaria bancariaD=this.bancariaRepo.encontrarPorNumero(numeroDestino);
		
		Transferencia transferencia= new Transferencia();
		transferencia.setFecha(LocalDate.now());
		transferencia.setMonto(montoT);
		transferencia.setCuentaBancariaO(bancariaO);
		transferencia.setCuentaBancariaD(bancariaD);
		
		if(bancariaO.getSaldo().compareTo(montoT)>=0) {
			
		bancariaO.setSaldo(bancariaO.getSaldo().subtract(montoT));
		this.bancariaRepo.actualizar(bancariaO);
		
		bancariaD.setSaldo(bancariaD.getSaldo().add(montoT));
		this.bancariaRepo.actualizar(bancariaD);
		
		this.iTransferenciaRepo.insertarTransferencia(transferencia);
		
			
			
		}else {
			System.out.println("NO HAY COMO REALIZAR LA TRANSFERENCIA");
			System.out.println("NO TIENE SALDO EN SU CUENTA");
		}
		
		
	}

	@Override
	public List<Transferencia> buscarTodos() {
		// TODO Auto-generated method stub
		System.out.println("**********************************REPORTE DE LAS TRANSFERENCIAS**********************************");
		
		return this.iTransferenciaRepo.encontrarTodos();
	}

}
