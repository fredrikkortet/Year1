public interface ImageFilter
{

    String getMenuName();

    void apply(Picture src, Picture dest);

}