package co.edu.iudigital.app.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



/**
 * 
 * Configuración de Swagger
 * @author Diana
 *
 */

//@Configuration // produce error

@EnableSwagger2 // produce error con Configuration
 
public class SwaggerConfig {

	@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("co.edu.iudigital.app.controller"))
                .paths(PathSelectors.any())
                
                .build()
                .apiInfo(apiInfo())
                ;
    }
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"API de HelpMeUID", 
				"API para la App de HelpMeUID", 
				"1.0", 
				"https://iudigital.edu.co", 
				new Contact(
						"Diana Jaramillo", 
						"https://iudigital.edu.co", 
						"diana.jaramillo@iudigital.edu.co"), 
				"Apache 2.0", 
				"https://www.apache.org/licenses/LICENSE-2.0.html",
				Collections.emptyList()
			);
	}
}
