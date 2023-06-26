package domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class application {

	public static void main(String[] args) {
		  /*Pessoa p1=new Pessoa(null,"João","joao@gmail.com");
	        Pessoa p2=new Pessoa(null,"Cintia","cintia@gmail.com");
	        Pessoa p3=new Pessoa(null,"Aladdim","dim@gmail.com");
	       */
	        
	        EntityManagerFactory emf=Persistence.createEntityManagerFactory("exemplo-jpa");
	        EntityManager em=emf.createEntityManager();
	        /*em.getTransaction().begin();		
	        em.persist(p1);
	        em.persist(p2);
	        em.persist(p3);
	        em.getTransaction().commit();
	        */
	        
	        //Após inserir vou recuperar através do ID
	        Pessoa p=em.find(Pessoa.class, 2);
	        System.out.println(p);
	        
	        System.out.println("Tudo ok");	
	        em.clear();
	        emf.close();
	}

}
