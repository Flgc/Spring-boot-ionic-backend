package biz.fabiotecnico1.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import biz.fabiotecnico1.cursomc .domain.Categoria;

@RestController						
@RequestMapping(value="/categorias")			//Name do end-point rest
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {				//Método para retornar uma lista de categoria
		
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
	}
}