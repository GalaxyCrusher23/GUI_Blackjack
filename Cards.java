import java.util.Random;

public class Cards{

    //Needs to print the card image!

    private static Random rand = new Random();
    
    /* private static int[][] cards = {{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13},{1,2,3,4,5,6,7,8,9,10,11,12,13}}; */

    private static int[] diamond_cards = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private static int[] heart_cards = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private static int[] club_cards = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private static int[] spade_cards = {1,2,3,4,5,6,7,8,9,10,11,12,13};            
    private static int cardValue = 0;
    private static int suitValue = 0;

    public static void cCards(int[] cards)
    {
      while (cards[cardValue] == 0){
          cardValue = rand.nextInt(13); 
      }
      cards[cardValue] = 0;
    }
    
    public static int getcards() {

      cardValue = rand.nextInt(13);
      suitValue = rand.nextInt(4);


      /* while (cards[suitValue][cardValue] == 0){
        cardValue = rand.nextInt(13); 
      }


      card = cards[suitValue][cardValue];
      cards[suitValue][cardValue] = 0;

      */

      switch (suitValue)
      {
        case 0:
          cCards(diamond_cards);
          break;
        case 1:
          cCards(heart_cards);
          break;
        case 2:
          cCards(club_cards);
          break;
        case 3:
          cCards(spade_cards);
          break;
        default:
          break;
      }

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

    public static void resetCards()
    {
      for (int x = 0; x < 13; x++) 
      {
        diamond_cards[x] = x+1;
        heart_cards[x] = x+1;
        spade_cards[x] = x+1;
        club_cards[x] = x+1;
      }
    }   
}