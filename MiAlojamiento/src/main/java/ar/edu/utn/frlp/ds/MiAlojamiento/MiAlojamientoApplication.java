package ar.edu.utn.frlp.ds.MiAlojamiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MiAlojamientoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiAlojamientoApplication.class, args);
		//Prueba de si funciona la consola de spring
		System.out.println("Funciona");
	}

}
