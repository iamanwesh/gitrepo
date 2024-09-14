package com.app.anwesh.test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.anwesh.entity.Carshowroom;
import com.app.anwesh.repo.CarRepo;

@Component
public class Test implements CommandLineRunner{
	@Autowired
	private CarRepo car;

	public void run(String... args) throws Exception {
		Carshowroom c1=new Carshowroom("XZ","TataCurve",100000d);
		car.save(c1);
		car.saveAll(Arrays.asList(
				new Carshowroom("XZ","TataCurve",123234d),
				new Carshowroom("Xa","Tatasumo",100034d),
				new Carshowroom("eZ","Tatanexon",100050d)
				));
		
	}

}
