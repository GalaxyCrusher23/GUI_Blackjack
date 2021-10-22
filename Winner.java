public class Winner{
  private static int uTotal;
  private static int hTotal;
  private static boolean userWon;

  public boolean total(int uTotal, int hTotal){
    this.uTotal = uTotal;
    this.hTotal = hTotal;

    if (uTotal > 21)
    {
      userWon = false;
    } else if (uTotal <= hTotal)
    {
      userWon = false;
    } else {
      userWon = true;
    }
    return userWon;
  }
}