/**
 * Created by Cloud on 01/12/2014.
 */
public class ListOperation {
    public static void main(String[] args)
    {
        ListOperation newLO = new ListOperation();
        newLO.launch();
    }

    public void launch()
    {
        FighterList<Fighter> fList = new FighterList<Fighter>();
        FighterList<RageFighter> rList = new FighterList<RageFighter>();
        Fighter newFighter = new RageFighterImpl();
        fList.getList().add(newFighter);
        fList.getList().get(0).getName();
        Fighter fighter = new RageFighterImpl();

    }
}
