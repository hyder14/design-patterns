package com.hyders.persistence.jpa;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;

public class AbstractJpaDAO<T extends Serializable> {

    @Autowired
    private static SessionFactory sessionFactory = getSessionFactory();

    private Session currentSession;
    private Transaction currentTransaction;

    private Class<T> clazz;

    public void setClazz(final Class<T> clazzToSet) {
        this.clazz= clazzToSet;
    }

    @SuppressWarnings("unchecked")
    public T findOne(final long id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    public Session openSessionWithTransaction() {
        currentSession = sessionFactory.openSession();
        currentSession = sessionFactory.getCurrentSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }


    public void closeSessionWithTransaction() {
        currentTransaction.commit();
        //currentSession.close();
    }

    public Session openSession() {
        currentSession = sessionFactory.openSession();
        return currentSession;
    }

    public void closeSession() {
        currentSession.close();
    }

    private Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session session) {
        this.currentSession = session;
    }

    private Transaction getCurrentTransaction() {
         return currentTransaction;
    }

    private void setCurrentTransaction(Transaction transaction) {
        this.currentTransaction=transaction;
    }

    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    public T create (final T entity) {
        getCurrentSession().persist(entity);
        return entity;
    }

    public T update(final T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
}
