package ru.job4j2.tracker;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class SqlTrackerTest.
 * @author v.ivanov
 * @version 1
 * @since 12.07.2020
 */
public class SqlTrackerTest {

    /**
     * Connection initialization method.
     * @return Connection object
     */
    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties cfg = new Properties();
            cfg.load(in);
            Class.forName(cfg.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    cfg.getProperty("url"),
                    cfg.getProperty("username"),
                    cfg.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Test add new Item into database.
     */
    @Test
    public void addItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item(null, "Potato", "potato", 1L));
            assertThat(tracker.findByName("Potato").size(), is(1));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Test Item replace.
     */
    @Test
    public void replaceItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item(null, "Potato", "potato", 1L));
            Item newItem = new Item(null, "Tomato", "tomato", 1L);
            boolean result = tracker.replace(item.getId(), newItem);
            assertThat(result, is(true));
            assertThat(tracker.findById(item.getId()).getName(), is("Tomato"));
            assertThat(tracker.findById(item.getId()).getDesc(), is("tomato"));
            assertThat(tracker.findByName("Tomato").get(0).getId(), is(item.getId()));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Test Item delete.
     */
    @Test
    public void deleteItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item(null, "Onion", "onion", 1L));
            assertThat(true, is(tracker.delete(item.getId())));
            assertThat(tracker.findByName("Onion"), empty());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Test Item delete.
     */
    @Test
    public void findAllItems() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item(null, "Potato", "potato", 1L));
            tracker.add(new Item(null, "Onion", "onion", 1L));
            tracker.add(new Item(null, "Tomato", "tomato", 1L));

            Map<String, String> actualNames = tracker.findAll().stream()
                    .collect(Collectors.toMap(Item::getName, Item::getDesc));

            assertThat(actualNames, equalTo(new ImmutableMap.Builder<String, String>()
                    .put("Potato", "potato")
                    .put("Onion", "onion")
                    .put("Tomato", "tomato")
                    .build()
            ));
            assertThat(actualNames, not(equalTo(new ImmutableMap.Builder<String, String>()
                    .put("Potato", "potato2")
                    .put("Onion", "onion1")
                    .put("Tomato2", "tomato")
                    .build()
            )));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Test find item by name.
     */
    @Test
    public void findByName() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item(null, "Potato", "potato", 1L));
            Item item2 = tracker.add(new Item(null, "Onion", "onion", 1L));
            Item item3 = tracker.add(new Item(null, "Tomato", "tomato", 1L));
            assertThat(tracker.findByName("Onion123"), empty());
            assertThat(tracker.findByName("Onion").get(0), equalTo(item2));
            assertThat(tracker.findByName("Onion").get(0), not(equalTo(item3)));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Test find item by id.
     */
    @Test
    public void findById() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = tracker.add(new Item(null, "Potato", "potato", 1L));
            Item item2 = tracker.add(new Item(null, "Onion", "onion", 1L));
            Item item3 = tracker.add(new Item(null, "Carrot", "carrot", 1L));
            Item item4 = tracker.add(new Item(null, "Tomato", "tomato", 1L));
            assertThat(tracker.findById(item3.getId()).getName(), is("Carrot"));
            assertThat(tracker.findById(item3.getId()).getDesc(), is("carrot"));
            assertThat(tracker.findById(item1.getId()).getName(), not(is("Carrot")));
            assertThat(tracker.findById(item2.getId()).getName(), not(is("Carrot")));
            assertThat(tracker.findById(item4.getId()).getName(), not(is("Carrot")));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
