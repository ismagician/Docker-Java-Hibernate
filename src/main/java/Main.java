import entity.MissionComanders;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();



        try {
            transaction.begin();

            Collection mcs = entityManager.createQuery("SELECT e FROM MissionComanders e").getResultList();
            for (Iterator i = mcs.iterator(); i.hasNext();) {
                MissionComanders e = (MissionComanders) i.next();
                System.out.println("MC " + e.getIdMc() + ", " + e.getNameMc());
            }


            transaction.commit();
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
