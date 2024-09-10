package com.cursojava.f1.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Circuito {
	

	private String id;

	private String pais;
	
	//En metros
	private String nombre_circuito;
	
	private int distancia;

}
