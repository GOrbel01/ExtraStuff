package george.cw4.meeting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cloud on 07/01/2015.
 */
public class MeetingStringsWrapper {

    private List<Integer> IDs;
    private List<String> attendees;
    private List<String> dates;
    private List<String> notes;

    public MeetingStringsWrapper()
    {
        IDs = new ArrayList<Integer>();
        attendees = new ArrayList<String>();
        dates = new ArrayList<String>();
        notes = new ArrayList<String>();
    }

    public List<String> getAttendeesList()
    {
        return attendees;
    }

    public List<Integer> getIDs()
    {
        return IDs;
    }

    public List<String> getDatesList()
    {
        return dates;
    }

    public List<String> getNotes()
    {
        return notes;
    }

    public void printLists()
    {
        for (int i = 0; i < attendees.size(); i++)
        {
            System.out.println(IDs.get(i));
            System.out.println(attendees.get(i));
            System.out.println(dates.get(i));
            if (i < notes.size())
            {
                System.out.println(notes.get(i));
            }
            System.out.println();
        }
    }
}