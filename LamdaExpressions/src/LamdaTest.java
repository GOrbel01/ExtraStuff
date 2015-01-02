/**
 * Created by Cloud on 30/11/2014.
 */
public class LamdaTest {

    public static void main(String[] args)
    {
        IntFunction intFunc;
        int lowerInt = 6;
        intFunc = (n) -> n + 5;

        int upperTest = intFunc.addFive(lowerInt);
        System.out.println(lowerInt + " Became " + upperTest);
    }

}
