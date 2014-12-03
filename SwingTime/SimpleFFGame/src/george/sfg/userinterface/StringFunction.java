package george.sfg.userinterface;

/**
 * Created by Cloud on 03/12/2014.
 */
public final class StringFunction {

    public static String splitFunction(String buttonName)
    {
        String[] splitResult = buttonName.split(" ");
        String result = "";
        int spaces = splitResult.length - 1;
        for (int i = 1; i < splitResult.length; i++)
        {
            if (i < spaces)
            {
                result = result + splitResult[i] + " ";
            }
            else
            {
                result = result + splitResult[i];
            }
        }
        return result;
    }

}
