# introducao-Jpa-Hibernate
## OBS - Na pasta (src/resource) veja as configurações do META-INF e em pom.xml

# Pré Requisito para entender 
- Lógica de Programação
- POO básico
- Banco de dados

# Sobre o JPA
## É um mapeamento Objeto-Relacional e persistência de dados que facilita a comunicação de forma simples com o Banco de dados

# Ferramentas utilizadas
- XAMPP
- Feito na IDE Eclipe (OBS- Utilizo mais o STS para web e NetBeans para Desktop)

  ## Demonstração

```javascript

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    private String nome;
    private String email;

    public Pessoa(){};

    public Pessoa(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

```
## Classe Principal

```

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
```
