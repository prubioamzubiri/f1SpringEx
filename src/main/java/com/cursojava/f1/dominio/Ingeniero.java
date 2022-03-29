package com.cursojava.f1.dominio;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Ingeniero")
public class Ingeniero {
	
	@Id
	private String id;

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="ano_nacimiento")
	private int ano_nacimiento;

}
