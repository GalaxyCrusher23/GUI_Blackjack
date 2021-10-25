import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Cards{

    private static Random rand = new Random();
    
    private static int[][] cards = {{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13}};    
    private static int cardValue;
    private static int suitValue;
    public static int suitColours;

    public static int getcards(){

      cardValue = rand.nextInt(13);
      suitValue = rand.nextInt(4);


      while (cards[suitValue][cardValue] == -1){
        cardValue = rand.nextInt(13); 
        suitValue = rand.nextInt(4);
      }

      cards[suitValue][cardValue] = -1;
      
      cardValue = cardValue+1;

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