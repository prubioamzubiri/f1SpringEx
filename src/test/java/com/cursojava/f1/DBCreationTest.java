package com.cursojava.f1;

import com.cursojava.f1.persistencia.GestorDB;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DBCreationTest {

    @Test
	void insertData() {

        GestorDB gdb = new GestorDB();

        if(gdb.getGestorPilotos().getElements().size()==0)
        {
            gdb.insertData();
        }

	}


    
}
