//Benjamin Fredrik Rouhollah have programming this.
import java.awt.Color;

public class BrightnessFilter implements ScalableFilter
{
    public String getMenuName()
    {
        return "Brightness";
    }

    public void apply(Picture src, Picture dest, double scale)
    {


        for (int x = 0; x < src.width(); x++)
        {
            for (int y = 0; y < src.height(); y++)
            {
                Color old_color = src.get(x, y);
                double color_change = scale * 128;
                int red = old_color.getRed() + (int) color_change;
                int green = old_color.getGreen() + (int) color_change;
                int blue = old_color.getBlue() + (int) color_change;
                if (red > 255)
                {
                    red = 255;
                } else if (red < 0)
                {
                    red = 0;
                }
                if (green > 255)
                {
                    green = 255;
                } else if (green < 0)
                {
                    green = 0;
                }
                if (blue > 255)
                {
                    blue = 255;
                } else if (blue < 0)
                {
                    blue = 0;
                }
                Color new_color = new Color(red, green, blue);
                dest.set(x, y, new_color);
            }
        }
    }
}
