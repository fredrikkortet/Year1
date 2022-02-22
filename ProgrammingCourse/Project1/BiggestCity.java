public class BiggestCity {
    public static void main(String[] cmdLn) {
        //StdIn.readLine();
        int temp1[] = new int[4];
        int temp2[] = new int[4];
        temp1[0] = Integer.parseInt(StdIn.readString());
        temp1[1] = Integer.parseInt(StdIn.readString());
        temp1[2] = Integer.parseInt(StdIn.readString());
        temp1[3] = Integer.parseInt(StdIn.readString());
        double temp3 = Double.parseDouble(StdIn.readString());
        temp2[0] = Integer.parseInt(StdIn.readString());
        temp2[1] = Integer.parseInt(StdIn.readString());
        temp2[2] = Integer.parseInt(StdIn.readString());
        temp2[3] = Integer.parseInt(StdIn.readString());
        double temp4 = Double.parseDouble(StdIn.readString());

        while (!StdIn.isEmpty()) {

            if (temp1[2] == 1 || temp1[2] == 2) {
                temp1[0] = Integer.parseInt(StdIn.readString());
                temp1[1] = Integer.parseInt(StdIn.readString());
                temp1[2] = Integer.parseInt(StdIn.readString());
                temp1[3] = Integer.parseInt(StdIn.readString());
                temp3 = Double.parseDouble(StdIn.readString());

            }
            if (temp2[2] == 1 || temp2[2] == 2) {


            } else if (temp1[2] == 0 && temp2[2] == 0) {
                if (temp3 < temp4) {
                    temp1[0] = temp2[0];
                    temp1[1] = temp2[1];
                    temp1[2] = temp2[2];
                    temp1[3] = temp2[3];
                    temp3 = temp4;
                }

            }

            temp2[0] = Integer.parseInt(StdIn.readString());
            temp2[1] = Integer.parseInt(StdIn.readString());
            temp2[2] = Integer.parseInt(StdIn.readString());
            temp2[3] = Integer.parseInt(StdIn.readString());
            temp4 = Double.parseDouble(StdIn.readString());

        }
        StdOut.println(temp1[0] + " " + temp1[1] +
                " " + temp1[3] + " " + temp3);
    }
}
