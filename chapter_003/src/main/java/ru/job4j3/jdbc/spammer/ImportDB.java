package ru.job4j3.jdbc.spammer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Class ImportDB.
 * @author v.ivanov
 * @version 1
 * @since 01.07.2020
 */
public class ImportDB {
    /** Field logger.*/
    private static final Logger LOG = LoggerFactory.getLogger(ImportDB.class.getName());

    /** Field properties.*/
    private Properties cfg;

    /** Field file.*/
    private String dump;

    /**
     * Class ImportDB constructor.
     * @param cfg config with db credentials
     * @param dump file name
     */
    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    /**
     * Method to load values from text file.
     * @return list of users
     * @throws IOException exception
     */
    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        String sep = System.getProperty("file.separator");
        try (BufferedReader rd = new BufferedReader(new FileReader(
                System.getProperty("user.dir") + this.cfg.getProperty("file.path") + dump
        ))) {
            rd.lines().forEach(l -> {
                l = l.substring(0, l.length() - 1);
                String[] arr = l.split(";");
                users.add(new User(arr[0].trim(), arr[1].trim()));
            });
        }
        return users;
    }

    /**
     * Method to insert users name and email into database.
     * @param users list of users
     * @return result of operation
     */
    public boolean loadUsersIntoDB(List<User> users) {
        int count = 0;
        try (Connection con = DriverManager.getConnection(
                this.cfg.getProperty("jdbc.url"),
                this.cfg.getProperty("jdbc.username"),
                this.cfg.getProperty("jdbc.password")
        )) {
            try (PreparedStatement pst = con.prepareStatement("insert into users(name, email) values(?, ?)")) {
                for (int i = 0; i < users.size(); i++) {
                    pst.setString(1, users.get(i).name);
                    pst.setString(2, users.get(i).email);
                    count += pst.executeUpdate();
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return count == users.size();
    }

    /**
     * Class User.
     */
    private static class User {
        /** User name.*/
        private String name;

        /** User email.*/
        private String email;

        /**
         * Class User constructor.
         * @param name name
         * @param email email
         */
        User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    /**
     * Entry point.
     * @param args arguments
     * @throws Exception exception
     */
    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "dump.txt");
        db.loadUsersIntoDB(db.load());
    }
}
