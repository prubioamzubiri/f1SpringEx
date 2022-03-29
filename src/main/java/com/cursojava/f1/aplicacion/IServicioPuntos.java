package com.cursojava.f1.aplicacion;

import java.util.Map;

import com.cursojava.f1.dominio.Escuderia;
import com.cursojava.f1.dominio.Piloto;

public interface IServicioPuntos {

    public int getPuntosCarrera(String id_Carrera, String id_Piloto);

    public int getPuntosTemporada(int ano, String in_Piloto);

    public int getPuntosEscuderiaCarrera(String id_Carrera, String id_escuderia);

    public int getPuntosEscuderiaTemporada(int ano, String id_escuderia);

    public Map<Integer,Piloto> getClasificacionPiloto(int ano);

    public Map<Integer, Escuderia> getClasificacionEscuderia(int ano);
    
}
