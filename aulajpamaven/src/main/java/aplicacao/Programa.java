package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		/*
		 * Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		 * Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com"); 
		 * Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		 */		
		
		//Instancia as propriedades passadas no persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		//Instancia em com o emf realizando a conexao com o banco de dados
		EntityManager em = emf.createEntityManager();
		
		//persist - método que salva no banco de dados
		/*
		 * em.getTransaction().begin(); //inicia a transação com o banco de dados
		 * em.persist(p1); em.persist(p2);
		 * em.persist(p3); 
		 * em.getTransaction().commit();  //confirma as alterações
		 */		
		
		//Função que busca pelo ID
		
		Pessoa p = em.find(Pessoa.class, 4);
		
		System.out.println(p);
		
		
		//Realizando remoção no banco de dados após monitorar os dados com o Find
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Terminado!");
		
		em.close();
		emf.close();
	}

}
