package org.example;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejemploPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Av. Siempre Viva 742");
        domicilio.setCiudad("Springfield");

        Persona persona = new Persona();
        persona.setNombre("Homero Simpson");
        persona.setDomicilio(domicilio);

        em.persist(persona);

        tx.commit();

        Persona encontrada = em.find(Persona.class, persona.getId());
        System.out.println("Persona: " + encontrada.getNombre());
        System.out.println("Domicilio: " + encontrada.getDomicilio().getCalle() + ", " +
                encontrada.getDomicilio().getCiudad());

        em.close();
        emf.close();
    }
}
