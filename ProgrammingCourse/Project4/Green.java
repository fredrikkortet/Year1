//Benjamin Fredrik Rouhollah have programming this.
import java.awt.*;

public class Green implements ImageFilter
{

    public String getMenuName()
    {
        return ("Make it green");
    }

    public void apply(Picture src, Picture dest)
    {
        for (int x = 0; x < src.width(); x++)
        {
            for (int y = 0; y < src.height(); y++)
            {
                Color old_color = src.get(x, y);

                Color new_color = new Color(0, old_color.getGreen(), 0);
                dest.set(x,y,new_color);



            }
        }


    }


}
