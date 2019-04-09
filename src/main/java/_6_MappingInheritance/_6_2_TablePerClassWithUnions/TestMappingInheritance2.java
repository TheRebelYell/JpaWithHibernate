package _6_MappingInheritance._6_2_TablePerClassWithUnions;

import _6_MappingInheritance._6_2_TablePerClassWithUnions.model.BankAccount;
import _6_MappingInheritance._6_2_TablePerClassWithUnions.model.BillingDetails;
import _6_MappingInheritance._6_2_TablePerClassWithUnions.model.CreditCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class TestMappingInheritance2 {
    private static SessionFactory createSessionFactory() {
        return new MetadataSources(
                new StandardServiceRegistryBuilder()
                        .configure("_6_MappingInheritance/hibernate.cfg.xml").build()
        ).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = createSessionFactory();
        Session session;

        //****************   INSERT   ****************//
        session = sessionFactory.openSession();
        session.beginTransaction();

        BillingDetails bd = new BillingDetails();
        bd.setOwner("Test owner");

        CreditCard cc = new CreditCard();
        cc.setOwner("Second owner");
        cc.setCardNumber("5678-13466-4574");
        cc.setExpMonth("8000");
        cc.setExpYear("100000");

        BankAccount ba = new BankAccount();
        ba.setOwner("Second owner");
        ba.setAccount("3453-3408-2345-9834");
        ba.setBankname("Federal Bank");

        session.save(bd);
        session.save(cc);
        session.save(ba);

        session.getTransaction().commit();
        session.close();


        //****************   SELECT   ****************//
        session = sessionFactory.openSession();
        session.beginTransaction();

        List<BillingDetails> billingDetailsList =
                session.createQuery("from BillingDetails_2").list();

        billingDetailsList.stream().forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
    }
}
