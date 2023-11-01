package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//OpenAPI es una especificación para describir y documentar APIs RESTful
@OpenAPIDefinition(
		//cambiar el nombre de proyecto y la version en swagger
		info = @Info(
				title = "Flor",
				version = "1.0.0",
				description = "API Rest CRUD con MySQL/swagger",
                contact = @Contact(
						name = "Natalia Fara",
						email = "programanat851@gmail.com"
				),
				license = @License(
						name = "licence",
						url = "#"
				)
		),// URL de los servidores a los que se puede acceder para realizar solicitudes HTTP
		servers = {
				@Server(url = "http://localhost:9001"),
				@Server(url = "http://localhost:8080")
		},
		//etiquetar la API con el nombre "Sprint 5.1.2" y una descripción que indica que se trata de los principales métodos CRUD con documentación de OpenAPI
		tags = {
				@Tag(name = "Sprint 05.t1.n2",
						//principales métodos CRUD con documentación de OpenAPI
						description = "CRUD methods with Open Api Documentation")
		}
)
public class S05T01N02FaraNataliaApplication{

		public static void main(String[]args) {
			SpringApplication.run(S05T01N02FaraNataliaApplication.class, args);
			System.out.println("                                              " +
					"  - CONNECTED -                  ");

		}

}
