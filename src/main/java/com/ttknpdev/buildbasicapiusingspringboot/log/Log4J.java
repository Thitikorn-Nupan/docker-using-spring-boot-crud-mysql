package com.ttknpdev.buildbasicapiusingspringboot.log;

import org.apache.log4j.Logger;

public class Log4J {

    public Logger logger;

    public Log4J(Class<?> c) {
        this.logger = Logger.getLogger(c);
    }

}
