public class CCard {
    public static void main(String[] args) {

        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
        String[] value = {"hearts", "diamonds", "clubs", "spades"};
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.setYscale(0, 1.4);
        double X = 0.1;
        double Y = 1.3;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) { //for looparna kör igenom alla kort
                StdDraw.picture(X, Y, ranks[j] + "_of_" + value[i] + ".png", 0.1, 1.4 * 0.1);
                Y = Y - 0.1; // flyttar i y led med 0.1
            }
            Y = 1.3; // återställer vart korten ska börja
            X = X + 0.2; // flyttar i x led

        }


    }

}