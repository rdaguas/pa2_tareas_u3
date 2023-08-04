package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		IPersona per = new PersonaImpl();
		per.caminar();

		// 1. SUPPLIER

		// CLASES:
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("SUPPLIER Clase: " + supplier1.getId());
		// LOG.error("SUPPLIER Clase: " + supplier1.getId());

		// Lambdas
		IPersonaSupplier<String> supplier2 = () -> "1724340391";
		LOG.info("SUPPLIER LAMBDA: " + supplier2.getId());

		// Lambdas
		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "1724340391";
			cedula = cedula + "zzzz";
			return cedula;
		};
		LOG.info("SUPPLIER LAMBDA 2: " + supplier3.getId());

		// METODOS REFERENCIADOS

		MetodosReferenciados metodosReferenciados = new MetodosReferenciados();
		IPersonaSupplier<Integer> supplier4 = MetodosReferenciados::getId;
		LOG.info("**********************METODOS REFERENCIADOS*************************");

		LOG.info("SUPPLIER METODO REFERENCIADO: " + supplier4.getId());

		// 2. CONSUMMER

		// CLASES:
		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		LOG.info("Consumer Clase: ");
		consumer1.accept("Jimmy Ortega");

		IPersonaConsumer<String> consumer2 = cadena -> {
			LOG.info("Consumer lambda");
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		};
		consumer2.accept("Jimmy Ortega 2");

		// METODO REFERENCIADO

		IPersonaConsumer<String> consumer3 = MetodosReferenciados::aceptar;
		LOG.info("Consumer Metodos Referenciados");
		consumer3.accept("A");

		// 3. PREDICATE
		// LAMBDAS
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8) == 0;
		LOG.info("Predicate Lambda: " + predicate1.evaluar(8));

		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;
			valor = valor + valor2;
			if (valor.compareTo(100) > 0) {
				return true;

			} else {
				return false;
			}

		};
		LOG.info("Predicate Lambda 2: " + predicate2.evaluar(55));

		IPersonaPredicate<String> predicate3 = letra -> "Jimmy".contains(letra);
		LOG.info("Predicate Lambda 3: " + predicate3.evaluar("i"));

		IPersonaBIPredicate<String, String> predicate4 = (letra, cadena) -> cadena.contains(letra);
		LOG.info("Predicate Lambda 4: " + predicate4.evaluar("F", "Felix"));

		// METODO REFERENCIADO

		IPersonaPredicate<Integer> predicate5 = MetodosReferenciados::evaluar;
		LOG.info("Predicate Metodo Referenciado5: " + predicate5.evaluar(8));

		// 4. FUNCTION
		// funciones de casteo
		// elprimer argunmento de mi interfaz es de retorno
		IPersonaFunction<String, Integer> function = numero -> numero.toString();
		LOG.info("Function lambda: " + function.aplicar(8));

		IPersonaFunction<String, Integer> function1 = numero -> {
			String valorFinal = numero.toString().concat("valor");
			return valorFinal;
		};
		LOG.info("Function lambda1: " + function1.aplicar(10));

		// 5. UNARY OPERATOR

		IPersonaUnaryOperator<Integer> unary = numero -> numero + (numero * 2);
		LOG.info("Unary lambda: " + unary.aplicar(3));

		IPersonaUnaryOperatorFunction<Integer> unary2 = numero -> numero + (numero * 2);
		LOG.info("Unary lambda2" + ": " + unary2.aplicar(3));

		// **************** METODOS HIGH ORDER *******************

		MetodosHighOrder highOrder = new MetodosHighOrder();
		// 1. Clase
		IPersonaSupplier<String> supplierHO = new PersonaSupplierImpl();
		highOrder.metodo(supplierHO);

		// 2. Lambdas
		highOrder.metodo(() -> "1724340391HO");

		// 3. Metodos Referenciados
		highOrder.metodo(MetodosReferenciados::getIdHO);

		// Consumer
		// Clase
		MetodosHighOrder.metodoConsumer(new PersonaConsumerImpl(), "Clase Consumer");

		// Lambdas
		MetodosHighOrder.metodoConsumer(cadena -> LOG.info(cadena), "lambdas Consumer");

		MetodosHighOrder.metodoConsumer(MetodosReferenciados::aceptar, "Metodos Referenciados Consumer");

