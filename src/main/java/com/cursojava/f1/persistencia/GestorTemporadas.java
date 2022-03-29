package com.cursojava.f1.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.cursojava.f1.dominio.Carrera;
import com.cursojava.f1.dominio.Escuderia;
import com.cursojava.f1.dominio.Temporada;

public class GestorTemporadas implements IGestorDBClase<Temporada>{

    Session session;

    public GestorTemporadas(Session session)
    {
        this.session = session;
    }
    @Override
    public List<Temporada> getElements() {
        
        return session.createQuery("from Escuderia", Temporada.class).getResultList();
    }

    @Override
    public Temporada getElement(String id) {

        Temporada toReturn = session.get(Temporada.class, id);

        return toReturn;
    }

    @Override
    public void addElement(Temporada element) {
        
        session.beginTransaction();
        session.save(element);
        session.getTransaction().commit(); 
        
    }

    @Override
    public void removeElement(String id) {
        
        Temporada circuito = session.get(Temporada.class, id);
        session.beginTransaction();
        session.remove(circuito);
        session.getTransaction().commit();
        
    }

    @Override
    public void updateElement(Temporada element) {
        
        session.beginTransaction();
        session.update(element);
        session.getTransaction().commit();
        
    }

    @Override
    public void insertData() {
        
        session.beginTransaction();

        /**
         * Escuderia
         */

        Escuderia  alp = session.get(Escuderia.class, "e_alp"),
                   ast = session.get(Escuderia.class, "e_ast");

        List<Escuderia> escuderias = new ArrayList<Escuderia>();
        escuderias.add(alp);
        escuderias.add(ast);

        /**
        * Carrera
        */

        Carrera bar = session.get(Carrera.class, "car_bar_2022");

        List<Carrera> carreras = new ArrayList<Carrera>();
        carreras.add(bar);


        /**
        *  2022
        */

        Temporada temp_2022 = new Temporada(2022, escuderias, carreras);

        session.save(temp_2022);
                    

        session.getTransaction().commit();
        
    }
    
}
