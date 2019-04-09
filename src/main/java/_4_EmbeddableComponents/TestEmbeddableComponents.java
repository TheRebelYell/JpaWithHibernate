package _4_EmbeddableComponents;

import _4_EmbeddableComponents.model.Address;
import _4_EmbeddableComponents.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestEmbeddableComponents {
    private static SessionFactory createSessionFactory() {
        return new MetadataSources(
                new StandardServiceRegistryBuilder()
                        .configure("_4_EmbeddableComponents/hibernate.cfg.xml").build()
        ).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = createSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Address homeAddress = new Address();
        homeAddress.setCity("London");
        homeAddress.setStreet("Home street");
        homeAddress.setZipcode("123");
        Address workAddress = new Address();
        workAddress.setCity("Manchester");
        workAddress.setStreet("Work Street");
        workAddress.setZipcode("456");

        User user = new User();
        user.setUsername("First User");
        user.setHomeAddress(homeAddress);
        user.setWorkAddress(workAddress);

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
}
