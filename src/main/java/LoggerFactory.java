/**
 * A factory class to return a particular logger class
 */
public class LoggerFactory {

    public static SingletonLogger getSingletonLogger() {
        return SingletonLogger.getlogger();
    }

    public static PrototypeLogger getPrototypeLogger() { return new PrototypeLogger().getlogger();}


}