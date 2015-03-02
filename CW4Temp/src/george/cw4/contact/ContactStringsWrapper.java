package george.cw4.contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Squall on 07/01/2015.
 */
public class ContactStringsWrapper {
    private List<String> namesList;
    private List<String> notesList;

    public ContactStringsWrapper()
    {
        namesList = new ArrayList<String>();
        notesList = new ArrayList<String>();
    }

    public List<String> getNamesList()
    {
        return namesList;
    }

    public List<String> getNotesList()
    {
        return notesList;
    }

    public void printLists()
    {
        for (int i = 0; i < namesList.size(); i++)
        {
            System.out.println("Name: " + namesList.get(i));
        }

        for (int j = 0; j < notesList.size(); j++)
        {
            System.out.println("Note: " + notesList.get(j));
        }
    }
}
