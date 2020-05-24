package ru.job4j2.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Class SqlTracker.
 * @author v.ivanov
 * @version 1
 * @since 20.05.2020
 */
public class SqlTracker implements Store {

    /** Field logger.*/
    private static final Logger LOG = LoggerFactory.getLogger(SqlTracker.class.getName());

    /** Field connection.*/
    private Connection cn;

    /**
     * Method to initialize jdbc.
     */
    @Override
    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new IllegalStateException();
        }
    }

    /**
     * Method to close connection.
     * @throws Exception throws Exception
     */
    @Override
    public void close() throws Exception {
        if (this.cn != null) {
            this.cn.close();
        }
    }

    /**
     * Method to add new item into database.
     * @param item instance to add
     * @return added item
     */
    @Override
    public Item add(Item item) {
        try (PreparedStatement pst = this.cn.prepareStatement(
                        "insert into items(name, description, created) values(?, ? , ?)",
                        Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, item.getName());
            pst.setString(2, item.getDesc());
            pst.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            pst.executeUpdate();
            try (ResultSet keys = pst.getGeneratedKeys()) {
                while (keys.next()) {
                    item.setId(String.valueOf(keys.getInt("id")));
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
    }

    /**
     * Method to replace item on specified item id.
     * @param id item id for replacing
     * @param item item with new values
     * @return result of operation
     */
    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement pst = this.cn.prepareStatement("update items set name=?, description=?, created=? where id=?")) {
            pst.setString(1, item.getName());
            pst.setString(2, item.getDesc());
            pst.setTimestamp(3, new Timestamp(item.getCreated()));
            pst.setInt(4, Integer.parseInt(id));
            int res = pst.executeUpdate();
            if (res == 1) {
                result = true;
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Method to delete item by id.
     * @param id id of item to delete
     * @return result of operation
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement prs = this.cn.prepareStatement("delete from items as i where i.id=?")) {
            prs.setInt(1, Integer.parseInt(id));
            int resCount = prs.executeUpdate();
            if (resCount == 1) {
                result = true;
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Method to find all items.
     * @return list of items
     */
    @Override
    public List<Item> findAll() {
        List<Item> itemList = new ArrayList<>();
        try (Statement st = this.cn.createStatement()) {
            try (ResultSet res  = st.executeQuery("select * from items as i order by i.id")) {
                while (res.next()) {
                    itemList.add(new Item(
                            String.valueOf(res.getInt("id")),
                            res.getString("name"),
                            res.getString("description"),
                            res.getTimestamp("created").getTime()
                    ));
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return itemList;
    }

    /**
     * Method to find item by name.
     * @param key item's name
     * @return list of items found by name
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement pst = this.cn.prepareStatement("select * from items as i where i.name=?")) {
            pst.setString(1, key);
            try (ResultSet res = pst.executeQuery()) {
                while (res.next()) {
                    result.add(new Item(
                                    String.valueOf(res.getInt("id")),
                                    res.getString("name"),
                                    res.getString("description"),
                                    res.getTimestamp("created").getTime()
                            )
                    );
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Method to find item by id.
     * @param id of item
     * @return result item
     */
    @Override
    public Item findById(String id) {
        Item result = null;
        try (PreparedStatement pst = this.cn.prepareStatement("select * from items as i where i.id=?")) {
            pst.setInt(1, Integer.parseInt(id));
            try (ResultSet res = pst.executeQuery()) {
                while (res.next()) {
                    result = new Item(
                            String.valueOf(res.getInt("id")),
                            res.getString("name"),
                            res.getString("description"),
                            res.getTimestamp("created").getTime()
                    );
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }
}
