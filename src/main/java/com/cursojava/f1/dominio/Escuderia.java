package com.cursojava.f1.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="Escuderia")
public class Escuderia {
	
	@Id
	private String id;


	private String nombre_escuderia;

	private int mundiales_de_constructores;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Escuderia_id")
	private List<Piloto> pilotos;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Escuderia_id")
	private List<Ingeniero> ingenieros;
	
	//@OneToOne(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@OneToOne
    @JoinColumn(name = "id")
	private Ingeniero jefe_escuderia;

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
	
	public Escuderia(String nombre_escuderia,  int mundiales_de_constructores, Ingeniero jefe_escuderia, String foto)
	{
		this.nombre_escuderia = nombre_escuderia;
		this.mundiales_de_constructores = mundiales_de_constructores;
		this.jefe_escuderia = jefe_escuderia;
		this.foto = foto;
		
		ingenieros = new ArrayList<Ingeniero>();
		
		ingenieros.add(jefe_escuderia);
		
		pilotos = new ArrayList<Piloto>();
	}
	
	public Escuderia()
	{
		
		ingenieros = new ArrayList<Ingeniero>();
		
		pilotos = new ArrayList<Piloto>();
	}
	
	public void setJefe_escuderia(Ingeniero jefe)
	{
		if(!ingenieros.contains(jefe))
		{
			ingenieros.add(jefe);
		}
		
		this.jefe_escuderia= jefe;
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
