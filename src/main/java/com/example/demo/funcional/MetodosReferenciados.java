package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {

	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

	
	//Supplier MR
	public Integer getId() {
		return 8;
	}

	// Consumer MR
	public void aceptar(String arg) {
		String cadena = "Jimmyyyyyyyyyyyy";
		LOG.info(cadena + " " + arg);
	}

	// Predicate MR
	public boolean evaluar(Integer arg) {
		if (arg.compareTo(2) == 0) {
			return true;
		} else {
			return false;
		}

	};

	// function MR

	public String aplicar(Integer arg) {

		return "Complemento " + arg;
	};

	// unary Operator MR
	public Integer agregar(Integer arg) {
		return arg + arg * 4;

	};

}
