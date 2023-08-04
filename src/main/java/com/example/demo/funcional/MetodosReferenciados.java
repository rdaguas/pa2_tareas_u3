package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {

	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

	public static Integer getId() {
		return 8;
	}
	
	public  String getIdHO() {
		LOG.info("Metodos ReferenciadosHO");
		return "Robertooo";
	}
	//consumer
	public static void aceptar(String arg) {
		String cadena = "ConsumerHO MR";
		LOG.info(cadena + " " + arg);
	}
	//predicate
	public static boolean evaluar(Integer arg) {
		Integer numero = 2;
		LOG.info(" " + numero + 5);
		return true;
	}

	//function
	public static String aplicar(Integer arg) {
		String valorFinal = arg.toString().concat(" es un valor");
		return valorFinal;
	}

	//unary operator
	public  static Double aplicar(Double arg) {
		Double num = arg * 0.8;
		return num;
	}
}
