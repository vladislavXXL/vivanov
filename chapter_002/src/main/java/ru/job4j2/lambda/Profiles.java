package ru.job4j2.lambda;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author v.ivanov
 * @version 1
 * @since 31.10.2019
 */
public class Profiles {
    /**
     * Method to get profiles addresses.
     *
     * @param profiles to get addresses
     * @return list of addresses
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }
}
