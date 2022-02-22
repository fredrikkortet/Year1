import java.awt.Color;

public class RedBlue
{

    public static void main(String[] args)
    {
        String DelStat = args[0] + ".txt";
        String DelStatfarg = args[0] + args[1] + ".txt";
        In filename_states = new In(DelStat);
        In filename_color = new In(DelStatfarg);
        double xMax;
        double xMin;
        double yMax;
        double yMin;
        int parts;
        Color paintState;
        String states;
        String initials; //nickname for states
        String temp;

        xMin = filename_states.readDouble(); //reads the max/in x/y koordiante values
        yMin = filename_states.readDouble();
        xMax = filename_states.readDouble();
        yMax = filename_states.readDouble();
        StdDraw.setCanvasSize(1000, 800);
        StdDraw.setXscale(xMin, xMax);
        StdDraw.setYscale(yMin, yMax);
        parts = filename_states.readInt();
        filename_color.readLine();
        temp = " ";
        for (int i = 0; i < parts; i++)
        {
            filename_states.readLine();
            filename_states.readLine();
            states = filename_states.readLine();
            states = states.replaceAll(" ", "");
            initials = filename_states.readString();
            Polygon state_draw = new Polygon(filename_states);

            if (temp.equals(" "))
            {
                Votecolour farger = new Votecolour(filename_color);
                StdDraw.setPenColor(farger.getColor());
                temp = states;
            } else if (!temp.equals(states))
            {
                Votecolour farger = new Votecolour(filename_color);
                StdDraw.setPenColor(farger.getColor());
                temp = farger.getRegion();
                while (!temp.equals(states))
                {  // provided everything is in order and in alphabetical order.
                    farger = new Votecolour(filename_color);
                    StdDraw.setPenColor(farger.getColor());
                    temp = farger.getRegion();
                }
            }

            System.out.println(temp + " " + states);
            state_draw.filleddraw();
        }

    }
}
