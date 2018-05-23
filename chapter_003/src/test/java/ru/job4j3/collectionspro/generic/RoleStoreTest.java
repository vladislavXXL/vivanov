package ru.job4j3.collectionspro.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Class RoleStoreTest to test class RoleStore.
 * @author vivanov
 * @version 1
 * @since 24.05.2018
 */
public class RoleStoreTest {

    /** RoleStore class container.*/
    private RoleStore storeBox;

    /**
     * Setup container.
     */
    @Before
    public void setUp() {
        this.storeBox = new RoleStore(3);
    }

    /**
     * Test add method.
     */
    @Test
    public void whenUsedAdd() {
        Role expected = new Role("1");
        this.storeBox.add(expected);
        Role result = this.storeBox.findById("1");
        assertThat(result, is(expected));
    }

    /**
     * Test replace method.
     */
    @Test
    public void whenUsedReplace() {
        Role someRole = new Role("33");
        this.storeBox.add(someRole);
        Role expected = new Role("55");
        boolean resultBoolean = this.storeBox.replace("33", expected);
        Role result = this.storeBox.findById("55");
        assertThat(resultBoolean, is(true));
        assertThat(result, is(expected));
    }

    /**
     * Test delete.
     */
    @Test(expected = NullPointerException.class)
    public void whenUsedDelete() {
        Role role = new Role("11");
        this.storeBox.add(role);
        this.storeBox.delete("11");
        Role result = this.storeBox.findById("11");
        assertThat(result, is(nullValue()));
    }

    /**
     * Test findById() method.
     */
    @Test
    public void whenUsedFindById() {
        Role expected = new Role("21");
        this.storeBox.add(expected);
        Role result = this.storeBox.findById("21");
        assertThat(expected, is(result));
    }
}