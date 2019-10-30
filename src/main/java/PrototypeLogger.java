
public class PrototypeLogger implements BasicLogger {

        private PrototypeLogger logger;

        public PrototypeLogger() {
                logger = this;
        }

        public PrototypeLogger getlogger() {
                return logger;
        }

        public void log(String message) {
                System.out.println (message);
        }

        public static void main(String[] args) {
                String message = "Hello, i'm a prototype logger";

                PrototypeLogger logger = LoggerFactory.getPrototypeLogger();
                logger.log(message);

                message = "i am another logger";

                PrototypeLogger logger2 = LoggerFactory.getPrototypeLogger();
                logger2.log(message);

                System.out.println(logger == logger2);
        }
}