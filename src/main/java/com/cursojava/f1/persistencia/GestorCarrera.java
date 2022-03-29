package com.cursojava.f1.persistencia;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;

import com.cursojava.f1.dominio.Carrera;
import com.cursojava.f1.dominio.Circuito;
import com.cursojava.f1.dominio.Piloto;

public class GestorCarrera implements IGestorDBClase<Carrera>{

    Session session;

    public GestorCarrera(Session session)
    {
        this.session = session;
    }

    @Override
    public List<Carrera> getElements() {
       
        return session.createQuery("from Escuderia", Carrera.class).getResultList();
    }

    @Override
    public Carrera getElement(String id) {
        
        Carrera toReturn = session.get(Carrera.class, id);

        return toReturn;
    }

    @Override
    public void addElement(Carrera element) {
        
        session.beginTransaction();
        session.save(element);
        session.getTransaction().commit(); 
        
    }

    @Override
    public void removeElement(String id) {
        
        Carrera circuito = session.get(Carrera.class, id);
        session.beginTransaction();
        session.remove(circuito);
        session.getTransaction().commit();
        
    }

    @Override
    public void updateElement(Carrera element) {
       
        session.beginTransaction();
        session.update(element);
        session.getTransaction().commit();
        
    }

    @Override
    public void insertData() {
        
        session.beginTransaction();

        //********* */
        // Pilotos
        //********* */
        Piloto  fa = session.get(Piloto.class, "p_fa"),
                eo = session.get(Piloto.class, "p_eo"),
                sv = session.get(Piloto.class, "p_sv"),
                ls = session.get(Piloto.class, "p_ls");

        //******* */ 
        //Barhein
        //******* */

        Circuito c = session.get(Circuito.class, "c_bar");

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, Calendar.MARCH);
        cal.set(Calendar.DAY_OF_MONTH, 20);
        Date date = cal.getTime();

        HashMap<Integer, Piloto> pil_pos= new HashMap<Integer, Piloto>();
        pil_pos.put(1, fa);
        pil_pos.put(2,sv);
        pil_pos.put(3,eo);
        pil_pos.put(4,ls);

        Carrera car = new Carrera("car_bar_2022", "Gran Premio de Baréin", c, date, pil_pos);

        session.save(car);


        session.getTransaction().commit();
        
    }
    
}
