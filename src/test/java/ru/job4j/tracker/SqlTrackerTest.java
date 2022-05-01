package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsNull;
import org.junit.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        MatcherAssert.assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplaceItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item bug = new Item("item");
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        MatcherAssert.assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDeleteItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("First"));
        int id = item1.getId();
        tracker.delete(id);
        MatcherAssert.assertThat(tracker.findById(id), is(IsNull.nullValue()));
    }

    @Test
    public void whenTestFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("First"));
        Item item2 = tracker.add(new Item("Second"));
        List<Item> rsl = tracker.findAll();
        List<Item> expect = List.of(item1, item2);
        MatcherAssert.assertThat(rsl, is(expect));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("first"));
        Item item2 = tracker.add(new Item("second"));
        Item item3 = tracker.add(new Item("first"));
        List<Item> rsl = tracker.findByName("first");
        List<Item> expect = List.of(item1, item3);
        MatcherAssert.assertThat(rsl, is(expect));
    }

    @Test
    public void whenTestFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("first"));
        Item item2 = tracker.add(new Item("second"));
        Item result = tracker.findById(item2.getId());
        MatcherAssert.assertThat(result.getName(), is(item2.getName()));
    }
}