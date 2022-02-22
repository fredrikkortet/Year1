public class RandCard {
    public static void main(String[] args) {
        String[] SUITS = {
                "Clubs", "Diamonds", "Hearts", "Spades"
        };

        String[] RANKS = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.setXscale(0, 2);
        StdDraw.setYscale(0, 2);

        // initialize deck
        int n = SUITS.length * RANKS.length;
        String[] deck = new String[n];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length * i + j] = RANKS[i] + "_of_" + SUITS[j];
            }
        }

        // shuffle
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        double X = 0.1;
        double Y = 0.9;
        for (int i = 0; i < n; i++) {

            StdDraw.picture(X, Y, deck[i] + ".png", 0.1, 1.4 * 0.1);

            if (X <= 2) {
                X = X + 0.1;
            } else {
                Y = Y - 0.2;
                X = 0.1;
            }


        }


    }

}