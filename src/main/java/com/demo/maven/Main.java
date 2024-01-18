package com.demo.maven;

import com.demo.maven.dominio.Pessoa;

public class Main {
    public static void main(String[] args) {
        
        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(exemplo.jpa); //persistence unit no persistence.xml
        EntityManager em = emf.createEntityManager(); //cria conexão com db e contexto de persistecia 

        em.getTransaction.begin(); //precisa iniciar a transação, menos na busca

        em.persist(p1); //salva o obj no db
        em.persist(p2);
        em.persist(p3);

        em.getTransaction.commit(); //confirma as transações
        System.out.println("Pronto!");

        Pessoa p = em.find(Pessoa.class, 2); //busca obj pelo id, classe/id
        System.out.println(p);
        
        em.getTransaction.begin();
        em.remove(p); //remove, apenas remove uma entidade monitorada (que acabou de inserir ou buscou no db e não fechou o entitymanager)
        em.getTransaction.commit(); //confirma as transações
        
        em.close();
        emf.close(); //fechar
    }
}