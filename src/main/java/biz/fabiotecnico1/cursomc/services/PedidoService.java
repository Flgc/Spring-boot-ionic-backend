package biz.fabiotecnico1.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.fabiotecnico1.cursomc.domain.Pedido;
import biz.fabiotecnico1.cursomc.repositories.PedidoRepository;
import biz.fabiotecnico1.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired						
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {				
		
		Optional<Pedido> obj = repo.findById(id);	
		
		return obj.orElseThrow(()-> new ObjectNotFoundException( 
				"Objeto não encontrado! Id: " + id + ", Tipo: "  
				+ Pedido.class.getName()));
	}
}
