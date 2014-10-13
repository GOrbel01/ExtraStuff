/**
 * Created by Cloud on 13/10/2014.
 */
public class RecursionTest {
    public static void main(String[] args)
    {
        System.out.println(fib(5));
    }

    public static int fib(int n)
    {
        if (n == 1 || n == 2)
        {
            return 1;
        }
        else
        {
            int result = fib(n-1) + fib(n-2);
            return result;
        }
    }

}
