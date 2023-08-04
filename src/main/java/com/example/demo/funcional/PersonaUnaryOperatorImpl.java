package com.example.demo.funcional;

public class PersonaUnaryOperatorImpl implements IPersonaUnaryOperator<Double>{

	@Override
	public Double aplicar(Double arg) {
		Double num = arg * 0.3;
		return num;
	}

}
