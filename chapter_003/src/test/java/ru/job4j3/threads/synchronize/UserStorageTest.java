package ru.job4j3.threads.synchronize;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class to test UserStorage.
 * @author v.ivanov
 * @version 1
 * @since 24.12.2018
 */
public class UserStorageTest {

    /** UserStorage instance.*/
    private UserStorage<User> str;

    /** User to delete.*/
    private User userToDelete;

    /**
     * Initialization block.
     */
    @Before
    public void precondition() {
        userToDelete = new User(4, 3900);
        List<User> users = Arrays.asList(
                new User(1, 500),
                new User(2, 5000),
                new User(3, 3500),
                new User(5, 5100)
        );
        str = new UserStorage<>(users);
        str.add(userToDelete);
    }

    /**
     * Test method getAmaountById.
     */
    @Test
    public void testGetAmountById() {
        assertThat(str.getAmountById(4), is(3900));
    }

    /**
     * Test user update.
     * @throws Exception exception if user's id not found
     */
    @Test
    public void testUserUpdate() throws Exception {
        User testUser = new User(2, 3000);
        boolean result = str.update(testUser);
        assertThat(result, is(true));
        assertThat(str.getAmountById(2), is(3000));
    }

    /**
     * Test transfer between two users.
     */
    @Test
    public void testTransfer() throws Exception {
        str.transfer(2, 5, 500);
        assertThat(str.getAmountById(2), is(4500));
        assertThat(str.getAmountById(5), is(5600));
    }

    @Test
    public void testUserDelete() {
        assertThat(str.delete(userToDelete), is(true));
    }
}