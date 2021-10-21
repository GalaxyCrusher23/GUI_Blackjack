
import java.util.Scanner;

public class Player
{
  public int [] playerHand;
  private int playerCount;
  private double playerBet;

  public void setHand(int[] hand)
  {
    playerHand = hand;
  }

  public int[] getPlayerHand()
  {
    return playerHand;
  }

  public void setCount(int count)
  {
    playerCount = count;
  }
  
  public int getplayerCount()
  {
    return playerCount;
  }

  public void setplayerCards()
  {
    playerHand[playerCount] = Cards.getcards();
    playerCount++;
  }

  public int getplayerTotal()
  {
    return Arrays.stream(playerHand).sum();
  }

  public boolean checkPlayerAce()
  {
    return playerHand.contains(11);
  }

  public void editPlayerAce()
  {
    
  }
}
  