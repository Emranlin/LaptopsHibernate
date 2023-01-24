package peaksoft.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DataBaseConnection;
import peaksoft.enums.OperationSystem;
import peaksoft.models.Laptop;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LaptopDaoImpl implements LaptopDao{
    private final EntityManagerFactory entityManagerFactory= DataBaseConnection.createEMF();
    @Override
    public Laptop saveLaptop(Laptop laptop) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(laptop);
        entityManager.getTransaction().commit();
        entityManager.close();

        return laptop;
    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Laptop laptop : laptops) {
            entityManager.persist(laptop);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    @Override
    public Laptop deleteById(Long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop id1 = entityManager.createQuery("select l from Laptop l where id =:id", Laptop.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.remove(id1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public void deleteAll() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Laptop ",Laptop.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();



    }

    @Override
    public List<Laptop> findAll() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Laptop>laptops=new ArrayList<>();
        laptops.addAll(entityManager.createQuery("select l from Laptop l",Laptop.class)
                .getResultList());
        return laptops;
    }

    @Override
    public Laptop update(Long id, Laptop laptop) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop laptop1=entityManager.getReference(Laptop.class,id);
        laptop1.setOperationsystem(laptop.getOperationsystem());
        laptop1.setMemory(laptop.getMemory());
        laptop1.setPrice(laptop.getPrice());
        laptop1.setDateOfIssue(laptop.getDateOfIssue());
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptop1;
    }


    public Map<OperationSystem, List<Laptop>> groupBy() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
        Map<OperationSystem, List<Laptop>> collect = entityManager.createQuery("select l from Laptop  l", Laptop.class).getResultStream()
                .collect(Collectors.groupingBy(Laptop::getOperationsystem));
        entityManager.getTransaction().commit();
        entityManager.close();
        return collect;
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {

        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery("select l from Laptop l order by :newColumn",Laptop.class).getResultStream();
        entityManager.createQuery("select l  from Laptop  l order by newColumn :newAsc",Laptop.class).getResultStream();
        entityManager.createQuery("select l from Laptop l order by memory",Laptop.class).getResultStream();


        return null;
    }

}
