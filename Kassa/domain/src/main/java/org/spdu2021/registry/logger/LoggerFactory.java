package org.spdu2021.registry.logger;

public class LoggerFactory {

    public static Logger getLogger(Class c){
        return new Logger(c.getName());
    }

}
