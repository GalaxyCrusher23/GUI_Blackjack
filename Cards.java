import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Cards{

    private static Random rand = new Random(); //Create random object to generate random numbers
    private static int[][] cards = {{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13}}; //2D array that represents the 52 cards    
    private static int cardValue; //Represents the value of the cards (second index for 2d array)
    private static int suitValue; //Represent the suit of the cards (first index of 2d array)
    public static int suitColours; //Represents the colour of the suits (either red or black)

    public static int getcards(){
      //Picks a random card from the deck, and removes the option to choose the card again

      //Genereates the random card
      cardValue = rand.nextInt(13);
      suitValue = rand.nextInt(4);

      //Checks if the card was already chosen
      while (cards[suitValue][cardValue] == -1){
        //Genereates a new card if previous card was chosen
        cardValue = rand.nextInt(13); 
        suitValue = rand.nextInt(4);
      }

      //Replaces the card with -1, signaling it should not be chosen again
      cards[suitValue][cardValue] = -1;
      
      //Adds 1 to the cardValue (Instead of being 1-13, it's 0-12)
      cardValue = cardValue+1;

      //Checks if the card was a special card(Ace or Face cards)
      switch (cardValue)
      {
        case 1:
          cardValue = 11;
          break;
        case 11:
        case 12:
        case 13:
          cardValue = 10;
          break;
        default:
          break;
      }

      return cardValue;
    }

    public static int getSuitValue()
    {
      switch (suitValue)
      {
        case 0: case 1:
          suitColours = 0;
          break;
        case 2: case 3:
          suitColours = 1;
          break;
        default:
          break;
      }
      return suitColours;
    }

    public static void resetCards()
    {
      for (int x = 0; x < 4; x++)
      {
        for (int y = 0; y < 13; y++)
        {
          cards[x][y] = y+1;
        }
      }
    }   
}