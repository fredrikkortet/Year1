//Benjamin Fredrik Rouhollah have programming this.
import java.awt.*;

public class SharpenFilter implements ImageFilter
{
    public String getMenuName()
    {
        return "Sharpen your image";
    }

    public void apply(Picture src, Picture dest)
    {
        int redNew;
        int greenNew;
        int blueNew;
        int x;
        int y;
        Color[] new_color = new Color[4];

        for (x = 1; x < src.width() - 1; x++)
        {
            for (y = 1; y < src.height() - 1; y++)
            {
                Color old_color = src.get(x, y);
                Color old_color0 = src.get(x, y - 1);
                Color old_color1 = src.get(x, y + 1);
                Color old_color2 = src.get(x - 1, y);
                Color old_color3 = src.get(x + 1, y);
                //red color
                int red_color_around = old_color0.getRed() + old_color1.getRed() + old_color2.getRed() + old_color3.getRed();
                redNew = (old_color.getRed() * 5) - red_color_around;
                if (redNew < 0)
                {
                    redNew = 0;
                } else if (redNew > 255)
                {
                    redNew = 255;
                }

                //green color
                int green_color_around = old_color0.getGreen() + old_color1.getGreen() + old_color2.getGreen() + old_color3.getGreen();
                greenNew = old_color.getGreen() * 5 - green_color_around;

                if (greenNew < 0)
                {
                    greenNew = 0;
                } else if (greenNew > 255)
                {
                    greenNew = 255;
                }
                // blue color
                int blue_color_around =  old_color0.getBlue() - old_color1.getBlue() - old_color2.getBlue() - old_color3.getBlue();
                blueNew = (old_color.getBlue() * 5)- blue_color_around;
                if (blueNew < 0)
                {
                    blueNew = 0;
                } else if (blueNew > 255)
                {
                    blueNew = 255;
                }
                Color new_bach = new Color(redNew, greenNew, blueNew);
                dest.set(x, y, new_bach);
            }

        }
    }


}
