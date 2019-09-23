package ru.job4j2.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class to test UserConvert.
 *
 * @author vivanov
 * @version 1
 * @since 23.09.2019
 */
public class UserToListConvertTest {

    /**
     * Method to check UserConvert.
     */
    @Test
    public void checkUserConvert() {
        List<String> names = Arrays.asList("Petr", "Nick", "Ban");
        UserConvert users = new UserConvert();
        List<UserConvert.User> data = users.convert(names, UserConvert.User::new);
        assertThat(names, is(data.stream().map(UserConvert.User::getName).collect(Collectors.toList())));
    }
}
