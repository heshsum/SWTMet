package org.pareto.controller;

/**
 * Helper class for logging.
 */
public class LogHelper {
    /**
     * Helper method to make logging a bit easier.
     *
     * @param output one or multiple elements to log
     */
    public static void log(Object... output) {
        StringBuilder logString = new StringBuilder();

        for (Object element : output) {
            logString.append(" ").append(element.toString());
        }
        log(logString);
    }
}
