import java.awt.Color;

public class Votecolour
{
    private String[] number = new String[4];
    private int r;
    private int g;
    private int b;
    private Color newColor;
    private String state;

    public Votecolour(In in)
    {


        String temp = in.readLine();
        temp = temp.replaceAll(" ", "");
        number = temp.split(",");
        state = number[0];
        r = Integer.parseInt(number[1]);
        b = Integer.parseInt(number[2]);
        g = Integer.parseInt(number[3]);


    }

    public String getRegion()
    {
        return state;
    }

    public Color getColor()
    {

        float A = r + g + b;
        newColor = new Color(r / A, g / A, b / A);
        return newColor;
    }
}
