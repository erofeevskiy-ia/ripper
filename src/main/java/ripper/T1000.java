package ripper;

import ripper.quoter.Quoter;

public class T1000 extends TerminatorQuoter implements Quoter {
    @Override
    public String sayQuote() {
        return "I'm liquid";
    }
}
