package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class TrackerHbmTest {

    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @BeforeEach
    public void wipeItemsTable() {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Item").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenReplaceItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            Item item2 = new Item();
            item.setName("test2");
            tracker.add(item);
            tracker.replace(item.getId(), item2);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item2.getName());
        }
    }

    @Test
    public void whenDeleteItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            tracker.delete(item.getId());
            Item result = tracker.findById(item.getId());
            assertThat(result).isNull();
        }
    }

    @Test
    public void whenFindAll() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            Item item2 = new Item();
            item.setName("test2");
            tracker.add(item);
            tracker.add(item2);
            List<Item> itemList = List.of(item, item2);
            List<Item> itemListDb = tracker.findAll();
            assertThat(itemList.size()).isEqualTo(itemListDb.size());
        }
    }

    @Test
    public void whenFindByName() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(item.getName()).isEqualTo(result.getName());
        }
    }

    @Test
    public void whenFindById() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(item.getName()).isEqualTo(result.getName());
        }
    }

}
