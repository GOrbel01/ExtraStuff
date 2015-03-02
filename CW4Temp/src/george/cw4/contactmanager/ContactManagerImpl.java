package george.cw4.contactmanager;

import george.cw4.contact.Contact;
import george.cw4.contact.ContactImpl;
import george.cw4.contact.ContactStringsWrapper;
import george.cw4.meeting.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Cloud on 22/12/2014.
 */
public class ContactManagerImpl implements ContactManager {

    private List<PastMeeting> pastMeetingsList;
    private List<Meeting> futureMeetingsList;

    private Set<Contact> contacts;

    private ContactStringsWrapper contactWrapper = new ContactStringsWrapper();
    private MeetingStringsWrapper meetingWrapper = new MeetingStringsWrapper();

    public ContactManagerImpl()
    {
        //Going to have to do checks etc for File here.

        futureMeetingsList = new ArrayList<Meeting>();
        pastMeetingsList = new ArrayList<PastMeeting>();
        contacts = new HashSet<Contact>();
        if (fileExists())
        {
            try {
                readXML();
            }
            catch (SAXException ex)
            {
                System.out.println("SAX Exception Occured");
                ex.printStackTrace();
            }
            catch (IOException ex)
            {
                System.out.println("Invalid IO");
                ex.printStackTrace();
            }
            catch (ParserConfigurationException ex)
            {
                System.out.println("Problem with Parser Config");
                ex.printStackTrace();
            }
            contactWrapper.printLists();
            setupLists();
        }
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#addFutureMeeting(Set contacts, Calendar date)
     */
    public int addFutureMeeting(Set<Contact> contacts, Calendar date)
    {
        if (date.compareTo(DateUtil.currentDate()) == -1)
        {
            throw new IllegalArgumentException("Date Entered for Future Meeting is in the Past.");
        }
        else if (!(isKnownID(contacts)))
        {
            throw new IllegalArgumentException("Invalid or Unknown Contacts Entered.");
        }
        else
        {
            Meeting tempMeeting = new FutureMeetingImpl(date, contacts);
            futureMeetingsList.add(tempMeeting);
            return tempMeeting.getId();
        }
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#addFutureMeeting(Set contacts, Calendar date)
     * Note: This version of the method is used only for startup. Hence it is private
     */
    private int addFutureMeeting(int id, Set<Contact> contacts, Calendar date)
    {
        if (date.compareTo(DateUtil.currentDate()) == -1)
        {
            throw new IllegalArgumentException("Date Entered for Future Meeting is in the Past.");
        }
        else if (!(isKnownID(contacts)))
        {
            throw new IllegalArgumentException("Invalid or Unknown Contacts Entered.");
        }
        Meeting tempMeeting = new FutureMeetingImpl(date, contacts, id);
        futureMeetingsList.add(tempMeeting);
        AbstractMeeting.incrementCount();
        return tempMeeting.getId();
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#getPastMeeting(int id)
     */
    public PastMeeting getPastMeeting(int id)
    {
        if (getMeetingType(id) == 1)
        {
            throw new IllegalArgumentException("Future Meeting ID Given, Past ID Expected");
        }
        else if (getMeetingType(id) == -1)
        {
            return null;
        }
        else
        {
            return pastMeetingsList.stream().filter((m) -> m.getId() == id).findFirst().get();
        }
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#getFutureMeeting(int id)
     */
    public FutureMeeting getFutureMeeting(int id)
    {
        if (getMeetingType(id) == 0)
        {
            throw new IllegalArgumentException("Past Meeting ID Given, Future ID Expected");
        }
        else if (getMeetingType(id) == -1)
        {
            return null;
        }
        else
        {
            return (FutureMeeting) futureMeetingsList.stream().filter((m) -> m.getId() == id).findFirst().get();
        }
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#getMeeting(int id)
     */
    public Meeting getMeeting(int id)
    {
        if (getMeetingType(id) == 0)
        {
            return pastMeetingsList.stream().filter((m) -> m.getId() == id).findFirst().get();
        }
        else if (getMeetingType(id) == 1)
        {
            return futureMeetingsList.stream().filter((m) -> m.getId() == id).findFirst().get();
        }
        else
        {
            return null;
        }
    }

     /**
     * @see george.cw4.contactmanager.ContactManager#getFutureMeetingList(Contact contact)
     */
    public List<Meeting> getFutureMeetingList(Contact contact)
    {
        if (!hasContact(futureMeetingsList, contact))
        {
            throw new IllegalArgumentException("Contact Not Found.");
        }
        else
        {
            List<Meeting> futureMeetingsTemp = new ArrayList<Meeting>();
            for (int i = 0; i < futureMeetingsList.size(); i++)
            {
                if (futureMeetingsList.get(i).getContacts().contains(contact))
                {
                    futureMeetingsTemp.add(futureMeetingsList.get(i));
                }
            }
            return futureMeetingsTemp.stream().sorted().collect(Collectors.toList());
        }
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#getFutureMeetingList(Calendar date)
     */
    public List<Meeting> getFutureMeetingList(Calendar date)
    {
        if (DateUtil.currentDate().compareTo(date) > 0)
        {
            List<Meeting> pastMeetingsTemp = new ArrayList<Meeting>();
            for (int i = 0; i < pastMeetingsList.size(); i++)
            {
                if (matchesDate(date, pastMeetingsList.get(i).getDate()))
                {
                    pastMeetingsTemp.add(pastMeetingsList.get(i));
                }
            }
            return pastMeetingsTemp.stream().sorted().collect(Collectors.toList());
        }
        else
        {
            List<Meeting> futureMeetingsTemp = new ArrayList<Meeting>();
            for (int i = 0; i < futureMeetingsList.size(); i++)
            {
                if (matchesDate(date, futureMeetingsList.get(i).getDate()))
                {
                    futureMeetingsTemp.add(futureMeetingsList.get(i));
                }
            }
            return futureMeetingsTemp.stream().sorted().collect(Collectors.toList());
        }
    }

    /**
     * @param d1 The Date on which lists are being searched for
     * @param d2 The actual date found in the list
     * @return true if they match, false if not.
     */
    private boolean matchesDate(Calendar d1, Calendar d2)
    {
        return (d2.get(Calendar.YEAR) == d1.get(Calendar.YEAR) &&
        d2.get(Calendar.MONTH) == d1.get(Calendar.MONTH) &&
        d2.get(Calendar.DAY_OF_MONTH) == d1.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#getPastMeetingList(Contact contact)
     */
    public List<PastMeeting> getPastMeetingList(Contact contact)
    {
        if (!(contacts.contains(contact)))
        {
            throw new IllegalArgumentException("Invalid Contact for getPastMeetingList");
        }
        else
        {
            List<PastMeeting> pastMeetingsWithContactList = new ArrayList<PastMeeting>();
            for (int i = 0; i < pastMeetingsList.size(); i++)
            {
                if (pastMeetingsList.get(i).getContacts().contains(contact))
                {
                    pastMeetingsWithContactList.add(pastMeetingsList.get(i));
                }
            }
            return pastMeetingsWithContactList.stream().sorted().collect(Collectors.toList());
        }
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#addNewPastMeeting(Set contacts, Calendar date, String text)
     */
    public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text)
    {
        if (contacts == null || date == null || text == null)
        {
            throw new NullPointerException("Null Argument for addNewPastMeeting");
        }
        else if (contacts.isEmpty())
        {
            throw new IllegalArgumentException("Contact List is Empty");
        }
        else if (!(isKnownID(contacts)))
        {
            throw new IllegalArgumentException("Contact List contains an invalid contact.");
        }
        else
        {
            PastMeeting newPastMeeting = new PastMeetingImpl(date, contacts, text);
            pastMeetingsList.add(newPastMeeting);
        }
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#addNewPastMeeting(Set contacts, Calendar date, String text)
     */
    public void addNewPastMeeting(int id, Set<Contact> contacts, Calendar date, String text)
    {
        if (contacts == null || date == null || text == null)
        {
            throw new NullPointerException("Null Argument for addNewPastMeeting");
        }
        else if (contacts.isEmpty())
        {
            throw new IllegalArgumentException("Contact List is Empty");
        }
        else if (!(isKnownID(contacts)))
        {
            throw new IllegalArgumentException("Contact List contains an invalid contact.");
        }
        else
        {
            PastMeeting newPastMeeting = new PastMeetingImpl(date, contacts, text, id);
            AbstractMeeting.incrementCount();
            pastMeetingsList.add(newPastMeeting);
        }
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#addMeetingNotes(int id, String text)
     */
    public void addMeetingNotes(int id, String text)
    {
        if (getMeetingType(id) == -1)
        {
            throw new IllegalArgumentException("Attempted to add notes to a non-existent Meeting");
        }
        else if (text == null)
        {
            throw new NullPointerException("Null Text Entered for Meeting Notes");
        }
        else if (getMeeting(id).getDate().compareTo(DateUtil.currentDate()) == 1)
        {
            throw new IllegalStateException("Meeting is set for the future meaning no notes can be added.");
        }
        else
        {
            if (getMeetingType(id) == 0)
            {
                for (int i = 0; i < pastMeetingsList.size(); i++)
                {
                    if (pastMeetingsList.get(i).getId() == id)
                    {
                        PastMeeting pastMeeting = new PastMeetingImpl(getPastMeeting(id), text, id);
                        pastMeetingsList.remove(i);
                        pastMeetingsList.add(i, pastMeeting);
                    }
                }
            }
            else
            {
                for (int i = 0; i < futureMeetingsList.size(); i++)
                {
                    if (futureMeetingsList.get(i).getId() == id)
                    {
                        PastMeeting futureToPastMeeting = new PastMeetingImpl(futureMeetingsList.get(i), text, id);
                        futureMeetingsList.remove(i);
                        pastMeetingsList.add(futureToPastMeeting);
                    }
                }
            }
        }
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#addNewContact(String name, String notes)
     */
    public void addNewContact(String name, String notes)
    {
        if (name == null)
        {
            throw new NullPointerException("Null Name Detected.");
        }
        else if (notes == null)
        {
            throw new NullPointerException("Null Notes Detected");
        }
        else
        {
            Contact tempContact = new ContactImpl(name);
            tempContact.addNotes(notes);
            contacts.add(tempContact);
        }
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#getContacts(int... ids)
     */
    public Set<Contact> getContacts(int... ids)
    {
        if (!isKnownID(ids))
        {
            throw new IllegalArgumentException("A Contact requested has not yet been added to your Contacts List");
        }
        else
        {
            //Probably a better way to do this, but should be more reliable than with Arrays.
            Stream<Contact> contactStream = contacts.stream();
            Set<Contact> foundContacts = new HashSet<Contact>();
            contactStream.forEach((contact) -> {
                for (int i = 0; i < ids.length; i++)
                {
                    if (contact.getId() == ids[i])
                    {
                        foundContacts.add(contact);
                    }
                }
            });

            return foundContacts;
        }
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#getContacts(String name)
     */
    public Set<Contact> getContacts(String name)
    {
        if (name == null)
        {
            throw new NullPointerException("Null Value Argument Entered for Name.");
        }
        else
        {
            Stream<Contact> contactStream = contacts.stream().filter((c) -> c.getName().contains(name));
            Set<Contact> foundContacts = new HashSet<Contact>();
            contactStream.forEach((contact) -> foundContacts.add(contact));
            return foundContacts;
        }
    }

    private Contact getContact(String name)
    {
        if (name == null)
        {
            throw new NullPointerException("Null Name Entered");
        }
        else
        {
            return contacts.stream().filter((c) -> c.getName().equals(name)).findFirst().get();
        }
    }

    /**
     * @see george.cw4.contactmanager.ContactManager#flush()
     */
    public void flush()
    {
        writeXML();
    }

    /**
     * @param numbers The Contact ids entered
     * @return True if the id is valid, false otherwise
     */
    private boolean isKnownID(int[] numbers)
    {
        boolean isKnown = true;
        List<Integer> contactIDs = new ArrayList<Integer>();
        Stream<Contact> contactStream = contacts.stream();
        contactStream.forEach((contact) -> {
            contactIDs.add(contact.getId());
            });

        for (int i = 0; i < numbers.length; i++)
        {
            if (!(contactIDs.contains(numbers[i])))
            {
                isKnown = false;
            }
        }
        return isKnown;
    }

    /**
     * @param c The Set to Evaluate for valid contacts
     * @return True if valid, false otherwise
     */
    private boolean isKnownID(Set<Contact> c)
    {
        boolean isKnown = true;
        List<Contact> contactsForMeeting = c.stream().collect(Collectors.toList());
        for (int i = 0; i < contactsForMeeting.size(); i++)
        {
            if (!(contacts.contains(contactsForMeeting.get(i))))
            {
                isKnown = false;
            }
        }
        return isKnown;
    }

    /**
     * Method to evaluate list of meetings for existence of a contact
     *
     * @param list - The list of FutureMeetings
     * @param contact - The contact being checked
     * @return True if contact exists, false otherwise
     */
    private boolean hasContact(List<Meeting> list, Contact contact)
    {
        boolean hasContact = false;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getContacts().contains(contact))
            {
                hasContact = true;
            }
        }
        return hasContact;
    }

    /**
     * @param id The id of the meeting being searched
     * @return 1 if future 0 if past, -1 if Not Exist
     */
    private int getMeetingType(int id)
    {
        int type;
        List<Integer> futureIDs = new ArrayList<Integer>();
        List<Integer> pastIDs = new ArrayList<Integer>();
        futureMeetingsList.stream().forEach((m) -> futureIDs.add(m.getId()));
        pastMeetingsList.stream().forEach((m) -> pastIDs.add(m.getId()));

        if (futureIDs.contains(id) && (!(pastIDs.contains(id))))
        {
            type = 1;
        }
        else if (pastIDs.contains(id) && (!(futureIDs.contains(id))))
        {
            type = 0;
        }
        else
        {
            type = -1;
        }
        return type;
    }

    private void writeXML()
    {
        try
        {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Main Element
            Document xmlDoc = docBuilder.newDocument();

            Element root = xmlDoc.createElement("CompanyManager");
            xmlDoc.appendChild(root);
            Element contactsElement = xmlDoc.createElement("Contacts");
            root.appendChild(contactsElement);
            for (int i = 0; i < contacts.size(); i++)
            {
                Element contact = xmlDoc.createElement("ContactDetails");
                contactsElement.appendChild(contact);
                Element name = xmlDoc.createElement("Name");
                contact.appendChild(name);
                Element notes = xmlDoc.createElement("Notes");
                contact.appendChild(notes);
                List<Contact> contactsList = contacts.stream().collect(Collectors.toList());
                String[] fullName = contactsList.get(i).getName().split(" ");
                String finalName = "";
                for (int nameCount = 0; nameCount < fullName.length; nameCount++)
                {
                    if (nameCount == fullName.length-1)
                    {
                        finalName = finalName + fullName[nameCount];
                    }
                    else
                    {
                        finalName = finalName + fullName[nameCount] + " ";
                    }
                }
                name.appendChild(xmlDoc.createTextNode(finalName));
                notes.appendChild(xmlDoc.createTextNode(contactsList.get(i).getNotes()));
            }
            Element pastMeetingsElement = xmlDoc.createElement("PastMeetings");
            root.appendChild(pastMeetingsElement);
            for (int i = 0; i < pastMeetingsList.size(); i++)
            {
                Element meeting = xmlDoc.createElement("MeetingDetails");
                pastMeetingsElement.appendChild(meeting);
                Attr mID = xmlDoc.createAttribute("ID");
                mID.setValue("" + pastMeetingsList.get(i).getId());
                meeting.setAttributeNode(mID);

                Element contactsAttended = xmlDoc.createElement("ContactsAttended");
                for (Contact c : pastMeetingsList.get(i).getContacts())
                {
                    String[] fullName = c.getName().split(" ");
                    String firstName = fullName[0];
                    String secondName = fullName[1];
                    if (fullName.length == 3)
                    {
                        String thirdName = fullName[2];
                        contactsAttended.appendChild(xmlDoc.createTextNode(firstName + "_" + secondName + "_" + thirdName + " "));
                    }
                    else
                    {
                        contactsAttended.appendChild(xmlDoc.createTextNode(firstName + "_" + secondName + " "));
                    }
                    meeting.appendChild(contactsAttended);
                }

                Element dateOfMeeting = xmlDoc.createElement("MeetingDate");
                dateOfMeeting.appendChild(xmlDoc.createTextNode(DateUtil.printDatePretty(pastMeetingsList.get(i).getDate())));
                meeting.appendChild(dateOfMeeting);
                Element meetingNotes = xmlDoc.createElement("MeetingNotes");
                meetingNotes.appendChild(xmlDoc.createTextNode(pastMeetingsList.get(i).getNotes()));
                meeting.appendChild(meetingNotes);
            }
            Element futureMeetingsElement = xmlDoc.createElement("FutureMeetings");
            root.appendChild(futureMeetingsElement);
            for (int i = 0; i < futureMeetingsList.size(); i++)
            {
                Element meeting = xmlDoc.createElement("MeetingDetails");
                futureMeetingsElement.appendChild(meeting);
                Attr mID = xmlDoc.createAttribute("ID");
                mID.setValue("" + futureMeetingsList.get(i).getId());
                meeting.setAttributeNode(mID);

                Element contactsAttended = xmlDoc.createElement("ContactsAttending");
                for (Contact c : futureMeetingsList.get(i).getContacts())
                {
                    String[] fullName = c.getName().split(" ");
                    String firstName = fullName[0];
                    String secondName = fullName[1];
                    if (fullName.length == 3)
                    {
                        String thirdName = fullName[2];
                        contactsAttended.appendChild(xmlDoc.createTextNode(firstName + "_" + secondName + "_" + thirdName + " "));
                    }
                    else
                    {
                        contactsAttended.appendChild(xmlDoc.createTextNode(firstName + "_" + secondName + " "));
                    }
                    meeting.appendChild(contactsAttended);
                }

                Element dateOfMeeting = xmlDoc.createElement("ScheduledMeetingDate");
                dateOfMeeting.appendChild(xmlDoc.createTextNode(DateUtil.printDatePretty(futureMeetingsList.get(i).getDate())));
                meeting.appendChild(dateOfMeeting);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(xmlDoc);
            File contactManager = new File("Contacts.txt");
            StreamResult result = new StreamResult(contactManager);

            transformer.transform(source, result);

            System.out.println("File Saved to: " + contactManager.getAbsolutePath());
        }
        catch (ParserConfigurationException ex)
        {
            ex.printStackTrace();
        }
        catch (TransformerException ex)
        {
            System.out.println("Transformer Exception");
            ex.printStackTrace();
        }
    }

    private void readXML() throws org.xml.sax.SAXException, ParserConfigurationException, IOException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("Contacts.txt"));
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        System.out.println("Called Read...");
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node typeNode = nodeList.item(i);
                if (typeNode instanceof Element)
                {
                    NodeList detailsNodeList = typeNode.getChildNodes();
                    for (int j = 0; j < detailsNodeList.getLength(); j++)
                    {
                        Node detailsNode = detailsNodeList.item(j);
                        if (detailsNode instanceof Element)
                        {
                            NodeList variablesNodeList = detailsNode.getChildNodes();
                            for (int k = 0; k < variablesNodeList.getLength(); k++)
                            {
                                Node variableNode = variablesNodeList.item(k);
                                if (variableNode instanceof Element)
                                {
                                    if (variableNode.getParentNode().getParentNode().getNodeName().equals("Contacts"))
                                    {
                                        if (variableNode.getNodeName().equals("Name"))
                                        {
                                            String nameString = "";
                                            String[] splitName = variableNode.getTextContent().split("_");
                                            for (int namesCount = 0; namesCount < splitName.length; namesCount++)
                                            {
                                                if (namesCount == splitName.length-1)
                                                {
                                                    nameString = nameString + splitName[namesCount];
                                                }
                                                else
                                                {
                                                    nameString = nameString + splitName[namesCount];
                                                }
                                            }
                                            contactWrapper.getNamesList().add(nameString);
                                        }
                                        else if (variableNode.getNodeName().equals("Notes"))
                                        {
                                            String noteString;
                                            noteString = variableNode.getTextContent();
                                            if (noteString.isEmpty())
                                            {
                                                noteString = "";
                                            }
                                            contactWrapper.getNotesList().add(noteString);
                                        }
                                    }
                                    else if (variableNode.getParentNode().getParentNode().getNodeName().equals("PastMeetings"))
                                    {
                                        if (!(meetingWrapper.getIDs().contains(Integer.parseInt(((Element) detailsNode).getAttribute("ID")))))
                                        {
                                            meetingWrapper.getIDs().add(Integer.parseInt(((Element) detailsNode).getAttribute("ID")));
                                        }
                                        if (variableNode.getNodeName().equals("ContactsAttended"))
                                        {
                                            meetingWrapper.getAttendeesList().add(variableNode.getTextContent());
                                        }
                                        else if (variableNode.getNodeName().equals("MeetingDate"))
                                        {
                                            meetingWrapper.getDatesList().add(variableNode.getTextContent());
                                        }
                                        else if (variableNode.getNodeName().equals("MeetingNotes"))
                                        {
                                            meetingWrapper.getNotes().add(variableNode.getTextContent());
                                        }
                                    }
                                    else if (variableNode.getParentNode().getParentNode().getNodeName().equals("FutureMeetings"))
                                    {
                                        if (!(meetingWrapper.getIDs().contains(Integer.parseInt(((Element) detailsNode).getAttribute("ID")))))
                                        {
                                            meetingWrapper.getIDs().add(Integer.parseInt(((Element) detailsNode).getAttribute("ID")));
                                        }
                                        if (variableNode.getNodeName().equals("ContactsAttending"))
                                        {
                                            meetingWrapper.getAttendeesList().add(variableNode.getTextContent());
                                        }
                                        else if (variableNode.getNodeName().equals("ScheduledMeetingDate"))
                                        {
                                            meetingWrapper.getDatesList().add(variableNode.getTextContent());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }

    /**
     * Used for adding Data to Lists on Startup if xml is Found. Called by Constructor
     */
    private void setupLists()
    {
        System.out.println("MEETING WRAPPER PRINT");
        for (int i = 0; i < contactWrapper.getNamesList().size(); i++)
        {
            addNewContact(contactWrapper.getNamesList().get(i), contactWrapper.getNotesList().get(i));
        }
        parseAndSetMeetingsLists();
    }

    /**
     * Check for Contacts.txt file
     * @return True if file found. False otherwise
     */
    private boolean fileExists()
    {
        File contactFile = new File("Contacts.txt");
        return (contactFile.exists());
    }

    /**
     * Obtains all data from the Meeting wrapper, parses it, and adds parsed data to lists.
     * Obtains set data for contacts using String methods and getContacts(String name).
     * As the whole name is put into this String this worked.
     */
    private void parseAndSetMeetingsLists()
    {
        int pastCount = 0;
        for (int i = 0; i < meetingWrapper.getAttendeesList().size(); i++)
        {
            Set<Contact> contactsForMeeting = new HashSet<Contact>();
            String notes = "";
            String[] timeAndDateSplit = meetingWrapper.getDatesList().get(i).split(" ");
            String[] dateSplit = timeAndDateSplit[0].split("-");
            String[] timeSplit = timeAndDateSplit[1].split(":");
            GregorianCalendar date = new GregorianCalendar(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2])
            , Integer.parseInt(timeSplit[0]), Integer.parseInt(timeSplit[1]));
            System.out.println(DateUtil.printDatePretty(date));
            String[] allNames = meetingWrapper.getAttendeesList().get(i).split(" ");
            for (int j = 0; j < allNames.length; j++)
            {
                String name = allNames[j].replaceAll("_", " ");
                contactsForMeeting.add(getContact(name));
            }
            if (date.compareTo(DateUtil.currentDate()) == -1)
            {
                notes = meetingWrapper.getNotes().get(pastCount);
                pastCount++;
                addNewPastMeeting(meetingWrapper.getIDs().get(i), contactsForMeeting, date, notes);
            }
            else
            {
                addFutureMeeting(meetingWrapper.getIDs().get(i), contactsForMeeting, date);
            }
        }
    }
}
