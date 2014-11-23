import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Cloud on 23/11/2014.
 */
public class InvestmentFrame extends JFrame {

    private static final int FRAME_WIDTH = 650;
    private static final int FRAME_HEIGHT = 100;

    private static final double DEFAULT_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;

    private JLabel rateLabel;
    private JTextField rateField;
    private JLabel nameLabel;
    private JButton button;
    private JLabel resultLabel;
    private JPanel panel;
    private BankAccount account;

    public JTextField getRateField()
    {
        return rateField;
    }

    public BankAccount getAccount()
    {
        return account;
    }

    public JLabel getResultLabel()
    {
        return resultLabel;
    }

    public InvestmentFrame()
    {
        account = new BankAccountImpl("James' Current Account", INITIAL_BALANCE);

        resultLabel = new JLabel("balance: " + account.getBalance());

        createNameField();
        createTextField();
        createButton();
        createPanel();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createTextField()
    {
        rateLabel = new JLabel("Interest Rate: ");
        final int FIELD_WIDTH = 10;
        rateField = new JTextField(FIELD_WIDTH);
        rateField.setText("" + DEFAULT_RATE);
    }

    private void createNameField()
    {
        nameLabel = new JLabel("" + account.getAccountName());
    }

    private void createButton()
    {
        button = new JButton("Add Interest");

        ActionListener listener = new AddInterestListener(this);
        button.addActionListener(listener);
    }

    private void createPanel()
    {
        panel = new JPanel();
        panel.add(nameLabel);
        panel.add(rateLabel);
        panel.add(rateField);
        panel.add(button);
        panel.add(resultLabel);
        add(panel);
    }
}
