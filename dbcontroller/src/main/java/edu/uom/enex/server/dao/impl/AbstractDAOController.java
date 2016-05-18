package edu.uom.enex.server.dao.impl;

import edu.uom.enex.server.dao.DAOController;
import edu.uom.enex.server.entity.EntityInterface;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.collection.internal.AbstractPersistentCollection;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.Type;
import org.hibernate.validator.util.IdentitySet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;



/**
 * Created by Amali on 4/5/16.
 */
@Transactional
public class AbstractDAOController<T extends EntityInterface, I extends Serializable> implements DAOController<T, I> {

    private final Class<T> entityType;
    private final Class<I> idType;

    @Autowired
    private SessionFactory sessionFactory;

    public AbstractDAOController(Class<T> entityType, Class<I> idType) {
        this.entityType = entityType;
        this.idType = idType;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public I create(T entity) {
        getSession().persist(entity);
        return (I) entity.getId();
    }

    @Override
    public I update(T entity) {
        getSession().update(entity);
        return (I) entity.getId();
    }

    @Override
    public int archive(T entity) {
        Session session = getSession();
        session.merge(entity);//Copy the state of the given object onto the persistent object with the same identifier
        session.delete(entity);
        return 0;
    }

    @Override
    public T read(I id) {
        return (T) getSession().get(entityType, id);//Return the persistent instance of the given entity class with the given identifier
    }

    @Override
    public List<T> getAll(int offset, int limit, String order) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.setFirstResult(offset);
        criteria.setMaxResults(limit);
        criteria.addOrder(Order.asc(order));
        //.addOrder---> add order to the result set
        //.asc(Order)---> create a new Ascending order
        return criteria.list();
    }

    @Override
    public List<T> getAllListById(Long id, String propertyName) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq(propertyName, id));
        //add(Criterion)
        //.eq(...)--> Apply an "equal" constraint to the named property---> return SimpleExpression instance(SimpleExpression implements Criterion)
        return criteria.list();
    }

    public List<T> getAllByPropertyByIntegerValue(Integer value, String propertyName) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq(propertyName, value));
        return criteria.list();
    }

    public List<T> getAllByPropertyByStringValue(String value, String propertyName) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq(propertyName, value));
        return criteria.list();
    }

    @Override
    public Long getAllCount() {

        Criteria criteria = getSession().createCriteria(entityType);
        criteria.setProjection(Projections.rowCount());
        //Add a {@link Criterion restriction} to constrain the results to be retrieved.
        //projection.rowCount()--> == count(*)
        return (Long) criteria.uniqueResult();
        //.uniqueResult()--> Convenience method to return a single instance that matches the query
    }

    @Override
    public List<T> getAll() {
        Criteria criteria = getSession().createCriteria(entityType);
        return criteria.list();
    }


    public void detach(Object entity) {

// Check for lazy-loading proxies
        if (entity instanceof HibernateProxy) {// checking whether mentioned entity is in the db
            //HibernateProxy=Marker interface for entity proxies
            SessionImplementor sessionImplementor = ((HibernateProxy) entity)
                    .getHibernateLazyInitializer().getSession();
            // .getHibernateLazyInitializer()-->Get the underlying lazy initialization handler.
            if (sessionImplementor instanceof Session) {
                ((Session) sessionImplementor).evict(entity);
                //.evict(...)---> Remove this instance from the session cache
            }

            return;
        }

        // processing queue
        Queue<Object> entities = new LinkedList<Object>();
        Set<Object> processedEntities = new IdentitySet();

        entities.add(entity);

        while ((entity = entities.poll()) != null) {

            // Skip already processed entities
            if (processedEntities.contains(entity)) {
                continue;
            }

            ClassMetadata classMetadata = sessionFactory
                    .getAllClassMetadata().get(entity.getClass().getName());
            String[] propertyNames = classMetadata.getPropertyNames();
            Session session = null;

            // Iterate through all persistent properties
            for (String propertyName : propertyNames) {

                Object propertyValue = classMetadata.getPropertyValue(entity, propertyName);
                Type propertyType = classMetadata.getPropertyType(propertyName);

                // Handle entity types
                if (propertyType.isEntityType()) {

                    // Detach proxies
                    if (propertyValue instanceof HibernateProxy) {
                        SessionImplementor sessionImplementor = ((HibernateProxy) propertyValue)
                                .getHibernateLazyInitializer().getSession();

                        if (sessionImplementor instanceof Session) {
                            ((Session) sessionImplementor).evict(propertyValue);

                            // If we don't yet have a session for this entity save it for later use.
                            if (session == null)
                                session = (Session) sessionImplementor;
                        }

                    } else {
                        // Add entities to the processing queue.
                        entities.add(propertyValue);
                    }

                }
                // Handle collection types
                else if (propertyType.isCollectionType()) {

                    if (propertyValue instanceof AbstractPersistentCollection) {
                        SessionImplementor sessionImplementor =
                                ((AbstractPersistentCollection) propertyValue).getSession();

                        // If we don't yet have a session for this entity save it for later use.
                        if (sessionImplementor instanceof Session && session == null) {
                            session = (Session) sessionImplementor;
                        }
                    }
                }
            }

            // Evict the entity and associated collections.
            if (session != null) {
                session.evict(entity);
            }

            processedEntities.add(entity);
        }
    }
}
