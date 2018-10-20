package ru.job4j3.collectionspro;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class StoreTest.
 * @author v.ivanov
 * @version 1
 * @since 09.10.2018
 */
public class StoreTest {
    /** Field previous user's list.*/
    private List<Store.User> previous = new ArrayList<>();

    /** Field current user's list.*/
    private List<Store.User> current = new ArrayList<>();

    /** Field Store container.*/
    private Store obj = new Store();

    /** Field class Info instance describes statistics.*/
    private Store.Info statResult = new Store().new Info();

    /**
     * Initialization block.
     */
    @Before
    public void init() {
        this.previous = Arrays.asList(
                new Store.User(1, "Valera"),
                new Store.User(2, "Vasiliy"),
                new Store.User(3, "Vladimir"),
                new Store.User(4, "Viktor")
        );
        this.current = Arrays.asList(
                new Store.User(2, "Vasya"),
                new Store.User(3, "Vova"),
                new Store.User(5, "Vartan"),
                new Store.User(6, "Vagan")
        );

        this.statResult = obj.diff(this.previous, this.current);
    }

    /**
     * Check the new added users statistics.
     */
    @Test
    public void checkNewUsers() {
        assertThat(this.statResult.getNewUsers(), is(2));
    }

    /**
     * Check the edited users statistics.
     */
    @Test
    public void checkEditedUsers() {
        assertThat(this.statResult.getEditedUsers(), is(2));
    }

    /**
     * Check the deleted users statistics.
     */
    @Test
    public void checkDeletedUsers() {
        assertThat(this.statResult.getDeletedUsers(), is(2));
    }
}
