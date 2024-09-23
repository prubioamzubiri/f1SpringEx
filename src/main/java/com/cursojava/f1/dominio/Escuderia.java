package com.cursojava.f1.dominio;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Escuderia {
	
	private String id;

	private String nombre_escuderia;

	private int mundiales_de_constructores;

	private List<Piloto> pilotos;

	private List<Ingeniero> ingenieros;

	private String foto;
	
	public Escuderia(String id, String nombre_escuderia,  int mundiales_de_constructores, String foto)
	{
		this.id = id;
		this.nombre_escuderia = nombre_escuderia;
		this.mundiales_de_constructores = mundiales_de_constructores;
		this.foto = foto;
		
		ingenieros = new ArrayList<Ingeniero>();
		
		pilotos = new ArrayList<Piloto>();
	}
	
	public Escuderia(String nombre_escuderia,  int mundiales_de_constructores, String foto)
	{
		this.nombre_escuderia = nombre_escuderia;
		this.mundiales_de_constructores = mundiales_de_constructores;
		this.foto = foto;
		
		ingenieros = new ArrayList<Ingeniero>();
		
		pilotos = new ArrayList<Piloto>();
	}
	
	public Escuderia()
	{
		
		ingenieros = new ArrayList<Ingeniero>();
		
		pilotos = new ArrayList<Piloto>();
	}
	

	public void addIngeniero(Ingeniero i)
	{
		this.ingenieros.add(i);
	}

	public void addPiloto(Piloto p)
	{
		this.pilotos.add(p);
	}

	public String getFoto()
	{
		return "fotos/escuderias/"+ foto;
	}


}
