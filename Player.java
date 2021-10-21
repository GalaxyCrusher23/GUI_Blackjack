
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;
import java.util.stream.*;

public class Player
{
  public int [] playerHand;
  private int playerCount;
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
    playerTotal = IntStream.of(playerHand).sum();

    if (playerTotal > 21)
    {
      if (checkPlayerAce() == true)
      {
        editPlayerAce();
        playerTotal = IntStream.of(playerHand).sum();
      }
    }
    return playerTotal
  }

  public boolean checkPlayerAce()
  {
    return playerHand.contains(11);
  }

  public void editPlayerAce()
  {
    playerAceIndex = ArrayUtils.indexOf(playerHand, 11);
    playerHand[playerAceIndex] = 1;
  }
}
  