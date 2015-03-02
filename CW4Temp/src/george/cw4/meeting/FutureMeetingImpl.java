package george.cw4.meeting;

import george.cw4.contact.Contact;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Cloud on 22/12/2014.
 */
public class FutureMeetingImpl extends AbstractMeeting implements FutureMeeting {

    public FutureMeetingImpl(Calendar date, Set<Contact> contacts)
    {
        super(date, contacts);
    }

    public FutureMeetingImpl(Calendar date, Set<Contact> contacts, int id)
    {
        super(date, contacts, id);
    }
}
