package com.cursojava.f1.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.cursojava.f1.dominio.Escuderia;
import com.cursojava.f1.dominio.Ingeniero;
import com.cursojava.f1.dominio.Piloto;

public class GestorEscuderias implements IGestorDBClase<Escuderia>{

    Session session;

    public GestorEscuderias(Session session)
    {
        this.session = session;
    }
    

    @Override
    public List<Escuderia> getElements() {
        
        return session.createQuery("from Escuderia", Escuderia.class).getResultList();

    }

    @Override
    public Escuderia getElement(String id) {

        Escuderia toReturn = session.get(Escuderia.class, id);

        return toReturn;

    }

    @Override
    public void addElement(Escuderia escuderia) {

        session.beginTransaction();
        session.save(escuderia);
        session.getTransaction().commit(); 
        
    }

    @Override
    public void removeElement(String id) {
        
        Escuderia escuderia = session.get(Escuderia.class, id);
        session.beginTransaction();
        session.remove(escuderia);
        session.getTransaction().commit();
        
    }

    @Override
    public void updateElement(Escuderia escuderia) {

        session.beginTransaction();
        session.update(escuderia);
        session.getTransaction().commit();
        
    }

    @Override
    public void insertData() {
        
        session.beginTransaction();

        //*************** */
        //Alpine
        //*************** */

        List<Piloto> listaPilotosAlpine = new ArrayList<Piloto>();
        List<Ingeniero> listaIngenierosAlpine = new ArrayList<Ingeniero>();

        Piloto p = session.get(Piloto.class, "p_fa");     
        listaPilotosAlpine.add(p);

        p = session.get(Piloto.class, "p_eo");
        listaPilotosAlpine.add(p);

        Ingeniero i = session.get(Ingeniero.class, "i_alp_pf");
        listaIngenierosAlpine.add(i);

        i = session.get(Ingeniero.class, "i_alp_os");
        listaIngenierosAlpine.add(i);

        Escuderia alpine = new Escuderia("e_alp", "Alpine", 0, listaPilotosAlpine, listaIngenierosAlpine, "alpine.jpeg");
        session.save(alpine);

        //*************** */
        //Aston Martin
        //*************** */

        List<Piloto> listaPilotosAston = new ArrayList<Piloto>();
        List<Ingeniero> listaIngenierosAston = new ArrayList<Ingeniero>();

        p = session.get(Piloto.class, "p_sv");     
        listaPilotosAston.add(p);

        p = session.get(Piloto.class, "p_ls");
        listaPilotosAston.add(p);

        i = session.get(Ingeniero.class, "i_am_mk");
        listaIngenierosAston.add(i);

        i = session.get(Ingeniero.class, "i_am_tm");
        listaIngenierosAston.add(i);

        Escuderia aston = new Escuderia("e_ast", "Aston Martin", 0, listaPilotosAston, listaIngenierosAston, "astonMartin.png");
        session.save(aston);


        session.getTransaction().commit();



        
    }


    
}
