package ripper;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class TerminatorQuoterTest {
    static ApplicationContext CTX = new ClassPathXmlApplicationContext("application-context.xml");

    @Test
    void testing(){
        assertEquals("I'll be back",CTX.getBean(TerminatorQuoter.class).sayQuote());
    }

    public static void main(String[] args) {
        CTX.getBean(TerminatorQuoter.class).consoleSayQuote();
    }

}