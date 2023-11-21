package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompetenciaPregunta implements Serializable {
	
	private int codigo;
	private int tipo;
	private String pregunta;
	private int orden;
	private int estado;
	
	private static final long serialVersionUID = 1L;
	
}
