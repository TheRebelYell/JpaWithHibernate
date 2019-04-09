package _2_ValidationConstraints;

import _2_ValidationConstraints.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class TestHibernateValidator {

    private static SessionFactory createSessionFactory() {
        return new MetadataSources(
                new StandardServiceRegistryBuilder()
                        .configure("_2_ValidationConstraints/hibernate.cfg.xml").build()
        ).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = createSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Item item = new Item();
        item.setName("Some name");
        Date futureDate = new Date(new Date().getTime() + 10_000_000_000l);
        item.setAuctionEnd(futureDate);

        session.save(item);

        session.getTransaction().commit();
        session.close();
    }
}
