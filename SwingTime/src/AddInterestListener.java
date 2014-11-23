import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Cloud on 23/11/2014.
 */

public class AddInterestListener implements ActionListener
{
    private InvestmentFrame frame;

    public AddInterestListener(InvestmentFrame frame)
    {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent event)
    {
        double rate = Double.parseDouble(frame.getRateField().getText());
        double interest = frame.getAccount().getBalance() * rate/100;
        frame.getAccount().deposit(interest);
        frame.getResultLabel().setText("balance: " + frame.getAccount().getBalance());
    }
}

