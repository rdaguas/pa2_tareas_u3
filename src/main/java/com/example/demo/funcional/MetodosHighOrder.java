package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {

	private static final Logger LOG = LoggerFactory.getLogger(MetodosHighOrder.class);

	// es una implementacion
	public static void metodo(IPersonaSupplier<String> funcion) {
		funcion.getId();
		// LOG.info("High Order Supplier " + funcion.getId());

	}

	public static void metodoConsumer(IPersonaConsumer<String> funcion2, String cadena) {
		funcion2.accept("High order Consumer: " + cadena);
	}

	public static void metodoPredicate(IPersonaPredicate<Integer> numero, Integer n) {
		numero.evaluar(n);
//		LOG.info("High order predicate: " + numero.evaluar(n));
	}

	public static void metodoFunction(IPersonaFunction<String, Integer> function, Integer arg) {
		LOG.info("High order function: " + function.aplicar(arg));
	}

	public static void metodoUnary(IPersonaUnaryOperator<Double> unary, Double arg) {

		LOG.info("High order unary " + unary.aplicar(arg));

	}
}
