package ru.job4j3.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class UsageLog4j.
 *
 * @author v.ivanov
 * @version 1
 * @since 19.04.2020
 */
public class UsageLog4j {
    /** Field logger.*/
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    /**
     * Entry point.
     * @param args args
     */
    public static void main(String[] args) {
        byte house = 125;
        short id = 32000;
        int age = 39;
        long index = 1111111111111111L;
        double height = 185.0;
        float weight = 85.0f;
        boolean isValue = true;
        char abc = 'c';
        LOG.debug(
                "Primitive types byte: {}, short: {}, int: {}, long: {}, double: {}, float: {}, boolean: {}, char: {}",
                house, id, age, index, height, weight, isValue, abc
        );
    }
}
