package ru.univeralex.web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.univeralex.web.model.Office;

import java.util.List;
import java.util.Optional;

/**
 * @author - Alexander Kostarev
 */
public class OfficeDaoHibernateImpl implements OfficeDao {
    private static SessionFactory factory;

    public OfficeDaoHibernateImpl() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public Optional<Office> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Office model) {

    }

    @Override
    public void update(Office model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Office> findAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Office> offices = null;
        try {
            tx = session.beginTransaction();
            offices = session.createQuery("FROM Office").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return offices;
    }
}
