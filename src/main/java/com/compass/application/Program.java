package com.compass.application;

import com.compass.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args) {

        Person p1 = new Person(null, "Carlos da Silva", "carlos@gmail.com");
        Person p2 = new Person(null, "Joaquim Torres", "joaquim@gmail.com");
        Person p3 = new Person(null, "Ana Maria", "ana@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin(); // Inicio da transação
        em.persist(p1); // Persistencia no banco de dados
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit(); // Commitando as transações

        Person p = em.find(Person.class, 1); // Recuperação de dados

        System.out.println(p);

        System.out.println("Done!");

        em.close(); // Fechando EntityManager
        emf.close(); // Fechando EntityManagerFactory

    }
}
