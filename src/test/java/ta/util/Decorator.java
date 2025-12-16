package ta.util;

import org.apache.logging.log4j.Logger;

public abstract class Decorator implements DecoratorInterface {
    Logger logger;

    public Decorator(Logger logger) {
        this.logger = logger;
    }
}
