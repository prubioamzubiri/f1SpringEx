package com.cursojava.f1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class f1FileTest {

	@Test
	void fileLoads() {

        File f = new File("fotos/pilotos/alexander-albon-2022.png");

        assertEquals(f.exists(), true);

        File f2 = new File("fotos/pilotos/alexander-albon-2022.png2");

        assertEquals(f2.exists(), false);
	}



}