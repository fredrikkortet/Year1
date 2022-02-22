public class BallAn {
    public static void main(String[] args) {

        StdDraw.enableDoubleBuffering();
        double y = 0.0;
        double x = 0.0;
        double yspeed = 0.5;
        double xspeed = 0.2;

        StdDraw.setYscale(-10, 10);
        StdDraw.setXscale(-10, 10);


        while (true) {

            StdDraw.filledCircle(x, y, 0.25);
            StdDraw.show();
            StdDraw.pause(10);
            StdDraw.clear();

            if (10 <= x || x <= -10) {
                xspeed = (-1) * xspeed;
            }

            if (10 <= y || y <= -10) {
                yspeed = (-1) * yspeed;
            }

            x = x + xspeed;
            y = y + yspeed;

        }

    }
}
