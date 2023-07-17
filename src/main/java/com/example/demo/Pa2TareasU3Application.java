package com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IAlumnoService;
import com.example.demo.service.ICiudadanoService;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IHotelService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;



@SpringBootApplication
public class Pa2TareasU3Application implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private ICiudadanoService ciudadanoService;

	@Autowired
	private IAlumnoService alumnoService;

	@Autowired
	private IPropietarioService iPropietarioService;

	@Autowired
	private ICuentaBancariaService bancariaService;

	@Autowired
	private ITransferenciaService iTransferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2TareasU3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// 1. Guardar Cta Bancaria

		Propietario propietario = new Propietario();
		propietario.setNombre("Roberto");
		propietario.setApellido("Aguas");
		propietario.setCedula("172434");
		this.iPropietarioService.agregar(propietario);

		Propietario propietarioO = this.iPropietarioService.buscarCedula("172434");

		CuentaBancaria bancaria = new CuentaBancaria();
		bancaria.setNumero("1234");
		bancaria.setPropietario(propietarioO);
		bancaria.setSaldo(new BigDecimal(6000));
		bancaria.setTipo("TIPO A");
		this.bancariaService.agregar(bancaria);

		Propietario propietario2 = new Propietario();
		propietario2.setNombre("Daniel");
		propietario2.setApellido("Valencia");
		propietario2.setCedula("1234");
		this.iPropietarioService.agregar(propietario2);

		Propietario propietarioO2 = this.iPropietarioService.buscarCedula("1234");
		CuentaBancaria bancaria2 = new CuentaBancaria();
		bancaria2.setNumero("404040");
		bancaria2.setPropietario(propietarioO2);
		bancaria2.setSaldo(new BigDecimal(2000));
		bancaria2.setTipo("TIPO A");
		this.bancariaService.agregar(bancaria2);

		this.iTransferenciaService.realizarTransferencia("1234", "404040", new BigDecimal(300));

		this.iTransferenciaService.buscarTodos().stream().forEach(System.out::println);
		;

//		// Primeros 5, con Ciudadanos
//		List<Ciudadano> listaCiudadanos;
//		System.out.println("----------------------------- INNER JOIN --------------------------------");
//		this.ciudadanoService.buscarInnerJoin().stream().forEach(System.out::println);
//		System.out.println("--------------------------------- RIGHT OUTER JOIN ---------------------------------");
//		this.ciudadanoService.buscarOuterRightJoin().stream().forEach(System.out::println);
//
//		System.out.println("--------------------------------- LEFT OUTER JOIN ---------------------------------");
//		this.ciudadanoService.buscarOuterLeftJoin().stream().forEach(System.out::println);
//
//		System.out.println("--------------------------------- FULL OUTER JOIN ---------------------------------");
//		this.ciudadanoService.buscarOuterFullJoin().stream().forEach(System.out::println);
//
//		System.out.println("--------------------------------- WHERE JOIN ---------------------------------");
//		this.ciudadanoService.buscarWhereJoin().stream().forEach(System.out::println);
//
//		//  5 seguientes, Alumnos
//		List<Alumno> listaAlumnos;
//		System.out.println("----------------------------- INNER JOIN --------------------------------");
//		this.alumnoService.buscarInnerJoin().stream().forEach(System.out::println);
//		System.out.println("--------------------------------- RIGHT OUTER JOIN ---------------------------------");
//		this.alumnoService.buscarOuterRightJoin().stream().forEach(System.out::println);
//
//		System.out.println("--------------------------------- LEFT OUTER JOIN ---------------------------------");
//		this.alumnoService.buscarOuterLeftJoin().stream().forEach(System.out::println);
//
//		System.out.println("--------------------------------- FULL OUTER JOIN ---------------------------------");
//		this.alumnoService.buscarOuterFullJoin().stream().forEach(System.out::println);
//
//		System.out.println("--------------------------------- WHERE JOIN ---------------------------------");
//		this.alumnoService.buscarWhereJoin().stream().forEach(System.out::println);
	}

}
