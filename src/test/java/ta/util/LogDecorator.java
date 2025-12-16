package ta.util;

import org.apache.logging.log4j.Logger;

public class LogDecorator extends Decorator {

    public LogDecorator(Logger logger) {
        super(logger);
    }

    public void decorate(String message) {
        logger.info("------{}------", message);
    }
}

