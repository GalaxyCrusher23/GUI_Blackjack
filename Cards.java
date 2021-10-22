import java.util.Random;

public class Cards{

    //Needs to print the card image!

    //maybe an error in the future

    private static Random rand = new Random();
    
    private static int[][] cards = {{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13}};
    private static int cardValue = 0;
    private static int suitValue = 0;
    
    public static int getcards() {
      cardValue = rand.nextInt(13)+1;
      suitValue = rand.nextInt(4)+1;

      if (cards[suitValue][cardValue] == 0) 
        {
        while (true){
           cardValue = rand.nextInt(13)+1; 
        }
      }

      if (cardValue == 1 ){
          cardValue = 11;
      }

      cards[suitValue][cardValue] = 0;
      return cardValue;
    }

   //public int getsuitsValue() {
   // return suitValue;
   // }

    public static void resetCards()
    {
      for (int x = 0; x < 4; x++)
      {
        for (int y= 0; y < 13; y++) 
        {
          cards[x][y] = y+1;
        }
      }
    }   
}