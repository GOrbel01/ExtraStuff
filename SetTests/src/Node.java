/**
 * Created by Cloud on 14/12/2014.
 */
public class Node {
    private String name;
    private Integer val;

    public Node(String name, int value)
    {
        this.name = name;
        val = value;
    }

    public int getVal()
    {
        return val;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public boolean equals(Object n)
    {
        if (!(n instanceof Node))
        {
            return false;
        }
        Node node = (Node) n;
        return this.name.equals(node.getName()) && this.val == node.getVal();
    }

    @Override
    public int hashCode()
    {
        return val.hashCode();
    }

}
