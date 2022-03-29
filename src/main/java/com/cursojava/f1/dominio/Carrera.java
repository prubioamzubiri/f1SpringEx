package com.cursojava.f1.dominio;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="Carrera")
public class Carrera {
	
	@Id
	private String id;

	private String nombre_gp;

	@ManyToOne()
	@JoinColumn(name ="Circuito_id")
	private Circuito circuito;
	
	private Date fecha_gp;
	
	@ElementCollection
    @CollectionTable(name = "posicion_en_carrera", 
      joinColumns = {@JoinColumn(name = "posicion_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "posición")
    @Column(name = "piloto")
	private Map<Integer, Piloto> pilotos_por_posicion;
	
	public Carrera(String nombre_gp, Date fecha_gp, Circuito circuito)
	{
		this.nombre_gp = nombre_gp;
		this.fecha_gp = fecha_gp;
		this.circuito = circuito;
		
		pilotos_por_posicion = new HashMap<Integer, Piloto>();
	}
	
	public Carrera()
	{
		pilotos_por_posicion = new HashMap<Integer, Piloto>();
	}
}

