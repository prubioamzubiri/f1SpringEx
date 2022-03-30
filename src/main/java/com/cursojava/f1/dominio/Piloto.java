package com.cursojava.f1.dominio;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Piloto")
public class Piloto {
	
	@Id
//	@GeneratedValue
	@Column(name="id")
	private String id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="anio_nacimiento")
	private int anio_nacimiento;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="primera_temporada")
	private int primera_temporada;
	
	@Column(name="mundiales")
	private int mundiales;

	@Column(name="foto")
	private String foto;

	public String getFoto()
	{
		return "fotos/pilotos/" + foto;
	}
	


}
