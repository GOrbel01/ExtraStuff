package george.sfg.setup;

import george.sfg.userinterface.WeaponSelectFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Cloud on 29/11/2014.
 */
public class WeaponListener implements ActionListener {

    Frame frame;
    private static int instanceCount = 0;
    private int number;

    public WeaponListener(Frame newFrame)
    {
        frame = newFrame;
        instanceCount++;
        number = instanceCount;
    }

    public void actionPerformed(ActionEvent event)
    {
        WeaponSelectFrame wepFrame = (WeaponSelectFrame) frame;
        boolean confirmation = false;
        String selectedWeaponName = splitActionCommand(event.getActionCommand());
        confirmation = wepFrame.showDialog("Confirm Choice");
        if (confirmation)
        {
            setSelection(selectedWeaponName, wepFrame);
        }
    }

    public void setSelection(String name, WeaponSelectFrame wepFrame)
    {
        wepFrame.setChoice(name);
    }

    public String splitActionCommand(String original)
    {
        String completeString = "";
        String[] splitString = original.split(" ");
        for (int i = 0; i < splitString.length; i++)
        {
            completeString = completeString + splitString[i];
        }
        return completeString;
    }
}
