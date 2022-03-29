package com.cursojava.f1.persistencia;

import java.util.List;

import org.hibernate.Session;

import com.cursojava.f1.dominio.Circuito;

public class GestorCircuito implements IGestorDBClase<Circuito>{

    Session session;

    public GestorCircuito(Session session)
    {
        this.session = session;
    }
    

    @Override
    public List<Circuito> getElements() {
        
        return session.createQuery("from Circuito", Circuito.class).getResultList();

    }

    @Override
    public Circuito getElement(String id) {
        
        Circuito toReturn = session.get(Circuito.class, id);

        return toReturn;
    }

    @Override
    public void addElement(Circuito element) {
        
        session.beginTransaction();
        session.save(element);
        session.getTransaction().commit(); 
        
    }

    @Override
    public void removeElement(String id) {
        
        Circuito circuito = session.get(Circuito.class, id);
        session.beginTransaction();
        session.remove(circuito);
        session.getTransaction().commit();
        
    }

    @Override
    public void updateElement(Circuito element) {
       
        session.beginTransaction();
        session.update(element);
        session.getTransaction().commit();
        
    }

    @Override
    public void insertData() {
        
        session.beginTransaction();

        Circuito c = new Circuito("c_bar", "Barhein", "Circuito Internacional de Barhein", 5412);
        session.save(c);
        c = new Circuito("c_ara", "Arabia Saudi", "Circuito de la Corniche de Yeda", 6175);
        session.save(c);
        c= new Circuito("c_aus", "Australia", "Circuito Albert Park", 5303);
        session.save(c);

        session.getTransaction().commit();
        
    }
    
}
