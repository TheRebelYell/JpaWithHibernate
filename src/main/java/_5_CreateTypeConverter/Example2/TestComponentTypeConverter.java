package _5_CreateTypeConverter.Example2;

import _5_CreateTypeConverter.Example2.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class TestComponentTypeConverter {
    private static SessionFactory createSessionFactory() {
        return new MetadataSources(
                new StandardServiceRegistryBuilder()
                        .configure("_5_CreateTypeConverter/hibernate.cfg.xml").build()
        ).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = createSessionFactory();
        Session session;

        //****************   INSERT   ****************//
        session = sessionFactory.openSession();
        session.beginTransaction();

        Address address1 = new Address();
        address1.setCity("London");
        address1.setStreet("Some London Street");
        address1.setZipcode(new SwissZipcode("1234"));
        User user = new User();
        user.setName("First User");
        user.setAddress(address1);

        Address address2 = new Address();
        address2.setCity("Manchester");
        address2.setStreet("Some Manchester Street");
        address2.setZipcode(new GermanZipcode("56789"));
        User user2 = new User();
        user2.setName("Second User");
        user2.setAddress(address2);

        session.save(user);
        session.save(user2);

        session.getTransaction().commit();
        session.close();


        //****************   SELECT   ****************//
        session = sessionFactory.openSession();
        session.beginTransaction();

        List<User> users = session.createQuery("from User").list();

        for (User u : users) {
            Address address = u.getAddress();
            Zipcode zipcode = address.getZipcode();

            System.out.printf(
                    "Id: %s, Name: %s\n\tCity: %s, Street: %s\n\t\tZipcode: %s, class: %s\n",
                    u.getId(), u.getName(),
                    address.getCity(), address.getStreet(),
                    zipcode.getValue(), zipcode.getClass().getSimpleName()
            );
        }

        session.getTransaction().commit();
        session.close();
    }
}
