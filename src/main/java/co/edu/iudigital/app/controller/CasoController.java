package co.edu.iudigital.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.app.dto.CasoDto;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.model.Caso;
import co.edu.iudigital.app.service.iface.ICasoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/casos")
@Api(value="/casos", tags= {"Casos"})
@SwaggerDefinition(tags = {
		@Tag(name = "Casos", description = "Gestion API casos")
})
public class CasoController {

	@Autowired
	private ICasoService casoService;
	
	
	@ApiOperation(value = "Obtiene todos los casos",
			produces = "application/json",
			httpMethod = "GET")
	@GetMapping
	public ResponseEntity<List<CasoDto>> index() throws RestException {
		List<CasoDto> casoDto = casoService.findAll();
		return ResponseEntity.ok().body(casoDto);
	}
	
	@ApiOperation(value = "Crea un caso",
			produces = "application/json",
			httpMethod = "POST")
	@PostMapping
	public ResponseEntity<Caso> create(@RequestBody final Caso caso) throws RestException{
		 Caso casoSaved = casoService.save(caso);
		 return ResponseEntity.status(HttpStatus.CREATED).body(casoSaved);
	}
}