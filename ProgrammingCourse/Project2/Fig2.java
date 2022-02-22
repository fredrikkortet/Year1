public class Fig2
{
  public static void main(String[] cmdLn)
  {
      int n = Integer.parseInt(cmdLn[0]);

      StdDraw.setXscale(0,n);
      StdDraw.setYscale(0,n);//sätter rutan från, till

      StdDraw.line(0,0,1,1);  // ritar en linje
      StdDraw.line(0,1,1,0);
  }
}
