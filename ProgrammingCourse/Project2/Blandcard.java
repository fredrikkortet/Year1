public class BlandCard {
    public static void main(String[] args) {
        String[] SUITS = {
                "Clubs", "Diamonds", "Hearts", "Spades"
        };

        String[] RANKS = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.setYscale(0, 1.4);

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
        int playcard = 0;
        double X = 0.1;
        double Y = 1.3;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                StdDraw.picture(X, Y, deck[playcard + j] + ".png", 0.1, 1.4 * 0.1);

                //player[i] = player[i] + " " + deck[playcard + j];
                Y = Y - 0.1;

            }
            Y = 1.3; // återställer vart korten ska börja
            X = X + 0.2; // flyttar i x led


            playcard = playcard + 5;
            //System.out.println(player[i]);
        }

    }

}