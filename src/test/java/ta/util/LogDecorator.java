package ta.util;

import org.apache.logging.log4j.Logger;

public class LogDecorator {
    private Logger logger;

    public LogDecorator(Logger logger) {
        this.logger = logger;
    }

    public void decorate(String message) {
        logger.info("------{}------", message);
    }
}

