public class Decode {
    public static void main(String[] args) {
        int Command = Integer.parseInt(args[0]);
        int Number = Integer.parseInt(StdIn.readString());
        String Country = StdIn.readLine();

        while (!StdIn.isEmpty()) {
            if (Command == Number) {
                StdOut.println(Number + " " + Country);
                break;
            } else {
                Number = Integer.parseInt(StdIn.readString());
                Country = StdIn.readLine();
            }
        }
        if (StdIn.isEmpty()) {
            StdOut.println("wrong number");

        }

    }
}
