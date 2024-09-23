package com.cursojava.f1.dominio;

import java.util.ArrayList;
import java.util.List;




import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Temporada {

	private String id;
	
	private int anio;

	private List<Escuderia> escuderias;

	private List<Carrera> carreras;
	
	public Temporada(int anio)
	{
		this.anio = anio;
		
		escuderias = new ArrayList<Escuderia>();
		
		carreras = new ArrayList<Carrera>();
	}
	
	public Temporada()
	{
		escuderias = new ArrayList<Escuderia>();
		
		carreras = new ArrayList<Carrera>();
	}

}
