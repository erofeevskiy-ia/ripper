package ripper;

import lombok.Data;
import ripper.annotations.InjectRandomInt;
import ripper.annotations.Profiling;
import ripper.quoter.Quoter;

import javax.annotation.PostConstruct;

@Data
@Profiling
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;
    private String message;

    public TerminatorQuoter() {
        System.out.println("Phase_1: I'm Constructor");
    }

    @PostConstruct
    public void init(){
        System.out.println("Phase_2: I'm init()");
        System.out.println(repeat);
    }

    @Override
    public String sayQuote() {
        return message;
    }

    @Override
    public void consoleSayQuote() {
        for (int i = 0; i < repeat; i++)
            System.out.println("mes: " + message);
    }

}
