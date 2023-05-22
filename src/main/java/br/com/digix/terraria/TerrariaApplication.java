package br.com.digix.terraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TerrariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerrariaApplication.class, args);
	}

}
