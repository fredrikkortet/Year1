public interface ScalableFilter {

    String getMenuName();
    void apply(Picture src, Picture dest, double scale);

}