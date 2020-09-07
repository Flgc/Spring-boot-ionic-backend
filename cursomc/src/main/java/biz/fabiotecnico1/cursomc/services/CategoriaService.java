package biz.fabiotecnico1.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.fabiotecnico1.cursomc.domain.Categoria;
import biz.fabiotecnico1.cursomc.repositories.CategoriaRepository;
import biz.fabiotecnico1.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired						//Dependência será instânciada automaticamente (injeção de dependencia ou inversão de controlhe)
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {					// Recebe Id como parâmetro
		
		Optional<Categoria> obj = repo.findById(id);	// Procura pelo Id e guarda o resultado no obj
		
		return obj.orElseThrow(()-> new ObjectNotFoundException( //Função "lambda" que não recebe argumento
				"Objeto não encontrado! Id: " + id + ", Tipo: "  //Retornará exceção personalizada caso  obj não exista
				+ Categoria.class.getName()));
	}
}
