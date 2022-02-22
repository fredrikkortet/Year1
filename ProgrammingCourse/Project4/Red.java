//Benjamin Fredrik Rouhollah have programming this.
import java.awt.*;
public class Red implements ImageFilter
{
    public String getMenuName()
    {
        return ("Make it red");
    }

    public void apply(Picture src, Picture dest)
    {
        for (int x = 0; x < src.width(); x++)
        {
            for (int y = 0; y < src.height(); y++)
            {
                Color old_color = src.get(x, y);

                Color new_color = new Color(old_color.getRed(), 0, 0);
                dest.set(x,y,new_color);



            }
        }

    }
}
