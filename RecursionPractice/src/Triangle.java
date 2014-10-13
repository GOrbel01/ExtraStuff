/**
 * Created by Cloud on 13/10/2014.
 */
public class Triangle {
    private int width;

    public Triangle(int aWidth)
    {
        width = aWidth;
    }

    public int getArea()
    {
        if (width == 1)
        {
            return 1;
        }
        else if (width <= 0)
        {
            return 0;
        }
        Triangle smallerTriangle = new Triangle(width - 1);
        int smallerArea = smallerTriangle.getArea();
        return smallerArea + width;
    }

    public static void main(String[] args)
    {
        Triangle theT = new Triangle(10);
        int area = theT.getArea();
        System.out.println("Area: " + area);

    }

}
