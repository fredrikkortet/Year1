public class PickANumber {
    public static void main(String[] args) {
        int[] kollon = new int[3];
        String[][] rader_och_Column = new String[9][3];
        String[] temp_cards = new String[27];
        int nollan = 0;
        double Y = 1.6;
        double X = 0.50;
        int fav_nummer;
        int column;
        String nummer_temp;

        StdDraw.clear(StdDraw.GRAY);
        StdDraw.setXscale(0, 2);
        StdDraw.setYscale(0, 2);


        String[] SUITS = {
                "clubs", "diamonds", "hearts", "spades"
        };

        String[] RANKS = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };


        // initialize deck
        int n = SUITS.length * RANKS.length;
        String[] deck = new String[n];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length * i + j] = RANKS[i] + "_of_" + SUITS[j] + ".png";
            }
        }

        // shuffle
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                rader_och_Column[i][j] = deck[nollan];
                StdDraw.picture(X, Y, rader_och_Column[i][j], 0.5, 1.4 * 0.5);
                nollan++;
                X = X + 0.5;
            }
            X = 0.5;
            Y = Y - 0.15;
        }
        nollan = 0;

        System.out.println("Välj ditt favorit nummer mellan 1 och 27:");
        fav_nummer = StdIn.readInt();
        kollon = convertTo3(fav_nummer);

        for (int i = 0; i < 3; i++) {
            System.out.println("Välj din column ditt kort är i där 1 står för vänster, 3 står för höger och 2 är mitten.");
            column = StdIn.readInt();

            for (int j = 0; j < 9; j++) {
                nummer_temp = rader_och_Column[j][column - 1];
                rader_och_Column[j][column - 1] = rader_och_Column[j][kollon[i]];
                rader_och_Column[j][kollon[i]] = nummer_temp;

            }
            StdDraw.clear();
            nollan = 0;
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 9; l++) {
                    temp_cards[nollan] = rader_och_Column[l][k];
                    nollan++;
                }
            }

            nollan = 0;
            for (int m = 0; m < 9; m++) {
                for (int a = 0; a < 3; a++) {
                    rader_och_Column[m][a] = temp_cards[nollan];
                    nollan++;
                }
            }
            Y = 1.6;
            X = 0.5;
            for (int o = 0; o < 9; o++) {
                for (int p = 0; p < 3; p++) {
                    StdDraw.picture(X, Y, rader_och_Column[o][p], 0.5, 1.4 * 0.5);
                    X = X + 0.5;
                }
                X = 0.5;
                Y = Y - 0.15;
            }


    }



}


    public static int[] convertTo3(int number) {
        int temp = number - 1;
        int[] array = new int[3];
        for (int i = 2; 0 <= i; i--) {
            array[i] = (int) (temp / Math.pow(3, i));
            temp = (int) (temp % Math.pow(3, i));

        }
        return array;
    }
}