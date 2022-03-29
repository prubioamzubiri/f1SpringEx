package com.cursojava.f1.persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cursojava.f1.dominio.Carrera;
import com.cursojava.f1.dominio.Circuito;
import com.cursojava.f1.dominio.Escuderia;
import com.cursojava.f1.dominio.Ingeniero;
import com.cursojava.f1.dominio.Piloto;
import com.cursojava.f1.dominio.Temporada;

import lombok.Data;

@Data
public class GestorDB {

    private IGestorDBClase<Piloto> gestorPilotos;
    private IGestorDBClase<Ingeniero> gestorIngeniero;
    private IGestorDBClase<Escuderia> gestorEscuderia;
    private IGestorDBClase<Circuito> gestorCircuito;
    private IGestorDBClase<Carrera> gestorCarrera;
    private IGestorDBClase<Temporada> gestorTemporada;
    private Session session;
    
    public GestorDB()
    {
       
        Configuration cfg = this.connection();

        cfg.configure().addAnnotatedClass(Piloto.class)
                    .addAnnotatedClass(Ingeniero.class)
                    .addAnnotatedClass(Escuderia.class)
                    .addAnnotatedClass(Circuito.class)
                    .addAnnotatedClass(Carrera.class)
                    .addAnnotatedClass(Temporada.class);

        SessionFactory factory = cfg.buildSessionFactory();

        this.session = factory.openSession();

        gestorPilotos = new GestorPìlotos(session);
        gestorIngeniero = new GestorIngenieros(session);
        gestorEscuderia = new GestorEscuderias(session);
        gestorCircuito = new GestorCircuito(session);
        gestorCarrera = new GestorCarrera(session);
        gestorTemporada = new GestorTemporadas(session);


    }


    private Configuration connection()
    {
        Configuration cfg = new Configuration();

        String connectionURL;
    

          connectionURL = "jdbc:mysql://127.0.0.1:3306/f1";
          cfg.setProperty("hibernate.connection.url", connectionURL);
    
         
          cfg.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
          cfg.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
    
          cfg.setProperty("hibernate.connection.username", "root");
    
          cfg.setProperty("hibernate.connection.password", "root");

          return cfg;

        
    }

    public void close()
    {
        this.session.close();
    }

    public void insertData()
    {
        this.gestorPilotos.insertData();        
        this.gestorIngeniero.insertData();
        this.gestorEscuderia.insertData();
        this.gestorCircuito.insertData();
        this.gestorCarrera.insertData();
        this.gestorTemporada.insertData();
    }
}
