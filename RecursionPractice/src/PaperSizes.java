import java.util.Scanner;

/**
 * Created by gorbel01 on 14/10/2014.
 */
public class PaperSizes {
    public String paperTest;
    public int shortSide;
    public int longSide;

    public static void main(String[] args)
    {
        PaperSizes ps = new PaperSizes();
        ps.getPaperSize();

    }

    public boolean isValid(String paperSize)
    {
        int count = 0;
        if (paperSize.charAt(0) == 'A')
        {
            if (!Character.isLetter(paperSize.charAt(1)))
            {
                for (int i = 2; i < paperSize.length(); i++)
                {
                    char c = paperSize.charAt(i);
                    if (c == '0')
                    {
                        count++;
                    }
                }
            }
        }
        if (count >= paperSize.length()-2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void getPaperSize()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What Paper Size do you wish to know the Dimensions of?");
        String paperSize = keyboard.nextLine();
        if (isValid(paperSize))
        {
            paperTest = paperSize;
        }
        else
        {
            getPaperSize();
        }
    }
}
