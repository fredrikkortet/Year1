public class white {

    public static void main(String[] args) {
        String DelStat = args[0] + ".txt";
        In filename = new In(DelStat);
        double xMax;
        double xMin;
        double yMax;
        double yMin;
        int parts;

        String states;
        String initials; //nickname for states

        xMin = filename.readDouble(); //reads the max/in x/y koordiante values
        yMin = filename.readDouble();
        xMax = filename.readDouble();
        yMax = filename.readDouble();
        StdDraw.setCanvasSize(1000, 800);
        StdDraw.setXscale(xMin, xMax);
        StdDraw.setYscale(yMin, yMax);
        parts = filename.readInt();

        for (int i = 0; i < parts; i++) {
            filename.readLine();
            filename.readLine();
            states = filename.readLine();
            states = states.replaceAll(" ", "");
            initials = filename.readString();
            Polygon state_draw = new Polygon(filename);
            state_draw.draw();
        }

    }
}
