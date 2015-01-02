import java.util.Arrays;

/**
 * Created by Squall on 02/01/2015.
 */
public class FuturamaCharacter implements Comparable<FuturamaCharacter> {

    private String name;
    private int age;

    public FuturamaCharacter(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public int compareTo(FuturamaCharacter fChar)
    {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        System.out.println(this.name.compareTo(fChar.name));

        if (this == fChar)
        {
            return EQUAL;
        }
        if (this.name.compareTo(fChar.name) < 0)
        {
            return BEFORE;
        }
        if (this.name.compareTo(fChar.name) > 0)
        {
            return AFTER;
        }
        else
        {
            return EQUAL;
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof FuturamaCharacter))
        {
            return false;
        }
        FuturamaCharacter fChar = (FuturamaCharacter) obj;
        if (this.name.equals(fChar.name))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[]{new String(name), new Integer(age)});
    }
}
