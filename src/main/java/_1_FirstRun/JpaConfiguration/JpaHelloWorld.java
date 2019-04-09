package _1_FirstRun.JpaConfiguration;

import _1_FirstRun.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaHelloWorld {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("HelloWorldPU");
        EntityTransaction tx;

        //****************   INSERT   ****************//
        EntityManager em = emf.createEntityManager();

        tx = em.getTransaction();
        tx.begin();

        Message message = new Message();
        message.setText("Hello World!");

        em.persist(message);

        // INSERT INTO message (id, text) VALUES (1, 'Hello World!');
        tx.commit();
        em.close();

        //****************   SELECT / UPDATE  ****************//
        em = emf.createEntityManager();

        tx = em.getTransaction();
        tx.begin();

        // SELECT * FROM message;
        List<Message> messages =
                em.createQuery("select m from Message m").getResultList();

        System.out.println(messages.get(0).getText());

        /*
            You can change the value of a property,
            Hibernate will detect this automatically because the loaded Message
            is still attached to the persistence context it was loaded in.
        */
        messages.get(0).setText("Take me to your leader!");

        /*
            On commit, Hibernate checks the persistence context for dirty state
            and executes the SQL UPDATE automatically to synchronize the in-memory
            with the database state.
         */
        // UPDATE message SET text = 'Take me to your leader!' WHERE id = 1;
        tx.commit();
        em.close();
    }
}