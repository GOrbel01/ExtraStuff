import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by Squall on 02/01/2015.
 */
public class TestFuturama {

    public static void main(String[] args)
    {
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
        Stream<FuturamaCharacter> sortedFuturamaStream = futuramaCharacters.stream().sorted();
        sortedFuturamaStream.forEach((n) -> System.out.println(n.getName() + " "));
    }
}
