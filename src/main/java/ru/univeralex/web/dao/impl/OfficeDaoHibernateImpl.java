package ru.univeralex.web.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.univeralex.web.dao.api.OfficeDao;
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
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Office model) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(session.load(Office.class, id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Office> findAll() {
        Session session = factory.openSession();
        session.beginTransaction();
        List<Office> offices = session.createQuery("FROM Office").list();
        session.close();
        return offices;
    }
}
