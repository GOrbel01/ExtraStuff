package george.sfg.userinterface;

import george.sfg.characters.Fighter;
import george.sfg.characters.storedCharacters.FighterList;
import george.sfg.setup.CharacterSetup;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * Created by Cloud on 26/11/2014.
 */
public class CharacterSelectFrame extends JFrame {

    private static final int FRAME_WIDTH = 1250;
    private static final int FRAME_HEIGHT = 900;

    private FighterList frameFighters = new FighterList();
    private List<Fighter> fighterList = frameFighters.getList();

    private int number;

    private File resDir = new File("");

    private JLabel[] picLabel;
    private JButton[] button;
    private JTextArea[] stats;
    private JPanel panel;


    public CharacterSelectFrame()
    {
        resDir = new File(resDir.getAbsolutePath() + File.separator + "SimpleFFGame" + File.separator +
                "resource");
        number = fighterList.size();
        button = new JButton[number];
        stats = new JTextArea[number];
        picLabel = new JLabel[number];
        for (int i = 0; i < fighterList.size(); i++)
        {
                try
                {
                    BufferedImage myPicture = ImageIO.read(new File(resDir.getAbsolutePath() + File.separator
                            + "Pic" + i + ".jpg"));
                    picLabel[i] = new JLabel(new ImageIcon(myPicture));
                    picLabel[i].setBounds(0, 0, 120, 143);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            stats[i] = new JTextArea(4, 5);
            createTextArea(i);
            createButton(i);
        }

        createPanel();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }


    private void createPanel()
    {
        panel = new JPanel();
//        panel.setLayout(new GridLayout(5, 5));
        panel.setLayout(new FlowLayout());
        JScrollPane scrollPane = null;
        for (int i = 0; i < number; i++)
        {
            panel.add(picLabel[i]);
            scrollPane = new JScrollPane(stats[i]);
            panel.add(scrollPane);
            panel.add(button[i]);
        }
        add(panel);
    }

    private void createTextArea(int number)
    {
        stats[number].append("Name: " + fighterList.get(number).getName() + "\n");
        stats[number].append("Base Attack: " + fighterList.get(number).getAttack() + "\n");
        if (fighterList.get(number).getType().equals("MagicUser"))
        {
            stats[number].append("Base Magic: " + fighterList.get(number).getPrimaryStat() + "\n");
        }
        else if (fighterList.get(number).getType().equals("StrengthUser"))
        {
            stats[number].append("Base Strength: " + fighterList.get(number).getPrimaryStat() + "\n");
        }
        stats[number].append("Base Health: " + fighterList.get(number).getHealth() + "\n");
        stats[number].append("Resource: " + fighterList.get(number).getResource().getResourceName() + "\n");
        stats[number].append("Base Speed: " + fighterList.get(number).getSpeed());
        stats[number].setAlignmentX(JScrollPane.CENTER_ALIGNMENT);
        stats[number].setRows(9);
        stats[number].setColumns(12);
        stats[number].setEditable(false);
    }

    private void createButton(int number)
    {
        String name = fighterList.get(number).getName();
        button[number] = new JButton("Select " + name);
        button[number].setBounds(0, 0, 2, 2);
        ActionListener listener = new CharacterSetup(this);
        button[number].addActionListener(listener);
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

    public String showNewNameDialog()
    {
        String str = JOptionPane.showInputDialog(this, "Enter new Name");
        if (str != null)
        {
            if (str.isEmpty())
            {
                System.out.println("HERE");
                str = showNewNameDialog();
            }
        }
        return str;
    }
}
