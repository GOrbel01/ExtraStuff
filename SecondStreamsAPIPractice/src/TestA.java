import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by Squall on 02/01/2015.
 */
public class TestA {

    public static void main(String[] args)
    {
        TestA testscr = new TestA();
        testscr.launch();
    }

    public void launch()
    {
        Set<String> strings = new HashSet<String>();
        strings.add("Hell");
        strings.add("Dojo");
        strings.add("Mojo");
        strings.add("Sling");
        strings.add("Futurama");
//        Stream<String> myStream = strings.stream();
//        System.out.println(myStream.findAny().get());
//        myStream = strings.stream();
        Stream<String> sortedStrings = strings.stream().sorted();
        sortedStrings.forEach((n) -> System.out.println(n + " "));
    }

}
