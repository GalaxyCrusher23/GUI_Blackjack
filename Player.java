import java.util.Scanner;
import java.util.stream.*;

public class Player
{
  //Attributes needed for the Player class. The value is obtained when it is called from the Game class
  private static int [] playerHand;
  private static int [] playerSuitHand;
  private static int playerCount;
  private double playerBet;
  private int playerTotal;

  public void setHand(int[] hand)
  {
    //Recieves the current hand from Game class (either from user or object)
    playerHand = hand;
  }

  public int[] getPlayerHand()
  {
    //Returns the updated hand to Game class (to from user or object)    
    return playerHand;
  }

  public void setCount(int count)
  {
    //Recieves the current card count from Game class (either from user or object)
    playerCount = count;
  }
  
  public int getPlayerCount()
  {
    //Returns the updated card count to Game class (to from user or object) after updating it
    playerCount++;
    return playerCount;
  }

  public void setPlayerCards()
  {
    //Using the values from the set method from above, calls the Card generation method and insert it into the index
    playerHand[playerCount] = Cards.getcards();
  }

  public void setSuits(int[] hand)
  {
    //Recieves the current suit array from Game class(either from user or object)
    playerSuitHand = hand;
  }

  public void setPlayerSuits()
  {
    //Using the values from the set method from above, calls the suit method and insert it into the index
    playerSuitHand[playerCount] = Cards.getSuitValue();
  }

  public int[] getPlayerSuits()
  {
    //Returns the updated suit array
    return playerSuitHand;
  }

  public int getPlayerTotal()
  {
    //Returns the player getPlayerTotal

    playerTotal = IntStream.of(playerHand).sum(); //Using an array function, finds the sum of each element
    if (playerTotal > 21) //Checks if the user has busted
    {
      checkPlayerAce(); //Calls checkplayerAce
    }
    return playerTotal; //Returns the total
  }

  private void checkPlayerAce()
  {
    for (int x = 0; x < 5; x++) //Creates a for loop that checks each index
    {
      if (playerHand[x] == 11) //if the user has an ace playing as an 11 instead of 1, replaces the value with 1
      {
        playerHand[x] = 1;
        playerTotal = IntStream.of(playerHand).sum(); //Recalculates the total
        break;
      }
    }
  }
  
}