//		// Interfaces Funcionales JAVA
//		// 1. SUPPLER
//
//		// Supplier
//		Stream<String> lista = Stream.generate(() -> "1724340391HO").limit(20);
//		lista.forEach(cadena -> LOG.info(cadena));
//
//		// 2. CONSUMER
//
//		List<Integer> listaNumeros = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
//		listaNumeros.forEach(cadena -> {
//
//			LOG.info("" + cadena);
//		});
//
//		// 3. PREDICATE
//		Stream<Integer> listaFinal = listaNumeros.stream().filter(numero -> numero >= 5);
//		listaFinal.forEach(numero -> LOG.info("Valor: " + numero));
//
//		// 4. FUNCTION
//		Stream<String> listaCambiada = listaNumeros.stream().map(numero -> {
//			Integer num = 10;
//			num = numero * num;
//			return "N:" + num;
//		});
//		listaCambiada.forEach(cadena -> LOG.info(cadena));
//

		//		// 5. UNARYOPERATOR
//
//		Stream<Integer> listaCambiada2 = listaNumeros.stream().map(numero -> {
//			Integer num = 10;
//			num = numero + num;
//			return num;
//		});
//		listaCambiada2.forEach(cadena -> LOG.info(cadena.toString()));

		// metodos referenciados
		//LOG.info("TAREA 16");
		// 1. supllier

//		MetodosHighOrder.metodo(metodosReferenciados::getIdHO);
//		// 2.Consumer
//		MetodosHighOrder.metodoConsumer(MetodosReferenciados::aceptar, "Metodo Consumer");
//		// 3.Predicate
//		MetodosHighOrder.metodoPredicate(MetodosReferenciados::evaluar, 5);
//		// 4.Function
//		MetodosHighOrder.metodoFunction(MetodosReferenciados::aplicar, 4);
//		// 5.UnaryOperator
//		MetodosHighOrder.metodoUnary(MetodosReferenciados::aplicar, 6.8);
		
		LOG.info("**************************TAREA 17********************************");
		//metodos referenciados 
		//1. supllier
		
		// 1. Clase
		IPersonaSupplier<String> supplierHO2 = new PersonaSupplierImpl();
		highOrder.metodo(supplierHO2);

		// 2. Lambdas
		highOrder.metodo(() -> "1234HO");
		//3.Referenciados
		highOrder.metodo(MetodosReferenciados::getIdHO);
		
		
		//2.Consumer
		// 1. Clase
		LOG.info("Consumer Clase");
		IPersonaConsumer<String> consumerHO2 = new PersonaConsumerImpl();
		highOrder.metodoConsumer(consumerHO2, "Clase consumer");
		// 2. Lambdas
		LOG.info("Consummer Lambdas");
		highOrder.metodoConsumer(cadena -> LOG.info(cadena), "Lambdas Consumer");
		//3.Referenciados
		LOG.info("Consumer Referenciados");
		highOrder.metodoConsumer(MetodosReferenciados::aceptar, "Metodos referenciados Consumer");
		
		
		//3.Predicate
		//1.Clases
		LOG.info("Predicate Clases");
		IPersonaPredicate<Integer>predicate= new PersonaPredicateImpl();
		highOrder.metodoPredicate(predicate, 7);
		//2.Lambdas
		LOG.info("Lambdas Predicate");
		Integer x=5;
		highOrder.metodoPredicate(n -> n.compareTo(x)==0 , x);
		//3.Referenciados
		LOG.info("Refrenciados Predicate");
		highOrder.metodoPredicate(MetodosReferenciados::evaluar,6);
		
		
		//4.Function
		LOG.info("Clases Function");
		IPersonaFunction<String, Integer>function3= new PersonaFunctionImpl();
		highOrder.metodoFunction(function3, 2);
		LOG.info("Lambdas Function");
		highOrder.metodoFunction(val -> val.toString().concat(" Lambda") , x);
		LOG.info("Referenciados Function");
		highOrder.metodoFunction(MetodosReferenciados::aplicar, 6);
		
		
		//5.UnaryOperator
		
		LOG.info("Clases Unary Operator");
		IPersonaUnaryOperator<Double>unary4= new PersonaUnaryOperatorImpl();
		highOrder.metodoUnary(unary4, 9.2);
		
		LOG.info("Lambdas Unary Operator");
		Double y=8.6;
		highOrder.metodoUnary(dou-> y*0.2, y);
		
		LOG.info("Refeernciados Unary Operator");
		highOrder.metodoUnary(MetodosReferenciados::aplicar, 8.6);



	
	}

}
