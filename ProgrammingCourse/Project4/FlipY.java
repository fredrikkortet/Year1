//Benjamin Fredrik Rouhollah have programming this.
import java.awt.*;

public class FlipY implements ImageFilter
{
    public String getMenuName()
    {
        return "Flip Y-axis";
    }

    public void apply(Picture src, Picture dest)
    {

        for (int x = 0; x < src.width(); x++)
            for (int y = 0; y < src.height() / 2; y++)
            {
                Color temp1 = src.get(x, y);
                Color temp2 = src.get(x, src.height() - y - 1);
                dest.set(x, y, temp2);
                dest.set(x, src.height() - y - 1, temp1);
            }
    }

}


