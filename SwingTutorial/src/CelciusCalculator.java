import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Cloud on 29/11/2014.
 */
public class CelciusCalculator extends JFrame {
    private JTextField celciusTemp;
    private JButton convertButton;
    private JLabel fahrenheitLabel;
    private JPanel panel1;

    public CelciusCalculator() {
        launchFrame();
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tempFahr = (int) ((Double.parseDouble(celciusTemp.getText())) * 1.8 + 32);
                fahrenheitLabel.setText(tempFahr + " Fahrenheit");
            }
        });
    }

    public void convertButtonActionPerformed(ActionEvent evt)
    {

    }

    public static void main(String[] args)
    {
        CelciusCalculator frame = new CelciusCalculator();
        frame.launchFrame();
    }

    public void launchFrame()
    {
        JFrame frame = new CelciusCalculator();
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
