
import java.util.Scanner;
import java.util.stream.*;

public class Player
{
  public static int [] playerHand;
  private static int playerCount;
  private double playerBet;
  private int playerAceIndex;
  private int playerTotal;

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
  
  public int getPlayerCount()
  {
    return playerCount;
  }

  public void setPlayerCards()
  {
    playerHand[playerCount] = Cards.getcards();
    playerCount++;
  }

  public int getPlayerTotal()
  {
    playerTotal = IntStream.of(playerHand).sum();

    if (playerTotal > 21)
    {
      checkPlayerAce();
    }
    return playerTotal;
  }

  public void checkPlayerAce()
  {
    for (int x = 0; x < 5; x++)
    {
      if (playerHand[x] == 11)
      {
        playerHand[x] = 1;
        playerTotal = IntStream.of(playerHand).sum();
        break;
      }
    }
  }
}
  