import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Cloud on 14/12/2014.
 */
public class HashSetTest {

    public static void main(String[] args)
    {
        Set<Integer> iSet = new HashSet<Integer>();
        Set<Node> nSet = new HashSet<Node>();

        iSet.add(24);
        iSet.add(22);
        iSet.add(25);
        iSet.add(21);
        iSet.add(25);

        System.out.println(iSet.toString());

        nSet.add(new Node("Final", 2));
        nSet.add(new Node("Final", 2));
        nSet.add(new Node("Final", 2));
        nSet.add(new Node("Final", 2));
        nSet.add(new Node("Final", 2));
        nSet.add(new Node("Final", 2));
        nSet.add(new Node("Total", 2));
        nSet.add(new Node("Final", 3));

        printSet(nSet);
    }

    public static void printSet(Set aSet)
    {
        Object[] nArray = aSet.toArray();
        for (int i = 0; i < aSet.size(); i++)
        {
            Node temp = (Node) nArray[i];
            System.out.println(temp.getName());
            System.out.println(temp.getVal());
        }
    }
}
