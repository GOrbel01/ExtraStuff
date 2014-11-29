package george.sfg.userinterface;

import george.sfg.setup.CharacterSetup;
import george.sfg.setup.WeaponListener;
import george.sfg.weapons.Weapon;
import george.sfg.weapons.storedWeapons.WeaponList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Cloud on 28/11/2014.
 */
public class WeaponSelectFrame extends JFrame {
    private JPanel panel1;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JTextPane textPane3;
    private JTextPane textPane4;
    private JTextPane textPane5;
    private JTextPane textPane6;
    private JTextPane textPane7;
    private JTextPane textPane8;
    private JLabel weapon1;
    private JLabel weapon2;
    private JLabel weapon3;
    private JLabel weapon4;
    private JLabel weapon5;
    private JLabel weapon6;
    private JLabel weapon7;
    private JLabel weapon8;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;

    private ActionListener[] listener;

    private JLabel[] labels;
    private JButton[] buttons;
    private JTextPane[] textPanes;

    private List<Weapon> weaponList;

    int size;

    private String choice;

    public WeaponSelectFrame()
    {
        WeaponList frameWeapons = new WeaponList();
        weaponList = frameWeapons.getList();
        size = weaponList.size();

        labels = new JLabel[size];
        addLabelsToList();
        buttons = new JButton[size];
        addButtonsToList();
        textPanes = new JTextPane[size];
        addTextPanesToList();

        setupIcons();
        setupButtons();
        setupTextPanes();


    }

    public void stateChanged(ChangeEvent e)
    {

    }

    public void launchFrame()
    {
        JFrame frame = new JFrame("WeaponSelectFrame");
        frame.setContentPane(new WeaponSelectFrame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void addButtonsToList()
    {
        buttons[0] = button1;
        buttons[1] = button2;
        buttons[2] = button3;
        buttons[3] = button4;
        buttons[4] = button5;
        buttons[5] = button6;
        buttons[6] = button7;
        buttons[7] = button8;
    }

    public void addLabelsToList()
    {
        labels[0] = weapon1;
        labels[1] = weapon2;
        labels[2] = weapon3;
        labels[3] = weapon4;
        labels[4] = weapon5;
        labels[5] = weapon6;
        labels[6] = weapon7;
        labels[7] = weapon8;
    }

    public void addTextPanesToList()
    {
        textPanes[0] = textPane1;
        textPanes[1] = textPane2;
        textPanes[2] = textPane3;
        textPanes[3] = textPane4;
        textPanes[4] = textPane5;
        textPanes[5] = textPane6;
        textPanes[6] = textPane7;
        textPanes[7] = textPane8;
    }

    public void setupIcons()
    {
        for (int i = 0; i < size; i++)
        {
            labels[i].setIcon(new ImageIcon(weaponList.get(i).getWepImage().getImagePath()));
        }
    }

    public void setupTextPanes()
    {
        for (int i = 0; i < size; i++)
        {
            String wepText = ("Weapon Name: " + weaponList.get(i).getName() + "\n" +
            "Bonus Base Attack: " + weaponList.get(i).getBonusAttack() + "\n");
            if (weaponList.get(i).getType().equals("StrengthWeapon"))
            {
                wepText = wepText + "Bonus Strength: " + weaponList.get(i).getPrimaryStatBonus();
            }
            else if (weaponList.get(i).getType().equals("MagicWeapon"))
            {
                wepText = wepText + "Bonus Magic: " + weaponList.get(i).getPrimaryStatBonus();
            }
            textPanes[i].setText(wepText);
        }
    }

    public void setupButtons()
    {
        System.out.println("Size" + size);
        for (int i = 0; i < size; i++)
        {
            buttons[i].setText("Select " + weaponList.get(i).getName());
            ActionListener listener = new WeaponListener(this);
            buttons[i].addActionListener(listener);
        }
    }

    public boolean showDialog(String info)
    {
        int reply = JOptionPane.showConfirmDialog(this, info, "Confirm", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getChoice()
    {
        return choice;
    }

    public void setChoice(String choice)
    {
        this.choice = choice;
    }
}
