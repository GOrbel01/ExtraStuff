package org.me.myimageapp;

import javax.swing.*;

/**
 * Created by Cloud on 28/11/2014.
 */
public class ImageForm {
    private JPanel panel1;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("ImageForm");
        frame.setContentPane(new ImageForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
