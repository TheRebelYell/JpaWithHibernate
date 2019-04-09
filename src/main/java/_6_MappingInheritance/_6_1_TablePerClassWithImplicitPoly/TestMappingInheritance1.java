package _6_MappingInheritance._6_1_TablePerClassWithImplicitPoly;

import _6_MappingInheritance._6_1_TablePerClassWithImplicitPoly.model.BankAccount;
import _6_MappingInheritance._6_1_TablePerClassWithImplicitPoly.model.CreditCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestMappingInheritance1 {
    private static SessionFactory createSessionFactory() {
        return new MetadataSources(
                new StandardServiceRegistryBuilder()
                        .configure("_6_MappingInheritance/hibernate.cfg.xml").build()
        ).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = createSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CreditCard cc = new CreditCard();
        cc.setOwner("First owner");
        cc.setCardNumber("1234-56789-0000");
        cc.setExpMonth("33000");
        cc.setExpYear("400000");

        BankAccount ba = new BankAccount();
        ba.setOwner("First owner");
        ba.setAccount("3094-2938-3489-2345");
        ba.setBankname("Federal Bank");

        session.save(cc);
        session.save(ba);

        session.getTransaction().commit();
        session.close();
    }
}
