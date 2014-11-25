package george.sfg.setup;

/**
 * Created by Cloud on 25/11/2014.
 */
public class TestList {

    public void test()
    {
        CharacterSetup chs = new CharacterSetup();
        System.out.println(chs.getCombatants().get(0).getFighter().getName());
    }

}
