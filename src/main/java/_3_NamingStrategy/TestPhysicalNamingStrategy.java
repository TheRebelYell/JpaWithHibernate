package _3_NamingStrategy;

import _3_NamingStrategy.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestPhysicalNamingStrategy {

    private static SessionFactory createSessionFactory() {
        return new MetadataSources(
                new StandardServiceRegistryBuilder()
                    .configure("_3_NamingStrategy/hibernate.cfg.xml").build()
        ).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = createSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        User user = new User();
        user.setName("Han Solo");

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
}
