public class Winner{
  private int uTotal;
  private int hTotal;
  private boolean userWon;

  public boolean total(int uTotal, int hTotal){
    this.uTotal = uTotal;
    this.hTotal = hTotal;

    if (uTotal > 21)
    {
      userWon = false;
    } else if (utotal <= hTotal)
    {
      userWon = false;
    } else {
      userWon = true;
    }
    return userWon;
  }
}