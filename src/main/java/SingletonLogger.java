
public class SingletonLogger implements BasicLogger {

        private static SingletonLogger logger;

        private SingletonLogger(){

        }

        private static void getSingletonLogger() {
                if (logger == null) {
                        logger = new SingletonLogger();
                }
        }

        public static SingletonLogger getlogger() {
                getSingletonLogger();
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