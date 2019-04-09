package _1_FirstRun.HibernateConfiguration;

import _1_FirstRun.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateHelloWorld {

    private static SessionFactory createSessionFactory() {
        return new MetadataSources(
                    new StandardServiceRegistryBuilder()
                        .configure("_1_FirstRun/hibernate.cfg.xml").build()
                ).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = createSessionFactory();
        Session session;

        //****************   INSERT   ****************//
        session = sessionFactory.openSession();
        session.beginTransaction();

        Message message = new Message();
        message.setText("Hello World!");

        session.save(message);

        // INSERT INTO message (id, text) VALUES (1, 'Hello World!');
        session.getTransaction().commit();
        session.close();


        //****************   SELECT   ****************//
        session = sessionFactory.openSession();
        session.beginTransaction();

        // SELECT * FROM message WHERE id = 1;
        Message newMessage = session.get(Message.class, 1L);
        System.out.println(newMessage.getText());

        session.getTransaction().commit();
        session.close();
    }
}