package biz.fabiotecnico1.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.fabiotecnico1.cursomc.domain.Categoria;
import biz.fabiotecnico1.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired						//Dependência será instânciada automaticamente (injeção de dependencia ou inversão de controlhe)
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {					//Procura pelo Id
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);						// Retornará o obj caso encontrado ou null para evitar exceção 
	}
}
