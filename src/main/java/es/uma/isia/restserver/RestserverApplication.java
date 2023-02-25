package es.uma.isia.restserver;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Ejemplo de API rest", version = "2.0", description = "Utilidades sobre dni/nif/nie/cif"))
public class RestserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestserverApplication.class, args);
    }

}
