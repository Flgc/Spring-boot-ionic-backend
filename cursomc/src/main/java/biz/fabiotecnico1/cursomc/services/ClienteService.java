package biz.fabiotecnico1.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.fabiotecnico1.cursomc.domain.Cliente;
import biz.fabiotecnico1.cursomc.repositories.ClienteRepository;
import biz.fabiotecnico1.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired						//Dependência será instânciada automaticamente (injeção de dependencia ou inversão de controlhe)
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {				// Recebe Id como parâmetro
		
		Optional<Cliente> obj = repo.findById(id);	// Procura pelo Id e guarda o resultado no obj
		
		return obj.orElseThrow(()-> new ObjectNotFoundException( //Função "lambda" que não recebe argumento
				"Objeto não encontrado! Id: " + id + ", Tipo: "  //Retornará exceção personalizada caso  obj não exista
				+ Cliente.class.getName()));
	}
}
