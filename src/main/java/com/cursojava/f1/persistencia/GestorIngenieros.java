package com.cursojava.f1.persistencia;

import java.util.List;

import org.hibernate.Session;

import com.cursojava.f1.dominio.Ingeniero;

public class GestorIngenieros implements IGestorDBClase<Ingeniero>{

    Session session;

    public GestorIngenieros(Session session)
    {
        this.session = session;
    }

    @Override
    public List<Ingeniero> getElements() {
    
        return session.createQuery("from Ingeniero", Ingeniero.class).getResultList(); 

    }

    @Override
    public Ingeniero getElement(String id) {
 
        Ingeniero toReturn = session.get(Ingeniero.class, id);

        return toReturn;

    }

    @Override
    public void addElement(Ingeniero ingeniero) {
        
        session.beginTransaction();
        session.save(ingeniero);
        session.getTransaction().commit();        
        
    }

    @Override
    public void removeElement(String id) {
        
        Ingeniero ingeniero = session.get(Ingeniero.class, id);
        session.beginTransaction();
        session.remove(ingeniero);
        session.getTransaction().commit();
        
    }

    @Override
    public void updateElement(Ingeniero ingeniero) {
        
        session.beginTransaction();
        session.update(ingeniero);
        session.getTransaction().commit();
        
    }

    @Override
    public void insertData() {
       
        session.beginTransaction();
        Ingeniero i = new Ingeniero("i_alp_pf", "Pat Fry", 1964);
        session.save(i);
        i = new Ingeniero("i_alp_os", "Otmar Szafnauer", 1964);
        session.save(i);
        i = new Ingeniero("i_am_mk", "Mike Krack", 1972);
        session.save(i);
        i = new Ingeniero("i_am_tm", "Tom McCullough", 1975);
        session.save(i);
        session.getTransaction().commit();
        
    }


    
}

