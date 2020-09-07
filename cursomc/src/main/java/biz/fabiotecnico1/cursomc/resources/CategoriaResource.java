package biz.fabiotecnico1.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import biz.fabiotecnico1.cursomc.domain.Categoria;
import biz.fabiotecnico1.cursomc.services.CategoriaService;

@RestController						
@RequestMapping(value="/categorias")			//Name do end point rest
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;			// Controlador Rest para acessar o serviço
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)  //Acrescentamos value = "/{id}" para forçar o Id para procura
	
	public ResponseEntity<?> find(@PathVariable Integer id) {		//Método para retornar uma categoria informado no Id - end point
		
		Categoria obj = service.find(id);							//Busca no serviço a categoria referente ao Id informado
		
		return ResponseEntity.ok().body(obj);		//Retorna a resposta HTTP como corpo o objeto obj
	}
}