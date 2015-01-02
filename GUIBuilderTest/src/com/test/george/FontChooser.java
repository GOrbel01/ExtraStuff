package com.test.george;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Created by Cloud on 28/11/2014.
 */
public class FontChooser {
    private JPanel panel1;
    private JList fontNameList;
    private JList fontSizeList;
    private JRadioButton regularRadioButton;
    private JRadioButton boldRadioButton;
    private JRadioButton italicRadioButton;
    private JRadioButton boldItalicRadioButton;
    private JLabel previewLabel;


    public FontChooser() {
        fontNameList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                updateFont();
            }
        });
        fontSizeList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                updateFont();
            }
        });
        ChangeListener listener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                updateFont();
            }
        };
        regularRadioButton.addChangeListener(listener);
        boldRadioButton.addChangeListener(listener);
        italicRadioButton.addChangeListener(listener);
        boldItalicRadioButton.addChangeListener(listener);
    }

    public void stateChanged(ChangeEvent e) {

    }

    private void updateFont() {
        String fontName = (String) fontNameList.getSelectedValue();
        if (fontName == null)
        {
            fontName = "Arial";
        }
        int fontSize;
        if (fontSizeList.getSelectedValue() == null)
        {
            fontSize = 10;
        }
        else
        {
            fontSize = Integer.parseInt(fontSizeList.getSelectedValue().toString());
        }
        int fontStyle = Font.PLAIN;
        if (boldRadioButton.isSelected())
        {
            fontStyle = Font.BOLD;
        }
        else if (italicRadioButton.isSelected())
        {
            fontStyle = Font.ITALIC;
        }
        else if (boldItalicRadioButton.isSelected())
        {
            fontStyle = Font.BOLD | Font.ITALIC;
        }
        previewLabel.setFont(new Font(fontName, fontStyle, fontSize));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FontChooser");
        frame.setContentPane(new FontChooser().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
