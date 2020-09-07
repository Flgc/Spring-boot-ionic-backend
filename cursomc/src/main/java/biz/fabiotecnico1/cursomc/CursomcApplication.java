package biz.fabiotecnico1.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import biz.fabiotecnico1.cursomc.domain.Categoria;
import biz.fabiotecnico1.cursomc.domain.Cidade;
import biz.fabiotecnico1.cursomc.domain.Estado;
import biz.fabiotecnico1.cursomc.domain.Produto;
import biz.fabiotecnico1.cursomc.repositories.CategoriaRepository;
import biz.fabiotecnico1.cursomc.repositories.CidadeRepository;
import biz.fabiotecnico1.cursomc.repositories.EstadoRepository;
import biz.fabiotecnico1.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{	//CommandLineRunner -> Permite executar uma ação ao inicar a aplicação

	@Autowired
	private CategoriaRepository categoriaRepository;		//Injeção de dependência do repositório de categorias
	
	@Autowired
	private ProdutoRepository produtoRepository; 			//Injeção de dependência do repositório de produtos
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepositoryd;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { // Auto-generated method stub - assinatura do CommandLineRunner
		
		
		//Hard code Sample - inserted in database
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));	//Operação para salvar um ou uma lista de objeto - categoria
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3)); 	//Operação para salvar um ou uma lista de objeto - produto
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoRepositoryd.saveAll(Arrays.asList(est1, est2));		//Operação para salvar um ou uma lista de objeto - estado
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));	//Operação para salvar um ou uma lista de objeto - cidade
			
	}
}
