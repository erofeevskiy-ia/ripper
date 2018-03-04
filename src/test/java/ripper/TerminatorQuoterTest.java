package ripper;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ripper.quoter.Quoter;

import static org.junit.jupiter.api.Assertions.*;

class TerminatorQuoterTest {
    private static ApplicationContext CTX = new ClassPathXmlApplicationContext("application-context.xml");

    @Test
    void testing() {
        assertEquals("I'll be back", CTX.getBean(Quoter.class).sayQuote());
    }

    public static void main(String[] args) throws InterruptedException {
        /*while (true) {
            Thread.sleep(500);
            CTX.getBean(Quoter.class).consoleSayQuote();

        }*/
        //CTX.getBean(Quoter.class).consoleSayQuote();
    }

}