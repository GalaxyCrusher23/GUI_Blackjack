import java.util.Random;

public class Cards{

    //Needs to print the card image!

    private static Random rand = new Random();
    
    private static int[][] cards = {{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13}};
    private static int cardValue = 0;
    private static int suitValue = 0;
    private static int card = 0;
    
    public static int getcards() {
      cardValue = rand.nextInt(13);
      suitValue = rand.nextInt(4);


      while (cards[suitValue][cardValue] == 0){
        cardValue = rand.nextInt(13); 
      }


      card = cards[suitValue][cardValue];
      cards[suitValue][cardValue] = 0;

      if (card == 1){
          card = 11;
      } else if (card > 10){
        card = 10;
      }
      return card;
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