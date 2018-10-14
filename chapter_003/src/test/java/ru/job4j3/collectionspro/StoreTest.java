package ru.job4j3.collectionspro;

import org.junit.Before;
import org.junit.Test;

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
        this.previous.add(new Store.User(1, "Valera"));
        this.previous.add(new Store.User(2, "Vasiliy"));
        this.previous.add(new Store.User(3, "Vladimir"));
        this.previous.add(new Store.User(4, "Viktor"));

        this.current.add(new Store.User(1, "Valera"));
        this.current.add(new Store.User(2, "Vasya"));
        this.current.add(new Store.User(3, "Vova"));
        this.current.add(new Store.User(5, "Vartan"));
        this.current.add(new Store.User(6, "Vagan"));

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
        assertThat(this.statResult.getDeletedUsers(), is(1));
    }
}