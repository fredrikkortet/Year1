//Benjamin Fredrik Rouhollah have programming this.
import java.awt.*;

public class FlipX implements ImageFilter
{
    public String getMenuName()
    {
        return "Flip X-axis";
    }

    public void apply(Picture src, Picture dest)
    {

        for (int y = 0; y < src.height(); y++)
            for (int x = 0; x < src.width() / 2; x++)
            {
                Color temp1 = src.get(x, y);
                Color temp2 = src.get(src.width() - x - 1, y);
                dest.set(x, y, temp2);
                dest.set(src.width() - x - 1, y, temp1);
            }
    }

}
