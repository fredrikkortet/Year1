public class DiagonalDots
{
  public static void main(String[] cmdLn)
  {
      int n = Integer.parseInt(cmdLn[0]);
      int b = n*(-1);
      StdDraw.setXscale(-n,n);
      StdDraw.setYscale(-n,n);

      for (int i = n; i >= -n; i--)
      {

        StdDraw.filledCircle(i,i,0.5);
        StdDraw.filledCircle(b,i,0.5);
        b++;
        

      }
  }
}
