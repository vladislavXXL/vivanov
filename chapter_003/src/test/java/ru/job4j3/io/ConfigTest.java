package ru.job4j3.io;

import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Class ConfigTest.
 *
 * @author vivanov
 * @version 1
 * @since 14.08.2019
 */
public class ConfigTest {
    /** Config instance.*/
    private Config cnf;

    /** File to get properties.*/
    private static final String FILE = "app.properties";

    /** Expected properties keys and values.*/
    private static final ImmutableMap<String, String> EXPECTED = new ImmutableMap.Builder<String, String>()
            .put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
            .put("hibernate.connection.url", "jdbc:postgresql://127.0.0.1:5432/trackstudio")
            .put("hibernate.connection.driver_class", "org.postgresql.Driver")
            .put("hibernate.connection.username", "postgres")
            .put("hibernate.connection.password", "password")
            .build();

    /**
     * Setup method.
     * @throws IOException exception
     */
    @Before
    public void setUp() throws IOException {
        this.cnf = new Config(FILE);
        this.cnf.load();
    }

    /**
     * Method to check getting values.
     * @throws IOException
     */
    @Test
    public void checkValues() {
        assertThat(this.cnf.getValues(), equalTo(EXPECTED));
    }

    /**
     * Method to check getting value by key.
     */
    @Test
    public void checkValueByKey() {
        assertThat(this.cnf.value("hibernate.connection.url"), is(EXPECTED.get("hibernate.connection.url")));
        assertThat(this.cnf.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        assertThat(this.cnf.value("hibernate.connection.driver_class"), is(EXPECTED.get("hibernate.connection.driver_class")));
    }
}
