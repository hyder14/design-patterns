import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoggersTest {


    @Test
    public void testSingletonLogger() {
        SingletonLogger logger1 =  LoggerFactory.getSingletonLogger();
        //logger1 = logger1.getlogger();
        SingletonLogger logger2 =  LoggerFactory.getSingletonLogger();
        //logger2 = logger2.getlogger();
        Assert.assertEquals(logger1, logger2);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        logger1.getlogger().log("hello world");
        String text = out.toString().trim().replace("\\r\\n|\\r|\\n","");
        Assert.assertEquals("hello world",text);
    }


    @Test
    public void testPrototypeLogger() {

        PrototypeLogger prototypeLogger = LoggerFactory.getPrototypeLogger();
        //logger1 = logger1.getlogger();

        PrototypeLogger prototypeLogger1  = LoggerFactory.getPrototypeLogger();
        //logger2 = logger2.getlogger();

        Assert.assertNotEquals(prototypeLogger1, prototypeLogger);


    }

}
