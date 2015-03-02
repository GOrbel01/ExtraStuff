import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Squall on 02/01/2015.
 */
public class TestFuturama {

    public static void main(String[] args) {
        TestFuturama tf = new TestFuturama();
        tf.launch();
    }

    public void launch()
    {
        Set<FuturamaCharacter> futuramaCharacters = new HashSet<FuturamaCharacter>();
        FuturamaCharacter fry = new FuturamaCharacter("Fry", 24);
//        System.out.println(fry.hashCode());
        FuturamaCharacter leela = new FuturamaCharacter("Leela", 24);
//        System.out.println(leela.hashCode());
        futuramaCharacters.add(leela);
        futuramaCharacters.add(fry);
        futuramaCharacters.add(new FuturamaCharacter("Amy", 21));
        futuramaCharacters.add(new FuturamaCharacter("Bender", 6));
        futuramaCharacters.add(new FuturamaCharacter("Zoidberg", 38));
        futuramaCharacters.add(new FuturamaCharacter("Farnsworth", 124));

        Stream<FuturamaCharacter> sortedFuturamaStream = futuramaCharacters.stream().sorted();

        System.out.println("Sorted Stream...");
        sortedFuturamaStream.forEach((n) -> System.out.println(n.getName() + " "));

        System.out.println();
        System.out.println("Filtered Stream...(Displays nothing with F or f in it)");
        Stream<FuturamaCharacter> newSortedFuturamaStream = futuramaCharacters.stream().sorted().filter((n) -> (!(n.getName().contains("F") || n.getName().contains("f"))));
        newSortedFuturamaStream.forEach((n) -> System.out.println(n.getName()));

        System.out.println();
        System.out.println("Reduced Stream...(Combined All Names into one)");
        Optional<FuturamaCharacter> combinedChar = futuramaCharacters.stream().sorted().reduce((a, b) -> {
            String name = a.getName() + b.getName();
            return new FuturamaCharacter(name, 10);
        });
        System.out.println(combinedChar.get().getName());

        System.out.println();
        System.out.println("Mapped Stream with First Letter of Name Removed...");
        Stream<FuturamaCharacter> removedFirstChar = futuramaCharacters.stream().sorted().map((fc) -> {
            FuturamaCharacter fcNew = new FuturamaCharacter(fc.getName().substring(1, fc.getName().length()), 10);
            return fcNew;
        });
        removedFirstChar.forEach((fc) -> System.out.println(fc.getName()));

        System.out.println();
        System.out.println("Added Stream back into a List...");
        Stream<FuturamaCharacter> toCollect = futuramaCharacters.stream().sorted();
        List<FuturamaCharacter> collectedStreamList = toCollect.collect(Collectors.toList());
        System.out.println(collectedStreamList.get(0).getName());

        System.out.println();
        System.out.println("Iterator on Stream...");
        Stream<FuturamaCharacter> toIterate = futuramaCharacters.stream().sorted();
        Iterator<FuturamaCharacter> itr = toIterate.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next().getName());
        }

        System.out.println();
        System.out.println("Sorted By Age");
        Stream<FuturamaCharacter> ageList = futuramaCharacters.stream();
        List<FuturamaCharacter> temp = sortByAge(ageList);
        for (int i = 0; i < temp.size(); i++)
        {
            System.out.println(temp.get(i).getName() + " " + temp.get(i).getAge());
        }
    }

    public List<FuturamaCharacter> sortByAge(Stream<FuturamaCharacter> str)
    {
        Stream<FuturamaCharacter> toSortStream = str.sorted((a, b) -> {
            if (a.getAge() > b.getAge())
                return 1;
            else if (a.getAge() < b.getAge())
            {
                return -1;
            }
            else
            {
                return 0;
            }
        });
        return toSortStream.collect(Collectors.toList());
    }
}
