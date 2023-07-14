package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.service.ICiudadanoService;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class Pa2TareasU3Application implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2TareasU3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// List<Hotel>listaHotel;
		// this.hotelService.buscarInnerJoin().stream().forEach(System.out::println);
		List<Ciudadano> listaCiudadanos;
		System.out.println("----------------------------- INNER JOIN --------------------------------");
		this.ciudadanoService.buscarInnerJoin().stream().forEach(System.out::println);
		System.out.println("--------------------------------- RIGHT OUTER JOIN ---------------------------------");
		this.ciudadanoService.buscarOuterRightJoin().stream().forEach(System.out::println);

		System.out.println("--------------------------------- LEFT OUTER JOIN ---------------------------------");
		this.ciudadanoService.buscarOuterLeftJoin().stream().forEach(System.out::println);

		System.out.println("--------------------------------- FULL OUTER JOIN ---------------------------------");
		this.ciudadanoService.buscarOuterFullJoin().stream().forEach(System.out::println);

		System.out.println("--------------------------------- WHERE JOIN ---------------------------------");
		this.ciudadanoService.buscarWhereJoin().stream().forEach(System.out::println);
	}

}
