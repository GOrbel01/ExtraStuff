package george.sfg.userinterface;

import george.sfg.characters.Fighter;
import george.sfg.setup.CharacterSetup;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * Created by Cloud on 26/11/2014.
 */
public class CharacterSelectFrame extends JFrame {

    private static final int FRAME_WIDTH = 1250;
    private static final int FRAME_HEIGHT = 900;

    private List<Fighter> fighterList;

    private int number;

    private BufferedImage[] images;

    File tempFile = new File("");
    File resDir = new File(tempFile.getAbsolutePath() + File.separator + "SimpleFFGame" + File.separator +
            "resource");

    private JLabel[] nameLabel;
    private JLabel picLabel;
    private JTextArea[] stats;
    private JPanel panel;

    private CharacterSetup cSetup;

    public CharacterSelectFrame()
    {

    }

    public CharacterSelectFrame(List<Fighter> fighters, CharacterSetup chs)
    {
        number = fighters.size();
        nameLabel = new JLabel[number];
        stats = new JTextArea[number];
        images = new BufferedImage[number];

        this.fighterList = fighters;

        cSetup = chs;

        for (int i = 0; i < fighterList.size(); i++)
        {
//            System.out.println("PD_TEST: " + testFile.getAbsolutePath());
            if (i == 0)
            {
                try
                {
                    System.out.println("PATH: " + resDir.getAbsolutePath() + "Pic0.jpg");
                    BufferedImage myPicture = ImageIO.read(new File(resDir.getAbsolutePath() + File.separator
                            + "Pic" + "0" + ".jpg"));
                    picLabel = new JLabel(new ImageIcon(myPicture));
                    picLabel.setBounds(0, 0, 42, 42);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
            stats[i] = new JTextArea(4, 5);
            createTextArea(i);
        }

        createPanel();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g.drawImage(images[0], 0, 0, null);
    }

    private void createPanel()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));
//        panel.add();
        JScrollPane scrollPane = null;
        for (int i = 0; i < number; i++)
        {
            scrollPane = new JScrollPane(stats[i]);
            panel.add(scrollPane);
            panel.add(nameLabel[i]);
        }
        add(picLabel);
        add(panel);
    }

    private void createTextArea(int number)
    {
        createNameField(number);
        stats[number].append("Base Attack: " + fighterList.get(number).getAttack() + "\n");
        stats[number].append("Base Strength: " + fighterList.get(number).getPrimaryStat() + "\n");
        stats[number].append("Base Health: " + fighterList.get(number).getHealth() + "\n");
        stats[number].append("Resource: " + fighterList.get(number).getResource().getResourceName() + "\n");
        stats[number].append("Base Speed: " + fighterList.get(number).getSpeed());
        stats[number].setEditable(false);
    }

    private void createNameField(int number)
    {
        nameLabel[number] = new JLabel(fighterList.get(number).getName());
    }
}
