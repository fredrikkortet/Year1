//Benjamin Fredrik Rouhollah have programming this.
import java.util.*;
import java.awt.*;

public class Glass implements ImageFilter
{
    public String getMenuName()
    {
        return "Make it glass";
    }

    public void apply(Picture src, Picture dest)
    {
        for (int x = 0; x < src.width(); x++)
        {
            for (int y = 0; y < src.height(); y++)
            {
                Color old_color = src.get(x, y);
                int ykord;
                int xkord;

                int xNeighbour = (src.width() + x + rand(-5, 5)) % src.width();

                int yNeighbour = (src.height() + y + rand(-5, 5)) % src.height();

                if (xNeighbour <= 0)
                {
                    xNeighbour = 1;
                } else if (xNeighbour >= src.width())
                {
                    xNeighbour = src.width()-1;
                } else if (yNeighbour <= 0)
                {
                    yNeighbour = 1;
                } else if (yNeighbour >= src.height())
                {
                    yNeighbour = src.height()-1;
                }
                Color new_color = src.get(xNeighbour, yNeighbour);
                dest.set(x, y, new_color);
            }
        }
    }

    private static int rand(int min, int max)
    {
        Random random_value = new Random();
        int value = random_value.nextInt(max - min) + min;
        return value;
    }

}
