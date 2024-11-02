package com.neo.dsapathway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.neo.dsapathway.model")
public class DsApathwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsApathwayApplication.class, args);
	}

}
