package com.cursojava.f1.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="Temporada")
public class Temporada {
	
	@Id
	private int anio;

	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Temporada_Equipo", 
        joinColumns = { @JoinColumn(name = "Temporada_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "Equipo_id") }
    )
	private List<Escuderia> escuderias;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Temporada_id")
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
