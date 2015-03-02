package george.cw4.meeting;

import george.cw4.contact.Contact;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Cloud on 18/12/2014.
 */
public abstract class AbstractMeeting implements Meeting, Comparable<Meeting> {
    private int id;
    private Calendar date;
    private Set<Contact> contacts;

    private static int COUNT = 0;

    public AbstractMeeting(Calendar date, Set<Contact> contacts)
    {
        COUNT++;
        this.id = COUNT;
        this.date = date;
        this.contacts = contacts;
    }

    //This Constructor should only be called when Notes are Added to Meeting.
    //Therefore count should not be incremented as the original id will be retained.
    public AbstractMeeting(Calendar date, Set<Contact> contacts, int id)
    {
        this.date = date;
        this.contacts = contacts;
        this.id = id;
    }

    /**
     * @see george.cw4.meeting.Meeting#getId()
     */
    public int getId()
    {
        return id;
    }

    /**
     * @see george.cw4.meeting.Meeting#getDate()
     */
    public Calendar getDate()
    {
        return date;
    }

    /**
     * @see george.cw4.meeting.Meeting#getContacts()
     */
    public Set<Contact> getContacts()
    {
        return contacts;
    }

    @Override
    public int compareTo(Meeting meeting)
    {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if (this == meeting)
        {
            return EQUAL;
        }
        if (this.date.compareTo(meeting.getDate()) < 0)
        {
            return BEFORE;
        }
        else if (this.date.compareTo(meeting.getDate()) > 0)
        {
            return AFTER;
        }
        else
        {
            return EQUAL;
        }
    }

    /**
     * Used Only for startUp when reading to lists
     * To get COUNT variable equal to number of Lists.
     * Not a nice method to have to Include!
     */
    public static void incrementCount()
    {
        COUNT++;
    }

    /**
     * Required for testing. Resets Count variable.
     * Note: FOR TEST's ONLY!
     */
    public static void resetCount()
    {
        COUNT = 0;
    }

}
