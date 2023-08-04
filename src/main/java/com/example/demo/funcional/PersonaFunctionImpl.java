package com.example.demo.funcional;

public class PersonaFunctionImpl implements IPersonaFunction<String, Integer>{

	@Override
	public String aplicar(Integer arg) {
		String valorFinal = arg.toString().concat(" - valor string");
		return valorFinal;
	}

}
