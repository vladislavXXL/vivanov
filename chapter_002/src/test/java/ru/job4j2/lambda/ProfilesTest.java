package ru.job4j2.lambda;

import com.google.gson.Gson;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class ProfileTest to test class Profiles.
 *
 * @author v.ivanov
 * @version 1
 * @since 31.10.2019
 */
public class ProfilesTest {

    /** Field list of profiles.*/
    private static List<Profile> profilesList;

    /** Class Profiles instance.*/
    private static Profiles profiles;

    /**
     * Initialization method.
     *
     * @throws FileNotFoundException exception if file not found
     */
    @BeforeClass
    public static void setUp() throws FileNotFoundException {
        profiles = new Profiles();
        Gson gson = new Gson();
        profilesList = new ArrayList<>(Arrays.asList(
                gson.fromJson(new FileReader(System.getProperty("user.dir") + System.getProperty("file.separator") + "profiles.json"), Profile[].class))
        );
    }

    /**
     * Method to test collect() of Profiles class.
     */
    @Test
    public void checkCollectMethod() {
        List<Address> expectedAddresses = Arrays.asList(
                new Address("Anapa", "Moskovskaya", 5, 7),
                new Address("Anapa", "Novorossiyskaya", 1, 2),
                new Address("Moscow", "Noviy Arbat", 15, 21),
                new Address("Moscow", "Tverskaya",  3, 12),
                new Address("Novosibirsk", "Tulskaya", 21, 123),
                new Address("Voronezh", "Tulskaya", 23, 31)
        );
        assertThat(profiles.collect(profilesList), is(expectedAddresses));
    }
}
