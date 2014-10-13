/**
 * Created by Cloud on 13/10/2014.
 */
public class Square {
    private int width;

    public Square(int w)
    {
        width = w;
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
        Square smallerSquare = new Square(width-1);
        int smallerArea = smallerSquare.getArea();
        return smallerArea + (width * 2) - 1;
    }

    public static void main(String[] args)
    {
        Square aSquare = new Square(4);
        int area = aSquare.getArea();
        System.out.println("Area of Square: " + area);
    }
}
