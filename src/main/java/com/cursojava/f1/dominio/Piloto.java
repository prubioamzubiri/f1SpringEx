package com.cursojava.f1.dominio;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Piloto {
	
	private String id;

	private String nombre;

	private int anio_nacimiento;

	private int numero;

	private int primera_temporada;

	private int mundiales;

	private String foto;

	public String getFoto()
	{
		return "fotos/pilotos/" + foto;
	}
	


}
