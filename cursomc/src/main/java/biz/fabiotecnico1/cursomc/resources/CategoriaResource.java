package biz.fabiotecnico1.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController						
@RequestMapping(value="/categorias")			//Name do end-point rest
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public static String listar() {
		return "REST está funcionando";
	}
}