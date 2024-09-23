package com.cursojava.f1.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingeniero {
	
	private String id;

	private String dni;

	private String nombre;

	private int anio_nacimiento;

}
