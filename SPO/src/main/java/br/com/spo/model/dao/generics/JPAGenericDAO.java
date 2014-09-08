package br.com.spo.model.dao.generics;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author yuri.sousa
 *
 * @param <T>
 *            entity class
 */
public class JPAGenericDAO<T extends Serializable> implements GenericDAO<T> {

    // @PersistenceContext
    private EntityManager entityManager;
    
    private Class<T> persistentClass;
    
    @SuppressWarnings("unchecked")
    public JPAGenericDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    public JPAGenericDAO(EntityManager entityManager) {
        this();
        this.entityManager = entityManager;
    }
    
    protected Class<T> getPersistentClass() {
        if (this.persistentClass == null) {
            throw new IllegalStateException("PersistentClass has not been set on DAO before usage");
        }
        return this.persistentClass;
    }
    
    protected void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }
    
    protected EntityManager getEntityManager() {
        if (this.entityManager == null) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("MySQLPersistence");
            entityManager = factory.createEntityManager();
            // throw new
            // IllegalStateException("EntityManager has not been set on DAO before usage");
        }
        return this.entityManager;
    }
    
    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    private Query createQuery(String JPQL, Object... parans) {
        Query query = this.getEntityManager().createQuery(JPQL);
        int i = 0;
        for (Object object : parans) {
            query.setParameter(++i, object);
        }
        return query;
    }
    
    @Override
    public void salvar(T t) {
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().persist(t);
        this.getEntityManager().getTransaction().commit();
    }
    
    @Override
    public void alterar(T t) {
        this.getEntityManager().merge(t);
    }
    
    @Override
    public void remover(Serializable id) {
        this.getEntityManager().remove(this.getEntityManager().getReference(getPersistentClass(), id));
    }
    
    @Override
    public T buscarPorId(Serializable id) {
        return this.getEntityManager().find(getPersistentClass(), id);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<T> listarTodos() {
        return (List<T>) this.buscarPorJpql("FROM " + this.getPersistentClass().getSimpleName());
    }
    
    @Override
    public List<?> buscarPorJpql(String jpql, Object... parans) {
        return this.createQuery(jpql, parans).getResultList();
    }
    
    @Override
    public Object buscarUnicoResultadoPorJpql(String jpql, Object... parans) {
        return this.createQuery(jpql, parans).getSingleResult();
    }
    
    @Override
    public int count() {
        String jpql = new String("SELECT COUNT(*) FROM " + this.getPersistentClass().getSimpleName());
        return Integer.parseInt(this.createQuery(jpql).getSingleResult().toString());
    }
    
}
