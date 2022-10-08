package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            rsl = session.createQuery("update Item set name = :fname" +
                            ", created = :fcreated where id = :fId")
                    .setParameter("fname", item.getName())
                    .setParameter("fcreated", item.getCreated())
                    .setParameter("fId", id)
                    .executeUpdate() > 0;
            ;
            session.getTransaction().commit();
            rsl = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            rsl = session.createQuery(
                            "delete Item where id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List<Item> itemList;
        itemList = (List<Item>) session.createQuery(
                        "from Item", Item.class)
                .list();
        session.close();
        return itemList;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> itemList;
        Session session = sf.openSession();
        itemList = session.createQuery(
                        "from User where name = :fkey", Item.class)
                .setParameter("fkey", key)
                .list();
        session.close();
        return itemList;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Item item = session.createQuery(
                        "from Item where id = :fId ", Item.class)
                .setParameter("fId", id)
                .uniqueResult();
        session.close();
        return item;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}