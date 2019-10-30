
public class SingletonLogger implements BasicLogger {

        private static SingletonLogger logger;

        public SingletonLogger() {
                if (logger == null) {
                        logger = this;
                }
        }

        public SingletonLogger getlogger() {
                return logger;
        }

        public void log(String message) {
                System.out.println (message);
        }

        public static void main(String[] args) {
                String message = "Hello, i'm a singleton logger";

                SingletonLogger logger = LoggerFactory.getSingletonLogger();
                logger.log(message);

                message = "i am same logger";

                SingletonLogger logger2 = LoggerFactory.getSingletonLogger();
                logger2.log(message);

                System.out.println(logger == logger2);
        }
}