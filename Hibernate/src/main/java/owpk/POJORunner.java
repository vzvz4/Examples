package owpk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class POJORunner {
    private static SessionFactory sessionFactory;
    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        POJORunner pojoRunner = new POJORunner();
        //pojoRunner.updatePOJO(11);
        //pojoRunner.addPOJO("Viktor", 2, "Viktor@mail.ru");
        List<POJOClass> list = pojoRunner.listOfPOJOs();
        list.forEach(System.out::println);
    }

    public void addPOJO(String login, String pass, String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        POJOClass pojo = new POJOClass(login, pass, email);
        session.save(pojo);
        transaction.commit();
        session.close();
    }

    public List<POJOClass> listOfPOJOs() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        List<POJOClass> pojos = session.createQuery("FROM POJOClass").list();
        transaction.commit();
        session.close();
        return pojos;
    }

    public void updatePOJO(int pojoId) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = null;
//        transaction = session.beginTransaction();
//
//        POJOClass pojo = session.get(POJOClass.class, pojoId);
//        pojo.setEmail(pojo.getLogin()+"@email.ru");
//        session.update(pojo);
//        transaction.commit();
//        session.close();
    }

    public void removePOJO(int pojoId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        POJOClass pojo = session.get(POJOClass.class, pojoId);
        session.delete(pojo);
        transaction.commit();
        session.close();
    }

}
