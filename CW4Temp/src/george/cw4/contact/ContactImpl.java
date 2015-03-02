package george.cw4.contact;

/**
 * Created by Cloud on 22/11/2014.
 */
public class ContactImpl implements Contact {

    private int id;
    private String name;
    private String notes;

    private static final int SIZE = 16;
    private static int COUNT = 0;

    public ContactImpl(String name)
    {
        COUNT++;
        this.id = COUNT;
        this.name = name;
        this.notes = "";
    }

    /**
     * @see george.cw4.contact.Contact#getId()
     */
    public int getId()
    {
        return id;
    }

    /**
     * @see george.cw4.contact.Contact#getName()
     */
    public String getName()
    {
        return name;
    }

    /**
     * @see george.cw4.contact.Contact#getNotes()
     */
    public String getNotes()
    {
        return notes;
    }

    /**
     * @see george.cw4.contact.Contact#addNotes(String note)
     */
    public void addNotes(String note)
    {
        this.notes = note;
    }

    /**
     * Required for testing. Resets Count variable.
     * Note: FOR TEST's ONLY!
     */
    public static void resetCount()
    {
        COUNT = 0;
    }

    @Override
    public boolean equals(Object c)
    {
        if (!(c instanceof Contact))
        {
            return false;
        }
        Contact contact = (Contact) c;
        return (this.id == contact.getId());
    }

    @Override
    public int hashCode()
    {
        return computeHash(id);
    }

    /**
     * Calculates the hash value for an id
     * and returns it.
     *
     * @param key Input id of the contact
     * @return the calculated hash value
     */
    private int computeHash(Integer key) {
        int hash = key.hashCode() % SIZE;
        return hash;
    }

    @Override
    public String toString()
    {
        return ("Contact ID:" + id + " Contact Name:" + name + " Contact Notes:" + notes);
    }
}
