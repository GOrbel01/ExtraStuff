package george.cw4.meeting;

import george.cw4.contact.Contact;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Cloud on 22/12/2014.
 */
public class PastMeetingImpl extends AbstractMeeting implements PastMeeting {

    private String notes;

    public PastMeetingImpl(Calendar date, Set<Contact> contacts, String note)
    {
        super(date, contacts);
        this.notes = note;
    }

    public PastMeetingImpl(Meeting meeting, String notes, int id)
    {
        super(meeting.getDate(), meeting.getContacts(), id);
        this.notes = notes;
    }

    public PastMeetingImpl(Calendar date, Set<Contact> contacts, String note, int id)
    {
        super(date, contacts, id);
        notes = note;
    }

    public String getNotes()
    {
        return notes;
    }

}
