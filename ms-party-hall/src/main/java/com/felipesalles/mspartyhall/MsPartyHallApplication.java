package com.felipesalles.mspartyhall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsPartyHallApplication {

	//INSERT INTO tb_party_hall (NAME, CAPACITY, VALUE_PER_GUEST) VALUES ("Itamaraty Hall", 230, 100.0);

	public static void main(String[] args) {
		SpringApplication.run(MsPartyHallApplication.class, args);
	}

}
