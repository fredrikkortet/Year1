/*public class RCard {
    public static void main(String[] args) {

        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
        String[] value = {"hearts", "diamonds", "clubs", "spades"};
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.setXscale(0,1.4);
        double X = 0.1;
        double Y = 0.8;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                StdDraw.picture(X, Y, ranks[j] + "_of_" + value[i] + ".png", 0.1, 1.4 * 0.1);
                X = X + 0.1;
            }
            X = 0.1;
            Y = Y - 0.2;
        }


    }
}*/
public class RCard{
    public static void main (String[] args){
        StdDraw.clear(StdDraw.BOOK_RED);
        String [] suits = {
                "clubs", "hearts", "spades", "diamonds"};

        String [] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "jack", "queen", "king", "ace"};


        for(int i = 0; i < 4; i++){
            for (int g = 0; g < 14; g++)

                StdDraw.picture(0.5, 0.5,ranks[g]+ "_of_" + suits[i]+ ".png", 0.1, 1.4*0.1);}
    }
}