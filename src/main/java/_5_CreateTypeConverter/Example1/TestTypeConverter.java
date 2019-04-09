package _5_CreateTypeConverter.Example1;

import _5_CreateTypeConverter.Example1.model.Item;
import _5_CreateTypeConverter.Example1.model.MonetaryAmount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public class TestTypeConverter {
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

        MonetaryAmount monetaryAmount = new MonetaryAmount(
                new BigDecimal(64.5), Currency.getInstance("EUR"));
        Item item = new Item();
        item.setName("Wood table");
        item.setBuyNowPrice(monetaryAmount);

        session.save(item);

        session.getTransaction().commit();
        session.close();


        //****************   SELECT   ****************//
        session = sessionFactory.openSession();
        session.beginTransaction();

        List<Item> items = session.createQuery("from Item").list();
        items.stream().forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
    }
}
