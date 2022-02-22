public class Balls {
    public static void main(String[] args) {

        int Number_of_ball = Integer.parseInt(args[0]);
        double xspeed[] = new double[Number_of_ball];
        double yspeed[] = new double[Number_of_ball];
        double xpos[] = new double[Number_of_ball];
        double ypos[] = new double[Number_of_ball];
        StdDraw.setXscale(-1,1);
        StdDraw.setYscale(-1,1);
        StdDraw.enableDoubleBuffering();

        for (int i = 0; i < Number_of_ball; i++) {
            ypos[i] = Math.random();
            xpos[i] = Math.random();
            if ( ypos[i] < 0.5){
                ypos[i] = (-1)*ypos[i];
            }else {
                 xpos[i] = (-1)*xpos[i];
            }
            xspeed[i] = Math.random()/100;
            yspeed[i] = 0.01 - xspeed[i];
            StdDraw.filledCircle(xpos[i],ypos[i],0.05);
            StdDraw.show();
            

        }
        while(true){
            StdDraw.clear();



            for (int j = 0; j < Number_of_ball; j++) {



                if (1 <= xpos[j] || xpos[j] <= -1) {
                    xspeed[j] = (-1) * xspeed[j];
                }

                if (1 <= ypos[j] || ypos[j] <= -1) {
                    yspeed[j] = (-1) * yspeed[j];
                }

                xpos[j] = xpos[j] + xspeed[j];
                ypos[j] = ypos[j] + yspeed[j];

                StdDraw.filledCircle(xpos[j],ypos[j], 0.05);
                StdDraw.show();   



            }
            
        }
    }
}