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
        LOG.trace("Trace message");
        LOG.debug("Debug message");
        LOG.info("Info message");
        LOG.warn("Warning message");
        LOG.error("Error message");
    }
}
