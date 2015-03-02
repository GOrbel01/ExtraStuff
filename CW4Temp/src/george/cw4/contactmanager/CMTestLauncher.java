package george.cw4.contactmanager;

import george.cw4.contact.Contact;
import george.cw4.contact.ContactImpl;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Cloud on 18/12/2014.
 */
public class CMTestLauncher {

    public static void main(String[] args)
    {
        CMTestLauncher cms = new CMTestLauncher();
        cms.launch();
    }

    private void launch()
    {
        ContactManagerImpl cm = null;
        try {
            cm = new ContactManagerImpl();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
//        cm.addNewContact("Bill Monk", "");
//        cm.addNewContact("Jen Straw", "");
//        cm.addNewContact("Jenny Smith", "");
//        cm.addNewContact("Iain Jones", "Jenkins, Johnson or Jones");
//        System.out.println("WTF");
//        cm.addNewPastMeeting(cm.getContacts(1, 2, 3), new GregorianCalendar(2014, 4, 21, 13, 30), "Constructive meeting");
//        cm.addFutureMeeting(cm.getContacts(1, 2, 3), new GregorianCalendar(2015, 11, 21, 13, 30));
//        cm.addNewPastMeeting(cm.getContacts(1, 2, 3), new GregorianCalendar(2013, 11, 23, 11, 20), "Bad Meeting, people seemed tired");
//        cm.addFutureMeeting(cm.getContacts(1, 2, 3), new GregorianCalendar(2015, 5, 25, 13, 30));
//        cm.addNewPastMeeting(cm.getContacts(1, 2, 3), new GregorianCalendar(2013, 10, 21, 10, 40), "");
//        cm.addFutureMeeting(cm.getContacts(1, 2, 3), new GregorianCalendar(2019, 5, 11, 11, 30));
//        cm.addNewPastMeeting(cm.getContacts(1, 3, 4), new GregorianCalendar(2012, 4, 14, 11, 40), "");
//        System.out.println(cm.getContacts(5).stream().findFirst().get().getName());
        cm.flush();
    }
}
