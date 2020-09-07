package biz.fabiotecnico1.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import biz.fabiotecnico1.cursomc.domain.Categoria;
import biz.fabiotecnico1.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{	//CommandLineRunner -> Permite executar uma ação ao inicar a aplicação

	@Autowired
	private CategoriaRepository categoriaRepository;		//Injeção de dependência
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { // Auto-generated method stub - assinatura do CommandLineRunner
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));	//Operação para salvar um ou uma lista de objeto
			
	}
}
