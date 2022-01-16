package org.spdu2021.registry.logger;

public class Logger {

    private final String className;

    public Logger(String className) {
        this.className = className;
    }

    public void log(String message) {
        System.out.println(message);
    }

    public void info(Throwable error) {
        log("INFO: in " + className + ". " + error.getMessage());
    }

    public void warning(Throwable error) {
        log(" WARNING: in class: " + className + " " + error.getMessage());
    }

    public void error(Throwable error) {
        log(" ERROR: in class: " + className + " " + error.getMessage());
    }
}
